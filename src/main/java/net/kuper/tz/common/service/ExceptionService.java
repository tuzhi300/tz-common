package net.kuper.tz.common.service;

import net.kuper.tz.common.entity.ExceptionEntity;
import net.kuper.tz.common.entity.ExceptionQueryEntity;
import net.kuper.tz.common.entity.ExceptionUpdateEntity;
import net.kuper.tz.core.mybatis.Pagination;

/**
 * 系统错误
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-18 22:50:46
 */
public interface ExceptionService {

    /**
     * 分页查询:系统错误
     *
     * @param exceptionQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<ExceptionEntity> queryList(ExceptionQueryEntity exceptionQueryEntity);

    /**
      * 系统错误详情查询
      *
      * @param id
      * @return 系统错误
      */
    ExceptionEntity queryObject(String id);

    /**
     * 新增：系统错误
     *
     * @param exception
     * @return 系统错误
     */
     void onException(Exception exception);

    /**
     * 修改 系统错误
     *
     * @param exceptionUpdateEntity
     * @return
     */
    void update(ExceptionUpdateEntity exceptionUpdateEntity);

    /**
     * 系统错误单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 系统错误批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

