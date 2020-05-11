package net.kuper.tz.common.service;

import net.kuper.tz.common.entity.ExceptionCaseEntity;
import net.kuper.tz.common.entity.ExceptionCaseQueryEntity;
import net.kuper.tz.common.entity.ExceptionCaseUpdateEntity;
import net.kuper.tz.core.mybatis.Pagination;

/**
 * 
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-18 22:50:46
 */
public interface ExceptionCaseService {

    /**
     * 分页查询:
     *
     * @param exceptionCaseQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<ExceptionCaseEntity> queryList(ExceptionCaseQueryEntity exceptionCaseQueryEntity);

    /**
      * 详情查询
      *
      * @param id
      * @return 
      */
    ExceptionCaseEntity queryObject(String id);

    /**
     * 新增：
     *
     * @param exceptionCaseUpdateEntity
     * @return 
     */
     ExceptionCaseEntity save(ExceptionCaseUpdateEntity exceptionCaseUpdateEntity);

    /**
     * 修改 
     *
     * @param exceptionCaseUpdateEntity
     * @return
     */
    void update(ExceptionCaseUpdateEntity exceptionCaseUpdateEntity);

    /**
     * 单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

