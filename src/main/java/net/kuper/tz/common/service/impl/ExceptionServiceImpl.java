package net.kuper.tz.common.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.common.dao.ExceptionCaseDao;
import net.kuper.tz.common.dao.ExceptionDao;
import net.kuper.tz.common.entity.ExceptionCaseUpdateEntity;
import net.kuper.tz.common.entity.ExceptionEntity;
import net.kuper.tz.common.entity.ExceptionQueryEntity;
import net.kuper.tz.common.entity.ExceptionUpdateEntity;
import net.kuper.tz.common.service.ExceptionService;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.core.properties.BuildProperties;
import net.kuper.tz.core.utils.DateUtils;
import net.kuper.tz.core.utils.HttpServletUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 系统错误Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-18 22:50:46
 */
@Service("exceptionService")
public class ExceptionServiceImpl implements ExceptionService {
    @Autowired
    private ExceptionDao exceptionDao;
    @Autowired
    private ExceptionCaseDao exceptionCaseDao;

    @Autowired
    private BuildProperties properties;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Pagination<ExceptionEntity> queryList(ExceptionQueryEntity exceptionQueryEntity) {
        PageHelper.startPage(exceptionQueryEntity.getPage(), exceptionQueryEntity.getPageSize());
        List<ExceptionEntity> exceptionList = exceptionDao.queryList(exceptionQueryEntity);
        return new Pagination<ExceptionEntity>(exceptionList);
    }

    @Override
    public ExceptionEntity queryObject(String id) {
        return exceptionDao.queryObject(id);
    }

    @Override
    public void onException(Exception exception) {
        HttpServletRequest request = HttpServletUtils.getHttpServletRequest();
        String servletPath = null;
        if (request != null) {
            servletPath = request.getServletPath();
        }
        String clazz = null;
        String method = null;
        Integer lineNum = null;
        String type = exception.getClass().getSimpleName();
        if (exception.getStackTrace().length > 0) {
            clazz = exception.getStackTrace()[0].getClassName();
            method = exception.getStackTrace()[0].getMethodName();
            lineNum = exception.getStackTrace()[0].getLineNumber();
        }

        ExceptionQueryEntity queryEntity = new ExceptionQueryEntity();
        queryEntity.setClazz(clazz);
        queryEntity.setMethod(method);
        queryEntity.setLineNum(lineNum);
        queryEntity.setType(type);
        String exceptionId = null;
        ExceptionEntity entity = exceptionDao.querySameException(queryEntity);
        if (entity != null) {
            exceptionId = entity.getId();
        } else {
            ExceptionUpdateEntity updateEntity = new ExceptionUpdateEntity();
            updateEntity.setClazz(clazz);
            updateEntity.setMethod(method);
            updateEntity.setLineNum(lineNum);
            updateEntity.setType(type);
            updateEntity.setError(ExceptionUtils.getStackTrace(exception));
            updateEntity.setMessage(ExceptionUtils.getMessage(exception));
            updateEntity.setCreateTime(new Date());
            updateEntity.setFixStatus(0);
            exceptionDao.save(updateEntity);
            exceptionId = updateEntity.getId();
        }
        ExceptionCaseUpdateEntity caseUpdateEntity = new ExceptionCaseUpdateEntity();
        caseUpdateEntity.setCreateTime(new Date());
        caseUpdateEntity.setSerVersion(properties.getVersion());
        caseUpdateEntity.setExceptionId(exceptionId);
        caseUpdateEntity.setServletPath(servletPath);
        caseUpdateEntity.setSerBuildTime(DateUtils.string2Date(properties.getTime(), dateFormat));
        exceptionCaseDao.save(caseUpdateEntity);
    }


    @Override
    public void update(ExceptionUpdateEntity exceptionUpdateEntity) {
        ExceptionUpdateEntity entity = new ExceptionUpdateEntity();
        entity.setId(exceptionUpdateEntity.getId());
        entity.setFixStatus(exceptionUpdateEntity.getFixStatus());
        exceptionDao.update(entity);
    }

    @Override
    public void delete(String id) {
        exceptionDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        exceptionDao.deleteBatch(ids);
    }
}
