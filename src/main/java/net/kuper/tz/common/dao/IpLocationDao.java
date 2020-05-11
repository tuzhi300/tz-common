package net.kuper.tz.common.dao;

import net.kuper.tz.common.entity.IpLocationEntity;
import net.kuper.tz.common.entity.IpLocationQueryEntity;
import net.kuper.tz.common.entity.IpLocationUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-20 01:18:37
 */
public interface IpLocationDao {

    /**
     * 详情
     *
     * @param id
     * @return
     */
    IpLocationEntity queryObject(String id);

    /**
     * 查询上一条IP定位信息
     *
     * @param ip
     * @return
     */
    IpLocationEntity queryLastObj(@Param("ip") String ip);

    /**
     * 查询最近未解析的数据
     *
     * @param limit
     * @return
     */
    List<IpLocationEntity> queryLastNotParse(@Param("limit") Integer limit);

    /**
     * 列表
     *
     * @param ipLocationQueryEntity
     * @return
     */
    List<IpLocationEntity> queryList(IpLocationQueryEntity ipLocationQueryEntity);

    /**
     * 新增
     *
     * @param ipLocationUpdateEntity
     */
    void save(IpLocationUpdateEntity ipLocationUpdateEntity);

    /**
     * 修改
     *
     * @param ipLocationUpdateEntity
     */
    void update(IpLocationUpdateEntity ipLocationUpdateEntity);

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
