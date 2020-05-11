package net.kuper.tz.common.service;

import net.kuper.tz.common.entity.RequestLimitEntity;
import net.kuper.tz.common.entity.RequestLimitQueryEntity;
import net.kuper.tz.common.entity.RequestLimitUpdateEntity;
import net.kuper.tz.core.mybatis.Pagination;

import java.util.Date;

/**
 * 请求限制
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
public interface RequestLimitService {

    /**
     * 分页查询:请求限制
     *
     * @param requestLimitQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<RequestLimitEntity> queryList(RequestLimitQueryEntity requestLimitQueryEntity);

    /**
     * 请求限制详情查询
     *
     * @param id
     * @return 请求限制
     */
    RequestLimitEntity queryObject(String id);

    /**
     * 查询该用户有效时间段内请求次数
     *
     * @param limitId
     * @param userId
     * @param date
     * @return
     */
    Long queryUserCount(String limitId, String userId, Date date);

    /**
     * 查询该会话有效时间段内请求次数
     *
     * @param limitId
     * @param sessionId
     * @param date
     * @return
     */
    Long querySessionCount(String limitId, String sessionId, Date date);

    /**
     * 新增：请求限制
     *
     * @param requestLimitUpdateEntity
     * @return 请求限制
     */
    RequestLimitEntity save(RequestLimitUpdateEntity requestLimitUpdateEntity);

    /**
     * 修改 请求限制
     *
     * @param requestLimitUpdateEntity
     * @return
     */
    void update(RequestLimitUpdateEntity requestLimitUpdateEntity);

    /**
     * 请求限制单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 请求限制批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

