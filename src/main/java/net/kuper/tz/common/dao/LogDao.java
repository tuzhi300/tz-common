package net.kuper.tz.common.dao;

import net.kuper.tz.common.entity.LogEntity;
import net.kuper.tz.common.entity.LogQueryEntity;
import net.kuper.tz.common.entity.LogUpdateEntity;

import java.util.List;

/**
 * 系统日志
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 17:29:34
 */
public interface LogDao {

    /**
     * 系统日志详情
     *
     * @param id
     * @return
     */
    LogEntity queryObject(String id);

    /**
     *  系统日志列表
     *
     * @param logQueryEntity
     * @return
     */
    List<LogEntity> queryList(LogQueryEntity logQueryEntity);

    /**
     * 系统日志新增
     *
     * @param logUpdateEntity
     */
    void save(LogUpdateEntity logUpdateEntity);

    /**
     *  系统日志修改
     *
     * @param logUpdateEntity
     */
    void update(LogUpdateEntity logUpdateEntity);

    /**
     * 系统日志单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 系统日志批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
