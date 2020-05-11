package net.kuper.tz.common.service;

import net.kuper.tz.common.entity.AreaEntity;
import net.kuper.tz.common.entity.AreaQueryEntity;
import net.kuper.tz.common.entity.AreaUpdateEntity;
import net.kuper.tz.core.mybatis.Pagination;

import java.util.List;

/**
 * 区域
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
public interface AreaService {

    /**
     * 分页查询:区域
     *
     * @param areaQueryEntity 分页查询参数
     * @return Pagination
     */
    Pagination<AreaEntity> queryList(AreaQueryEntity areaQueryEntity);

    /**
     * 查询子集
     *
     * @param parentId
     * @param status
     * @return
     */
    List<AreaEntity> queryList(Integer parentId, Integer status);

    /**
     * 区域详情查询
     *
     * @param id
     * @return 区域
     */
    AreaEntity queryObject(Integer id);

    /**
     * 新增：区域
     *
     * @param areaUpdateEntity
     * @return 区域
     */
    AreaEntity save(AreaUpdateEntity areaUpdateEntity);

    /**
     * 修改 区域
     *
     * @param areaUpdateEntity
     * @return
     */
    void update(AreaUpdateEntity areaUpdateEntity);

    /**
     * 区域单条根据删除
     *
     * @param id
     * @return
     */
    void delete(Integer id);

    /**
     * 区域批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(Integer[] ids);

}

