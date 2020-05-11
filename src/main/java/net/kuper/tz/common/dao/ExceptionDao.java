package net.kuper.tz.common.dao;

import net.kuper.tz.common.entity.ExceptionEntity;
import net.kuper.tz.common.entity.ExceptionQueryEntity;
import net.kuper.tz.common.entity.ExceptionUpdateEntity;

import java.util.List;

/**
 * 系统错误
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-18 22:50:46
 */
public interface ExceptionDao {

    /**
     * 系统错误详情
     *
     * @param id
     * @return
     */
    ExceptionEntity queryObject(String id);

    /**
     * 查询相同异常，未修复的。
     * @param exceptionQueryEntity
     * @return
     */
    ExceptionEntity querySameException(ExceptionQueryEntity exceptionQueryEntity);

    /**
     * 系统错误列表
     *
     * @param exceptionQueryEntity
     * @return
     */
    List<ExceptionEntity> queryList(ExceptionQueryEntity exceptionQueryEntity);

    /**
     * 系统错误新增
     *
     * @param exceptionUpdateEntity
     */
    void save(ExceptionUpdateEntity exceptionUpdateEntity);

    /**
     * 系统错误修改
     *
     * @param exceptionUpdateEntity
     */
    void update(ExceptionUpdateEntity exceptionUpdateEntity);

    /**
     * 系统错误单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 系统错误批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
