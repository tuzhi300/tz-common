package net.kuper.tz.common.service;

import net.kuper.tz.common.entity.SmsLogEntity;
import net.kuper.tz.common.entity.SmsLogQueryEntity;
import net.kuper.tz.common.entity.SmsLogUpdateEntity;
import net.kuper.tz.core.mybatis.Pagination;

/**
 * 短信日志
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
public interface SmsLogService {

    /**
     * 分页查询:短信日志
     *
     * @param smsLogQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<SmsLogEntity> queryList(SmsLogQueryEntity smsLogQueryEntity);

    /**
      * 短信日志详情查询
      *
      * @param id
      * @return 短信日志
      */
    SmsLogEntity queryObject(String id);

    /**
     * 新增：短信日志
     *
     * @param smsLogUpdateEntity
     * @return 短信日志
     */
     SmsLogEntity save(SmsLogUpdateEntity smsLogUpdateEntity);

    /**
     * 修改 短信日志
     *
     * @param smsLogUpdateEntity
     * @return
     */
    void update(SmsLogUpdateEntity smsLogUpdateEntity);

    /**
     * 短信日志单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 短信日志批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

