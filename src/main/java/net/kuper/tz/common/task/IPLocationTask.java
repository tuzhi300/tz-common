package net.kuper.tz.common.task;

import net.kuper.tz.apitool.entity.BMapIPLocation;
import net.kuper.tz.apitool.service.BMapService;
import net.kuper.tz.common.entity.IpLocationEntity;
import net.kuper.tz.common.entity.IpLocationUpdateEntity;
import net.kuper.tz.common.service.IpLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("ipLocationTask")
public class IPLocationTask {

    @Autowired
    private IpLocationService ipLocationService;
    @Autowired
    private BMapService bMapService;

    @Value("${tz.bmap.ak}")
    private String bmapAK;

    public void bmapParseLoacation() {
        List<IpLocationEntity> ipLocationEntityList = ipLocationService.queryLastNotParse(100);
        if (ipLocationEntityList != null && ipLocationEntityList.size() > 0) {
            for (IpLocationEntity locationEntity : ipLocationEntityList) {
                try {
                    BMapIPLocation bMapIPLocation = bMapService.getIpLocation(bmapAK, locationEntity.getIp(), "bd09ll")
                            .execute()
                            .body();
                    if (bMapIPLocation != null && bMapIPLocation.getStatus() == 0) {
                        IpLocationUpdateEntity updateEntity = new IpLocationUpdateEntity();
                        updateEntity.setId(locationEntity.getId());
                        updateEntity.setStatus(1);
                        updateEntity.setSource(1);
                        updateEntity.setAddress(bMapIPLocation.getAddress());
                        if (bMapIPLocation.getContent() != null) {
                            BMapIPLocation.ContentBean contentBean = bMapIPLocation.getContent();
                            updateEntity.setShortAddress(contentBean.getAddress());
                            if (contentBean.getAddressDetail() != null) {
                                BMapIPLocation.ContentBean.AddressDetailBean addressDetailBean = contentBean.getAddressDetail();
                                updateEntity.setCity(addressDetailBean.getCity());
                                updateEntity.setCityCode(addressDetailBean.getCityCode());
                                updateEntity.setDistrict(addressDetailBean.getDistrict());
                                updateEntity.setProvince(addressDetailBean.getProvince());
                            }
                            if (contentBean.getPoint() != null) {
                                BMapIPLocation.ContentBean.PointBean point = contentBean.getPoint();
                                updateEntity.setCenterX(point.getX());
                                updateEntity.setCenterY(point.getY());
                            }
                        }
                        ipLocationService.update(updateEntity);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
