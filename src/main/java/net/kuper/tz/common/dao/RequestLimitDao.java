package net.kuper.tz.common.dao;

import net.kuper.tz.common.entity.RequestLimitEntity;
import net.kuper.tz.common.entity.RequestLimitQueryEntity;
import net.kuper.tz.common.entity.RequestLimitUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 请求限制
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
public interface RequestLimitDao {

    /**
     * 请求限制详情
     *
     * @param id
     * @return
     */
    RequestLimitEntity queryObject(String id);

    /**
     * 请求限制列表
     *
     * @param requestLimitQueryEntity
     * @return
     */
    List<RequestLimitEntity> queryList(RequestLimitQueryEntity requestLimitQueryEntity);

    /**
     * 查询该用户有效时间段内请求次数
     *
     * @param limitId
     * @param userId
     * @param date
     * @return
     */
    Long queryUserCount(@Param("limitId") String limitId, @Param("userId") String userId, @Param("date") Date date);

    /**
     * 查询该会话有效时间段内请求次数
     *
     * @param limitId
     * @param sessionId
     * @param date
     * @return
     */
    Long querySessionCount(@Param("limitId") String limitId, @Param("sessionId") String sessionId, @Param("date") Date date);

    /**
     * 请求限制新增
     *
     * @param requestLimitUpdateEntity
     */
    void save(RequestLimitUpdateEntity requestLimitUpdateEntity);

    /**
     * 请求限制修改
     *
     * @param requestLimitUpdateEntity
     */
    void update(RequestLimitUpdateEntity requestLimitUpdateEntity);

    /**
     * 请求限制单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 请求限制批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
