package net.kuper.tz.common.dao;

import net.kuper.tz.common.entity.SmsLogEntity;
import net.kuper.tz.common.entity.SmsLogQueryEntity;
import net.kuper.tz.common.entity.SmsLogUpdateEntity;

import java.util.List;

/**
 * 短信日志
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
public interface SmsLogDao {

    /**
     * 短信日志详情
     *
     * @param id
     * @return
     */
    SmsLogEntity queryObject(String id);

    /**
     *  短信日志列表
     *
     * @param smsLogQueryEntity
     * @return
     */
    List<SmsLogEntity> queryList(SmsLogQueryEntity smsLogQueryEntity);

    /**
     * 短信日志新增
     *
     * @param smsLogUpdateEntity
     */
    void save(SmsLogUpdateEntity smsLogUpdateEntity);

    /**
     *  短信日志修改
     *
     * @param smsLogUpdateEntity
     */
    void update(SmsLogUpdateEntity smsLogUpdateEntity);

    /**
     * 短信日志单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 短信日志批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
