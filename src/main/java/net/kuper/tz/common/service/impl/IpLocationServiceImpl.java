package net.kuper.tz.common.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.common.dao.IpLocationDao;
import net.kuper.tz.common.entity.IpLocationEntity;
import net.kuper.tz.common.entity.IpLocationQueryEntity;
import net.kuper.tz.common.entity.IpLocationUpdateEntity;
import net.kuper.tz.common.service.IpLocationService;
import net.kuper.tz.core.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-20 01:18:37
 */
@Service("ipLocationService")
public class IpLocationServiceImpl implements IpLocationService {

    @Autowired
    private IpLocationDao ipLocationDao;

    @Override
    public Pagination<IpLocationEntity> queryList(IpLocationQueryEntity ipLocationQueryEntity) {
        PageHelper.startPage(ipLocationQueryEntity.getPage(), ipLocationQueryEntity.getPageSize());
        List<IpLocationEntity> ipLocationList = ipLocationDao.queryList(ipLocationQueryEntity);
        return new Pagination<IpLocationEntity>(ipLocationList);
    }

    @Override
    public IpLocationEntity queryObject(String id) {
        return ipLocationDao.queryObject(id);
    }

    @Override
    public List<IpLocationEntity> queryLastNotParse(Integer limit) {
        return ipLocationDao.queryLastNotParse(limit);
    }

    @Override
    public IpLocationEntity save(IpLocationUpdateEntity ipLocationUpdateEntity) {
        ipLocationDao.save(ipLocationUpdateEntity);
        return ipLocationDao.queryObject(ipLocationUpdateEntity.getId());
    }

    @Override
    public void update(IpLocationUpdateEntity ipLocationUpdateEntity) {
        ipLocationDao.update(ipLocationUpdateEntity);
    }

    @Override
    public void delete(String id) {
        ipLocationDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        ipLocationDao.deleteBatch(ids);
    }
}
