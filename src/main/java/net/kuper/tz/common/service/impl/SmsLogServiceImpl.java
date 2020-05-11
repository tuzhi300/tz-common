package net.kuper.tz.common.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.common.dao.SmsLogDao;
import net.kuper.tz.common.entity.SmsLogEntity;
import net.kuper.tz.common.entity.SmsLogQueryEntity;
import net.kuper.tz.common.entity.SmsLogUpdateEntity;
import net.kuper.tz.common.service.SmsLogService;
import net.kuper.tz.core.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 短信日志Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
@Service("smsLogService" )
public class SmsLogServiceImpl implements SmsLogService {

    @Autowired
    private SmsLogDao smsLogDao;

    @Override
    public Pagination<SmsLogEntity> queryList(SmsLogQueryEntity smsLogQueryEntity) {
        PageHelper.startPage(smsLogQueryEntity.getPage(), smsLogQueryEntity.getPageSize());
        List<SmsLogEntity> smsLogList = smsLogDao.queryList(smsLogQueryEntity);
        return new Pagination<SmsLogEntity>(smsLogList);
    }

    @Override
    public SmsLogEntity queryObject(String id) {
        return smsLogDao.queryObject(id);
    }

    @Override
    public SmsLogEntity save(SmsLogUpdateEntity smsLogUpdateEntity) {
        smsLogDao.save(smsLogUpdateEntity);
        return smsLogDao.queryObject(smsLogUpdateEntity.getId());
    }

    @Override
    public void update(SmsLogUpdateEntity smsLogUpdateEntity) {
        smsLogDao.update(smsLogUpdateEntity);
    }

    @Override
    public void delete(String id) {
        smsLogDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        smsLogDao.deleteBatch(ids);
    }
}
