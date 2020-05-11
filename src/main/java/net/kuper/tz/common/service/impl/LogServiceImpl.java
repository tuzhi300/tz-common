package net.kuper.tz.common.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.common.dao.IpLocationDao;
import net.kuper.tz.common.dao.LogDao;
import net.kuper.tz.common.entity.*;
import net.kuper.tz.common.service.LogService;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.core.properties.BuildProperties;
import net.kuper.tz.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 系统日志Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 17:29:34
 */
@Service("logService")
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    @Autowired
    private IpLocationDao locationDao;
    @Autowired
    private BuildProperties buildProperties;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Pagination<LogEntity> queryList(LogQueryEntity logQueryEntity) {
        PageHelper.startPage(logQueryEntity.getPage(), logQueryEntity.getPageSize());
        List<LogEntity> logList = logDao.queryList(logQueryEntity);
        return new Pagination<LogEntity>(logList);
    }

    @Override
    public LogEntity queryObject(String id) {
        return logDao.queryObject(id);
    }

    @Override
    public LogEntity save(LogUpdateEntity logUpdateEntity) {
        String locationId = null;
        IpLocationEntity locationEntity = locationDao.queryLastObj(logUpdateEntity.getIp());
        if (locationEntity != null) {
            locationId = locationEntity.getId();
        } else {
            IpLocationUpdateEntity updateEntity = new IpLocationUpdateEntity();
            updateEntity.setIp(logUpdateEntity.getIp());
            locationDao.save(updateEntity);
            locationId = updateEntity.getId();
        }

        logUpdateEntity.setIpLocationId(locationId);
        logUpdateEntity.setSerVersion(buildProperties.getVersion());
        logUpdateEntity.setSerBuildTime(DateUtils.string2Date(buildProperties.getTime(), dateFormat));
        logDao.save(logUpdateEntity);
        return logDao.queryObject(logUpdateEntity.getId());
    }

    @Override
    public void update(LogUpdateEntity logUpdateEntity) {
        logDao.update(logUpdateEntity);
    }

    @Override
    public void delete(String id) {
        logDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        logDao.deleteBatch(ids);
    }
}
