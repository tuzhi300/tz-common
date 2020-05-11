package net.kuper.tz.common.service;

import net.kuper.tz.common.entity.MacroEntity;
import net.kuper.tz.common.entity.MacroQueryEntity;
import net.kuper.tz.common.entity.MacroUpdateEntity;
import net.kuper.tz.core.mybatis.Pagination;

import java.util.List;

/**
 * 字典
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
public interface MacroService {


    /**
     * 查询一级字典
     *
     * @return
     */
    List<MacroEntity> queryTypeList();

    /**
     * 查询所有字典子集
     *
     * @return
     */
    Pagination<MacroEntity> queryList(MacroQueryEntity macroQueryEntity);

    /**
     * 查询字典子集
     *
     * @return
     */
    List<MacroEntity> queryAllList(MacroQueryEntity macroQueryEntity);

    /**
     * 字典详情查询
     *
     * @param id
     * @return 字典
     */
    MacroEntity queryObject(String id);

    /**
     * 新增：字典
     *
     * @param macroUpdateEntity
     * @return 字典
     */
    MacroEntity save(MacroUpdateEntity macroUpdateEntity, String userId);

    /**
     * 修改 字典
     *
     * @param macroUpdateEntity
     * @return
     */
    void update(MacroUpdateEntity macroUpdateEntity, String userId);

    /**
     * 字典单条根据删除
     *
     * @param id
     * @return
     */
    void delete(String id, String userId);

    /**
     * 字典批量删除
     *
     * @param ids
     * @return
     */
    void deleteBatch(String[] ids);

}

