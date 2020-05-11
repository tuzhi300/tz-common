package net.kuper.tz.common.dao;

import net.kuper.tz.common.entity.MacroEntity;
import net.kuper.tz.common.entity.MacroQueryEntity;
import net.kuper.tz.common.entity.MacroUpdateEntity;

import java.util.List;

/**
 * 字典
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
public interface MacroDao {

    /**
     * 字典详情
     *
     * @param id
     * @return
     */
    MacroEntity queryObject(String id);
    /**
     * 字典详情
     *
     * @param key
     * @return
     */
    MacroEntity queryObjectByKey(String key);

    /**
     * 字典列表
     *
     * @param macroQueryEntity
     * @return
     */
    List<MacroEntity> queryList(MacroQueryEntity macroQueryEntity);

    /**
     * 查询一级字典
     *
     * @return
     */
    List<MacroEntity> queryTypeList();

    /**
     * 字典新增
     *
     * @param macroUpdateEntity
     */
    void save(MacroUpdateEntity macroUpdateEntity);

    /**
     * 字典修改
     *
     * @param macroUpdateEntity
     */
    void update(MacroUpdateEntity macroUpdateEntity);

    /**
     * 字典单条删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 字典批量删除
     *
     * @param ids
     */
    void deleteBatch(String[] ids);
}
