package net.kuper.tz.common.dao;

import net.kuper.tz.common.entity.AreaEntity;
import net.kuper.tz.common.entity.AreaQueryEntity;
import net.kuper.tz.common.entity.AreaUpdateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 区域
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
public interface AreaDao {

    /**
     * 区域详情
     *
     * @param id
     * @return
     */
    AreaEntity queryObject(Integer id);

    /**
     * 区域列表
     *
     * @param areaQueryEntity
     * @return
     */
    List<AreaEntity> queryList(AreaQueryEntity areaQueryEntity);

    /**
     * 获取id路径
     *
     * @param id
     * @return
     */
    String getPath(@Param("id") Integer id);

    /**
     * 区域新增
     *
     * @param areaUpdateEntity
     */
    void save(AreaUpdateEntity areaUpdateEntity);

    /**
     * 区域修改
     *
     * @param areaUpdateEntity
     */
    void update(AreaUpdateEntity areaUpdateEntity);

    /**
     * 区域单条删除
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 区域批量删除
     *
     * @param ids
     */
    void deleteBatch(Integer[] ids);
}
