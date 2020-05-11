package net.kuper.tz.common.service;

import net.kuper.tz.common.entity.IpLocationEntity;
import net.kuper.tz.common.entity.IpLocationQueryEntity;
import net.kuper.tz.common.entity.IpLocationUpdateEntity;
import net.kuper.tz.core.mybatis.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-20 01:18:37
 */
public interface IpLocationService {

    /**
     * 分页查询:
     *
     * @param ipLocationQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<IpLocationEntity> queryList(IpLocationQueryEntity ipLocationQueryEntity);

    /**
      * 详情查询
      *
      * @param id
      * @return 
      */
    IpLocationEntity queryObject(String id);

    /**
     * 查询最近未解析的数据
     *
     * @param limit
     * @return
     */
    List<IpLocationEntity> queryLastNotParse(@Param("limit") Integer limit);

    /**
     * 新增：
     *
     * @param ipLocationUpdateEntity
     * @return 
     */
     IpLocationEntity save(IpLocationUpdateEntity ipLocationUpdateEntity);

    /**
     * 修改 
     *
     * @param ipLocationUpdateEntity
     * @return
     */
    void update(IpLocationUpdateEntity ipLocationUpdateEntity);

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

