package net.kuper.tz.common.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.common.dao.ExceptionCaseDao;
import net.kuper.tz.common.entity.ExceptionCaseEntity;
import net.kuper.tz.common.entity.ExceptionCaseQueryEntity;
import net.kuper.tz.common.entity.ExceptionCaseUpdateEntity;
import net.kuper.tz.common.service.ExceptionCaseService;
import net.kuper.tz.core.mybatis.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-18 22:50:46
 */
@Service("exceptionCaseService" )
public class ExceptionCaseServiceImpl implements ExceptionCaseService {

    @Autowired
    private ExceptionCaseDao exceptionCaseDao;

    @Override
    public Pagination<ExceptionCaseEntity> queryList(ExceptionCaseQueryEntity exceptionCaseQueryEntity) {
        PageHelper.startPage(exceptionCaseQueryEntity.getPage(), exceptionCaseQueryEntity.getPageSize());
        List<ExceptionCaseEntity> exceptionCaseList = exceptionCaseDao.queryList(exceptionCaseQueryEntity);
        return new Pagination<ExceptionCaseEntity>(exceptionCaseList);
    }

    @Override
    public ExceptionCaseEntity queryObject(String id) {
        return exceptionCaseDao.queryObject(id);
    }

    @Override
    public ExceptionCaseEntity save(ExceptionCaseUpdateEntity exceptionCaseUpdateEntity) {
        exceptionCaseDao.save(exceptionCaseUpdateEntity);
        return exceptionCaseDao.queryObject(exceptionCaseUpdateEntity.getId());
    }

    @Override
    public void update(ExceptionCaseUpdateEntity exceptionCaseUpdateEntity) {
        exceptionCaseDao.update(exceptionCaseUpdateEntity);
    }

    @Override
    public void delete(String id) {
        exceptionCaseDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        exceptionCaseDao.deleteBatch(ids);
    }
}
