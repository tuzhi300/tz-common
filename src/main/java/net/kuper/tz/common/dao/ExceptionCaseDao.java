package net.kuper.tz.common.dao;

import net.kuper.tz.common.entity.ExceptionCaseEntity;
import net.kuper.tz.common.entity.ExceptionCaseQueryEntity;
import net.kuper.tz.common.entity.ExceptionCaseUpdateEntity;

import java.util.List;

/**
 * 
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-18 22:50:46
 */
public interface ExceptionCaseDao {

    /**
     * 详情
     *
     * @param id
     * @return
     */
    ExceptionCaseEntity queryObject(String id);

    /**
     *  列表
     *
     * @param exceptionCaseQueryEntity
     * @return
     */
    List<ExceptionCaseEntity> queryList(ExceptionCaseQueryEntity exceptionCaseQueryEntity);

    /**
     * 新增
     *
     * @param exceptionCaseUpdateEntity
     */
    void save(ExceptionCaseUpdateEntity exceptionCaseUpdateEntity);

    /**
     *  修改
     *
     * @param exceptionCaseUpdateEntity
     */
    void update(ExceptionCaseUpdateEntity exceptionCaseUpdateEntity);

    /**
     * 单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
