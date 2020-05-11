package net.kuper.tz.common.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.common.dao.RequestLimitDao;
import net.kuper.tz.common.entity.RequestLimitEntity;
import net.kuper.tz.common.entity.RequestLimitQueryEntity;
import net.kuper.tz.common.entity.RequestLimitUpdateEntity;
import net.kuper.tz.common.service.RequestLimitService;
import net.kuper.tz.core.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 请求限制Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
@Service("requestLimitService" )
public class RequestLimitServiceImpl implements RequestLimitService {

    @Autowired
    private RequestLimitDao requestLimitDao;

    @Override
    public Pagination<RequestLimitEntity> queryList(RequestLimitQueryEntity requestLimitQueryEntity) {
        PageHelper.startPage(requestLimitQueryEntity.getPage(), requestLimitQueryEntity.getPageSize());
        List<RequestLimitEntity> requestLimitList = requestLimitDao.queryList(requestLimitQueryEntity);
        return new Pagination<RequestLimitEntity>(requestLimitList);
    }

    @Override
    public RequestLimitEntity queryObject(String id) {
        return requestLimitDao.queryObject(id);
    }

    @Override
    public Long queryUserCount(String limitId, String userId, Date date) {
        return requestLimitDao.queryUserCount(limitId,userId,date);
    }

    @Override
    public Long querySessionCount(String limitId, String sessionId, Date date) {
        return requestLimitDao.querySessionCount(limitId,sessionId,date);
    }

    @Override
    public RequestLimitEntity save(RequestLimitUpdateEntity requestLimitUpdateEntity) {
        requestLimitDao.save(requestLimitUpdateEntity);
        return requestLimitDao.queryObject(requestLimitUpdateEntity.getId());
    }

    @Override
    public void update(RequestLimitUpdateEntity requestLimitUpdateEntity) {
        requestLimitDao.update(requestLimitUpdateEntity);
    }

    @Override
    public void delete(String id) {
        requestLimitDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        requestLimitDao.deleteBatch(ids);
    }
}
