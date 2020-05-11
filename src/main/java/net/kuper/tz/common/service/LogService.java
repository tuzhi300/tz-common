package net.kuper.tz.common.service;

import net.kuper.tz.common.entity.LogEntity;
import net.kuper.tz.common.entity.LogQueryEntity;
import net.kuper.tz.common.entity.LogUpdateEntity;
import net.kuper.tz.core.mybatis.Pagination;

/**
 * 系统日志
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 17:29:34
 */
public interface LogService {

    /**
     * 分页查询:系统日志
     *
     * @param logQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<LogEntity> queryList(LogQueryEntity logQueryEntity);

    /**
      * 系统日志详情查询
      *
      * @param id
      * @return 系统日志
      */
    LogEntity queryObject(String id);

    /**
     * 新增：系统日志
     *
     * @param logUpdateEntity
     * @return 系统日志
     */
     LogEntity save(LogUpdateEntity logUpdateEntity);

    /**
     * 修改 系统日志
     *
     * @param logUpdateEntity
     * @return
     */
    void update(LogUpdateEntity logUpdateEntity);

    /**
     * 系统日志单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 系统日志批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

