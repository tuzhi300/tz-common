package net.kuper.tz.common.service.impl;

import com.github.pagehelper.PageHelper;
import net.kuper.tz.common.dao.MacroDao;
import net.kuper.tz.common.entity.MacroEntity;
import net.kuper.tz.common.entity.MacroQueryEntity;
import net.kuper.tz.common.entity.MacroUpdateEntity;
import net.kuper.tz.common.service.MacroService;
import net.kuper.tz.core.controller.exception.ApiException;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.core.service.SuperRoleService;
import net.kuper.tz.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
@Service("macroService")
public class MacroServiceImpl implements MacroService {

    @Autowired
    private MacroDao macroDao;
    @Autowired
    private SuperRoleService superRoleService;

    @Override
    public List<MacroEntity> queryTypeList() {
        return macroDao.queryTypeList();
    }

    @Override
    public Pagination<MacroEntity> queryList(MacroQueryEntity macroQueryEntity) {
        PageHelper.startPage(macroQueryEntity.getPage(), macroQueryEntity.getPageSize());
        List<MacroEntity> macroList = macroDao.queryList(macroQueryEntity);
        return new Pagination<MacroEntity>(macroList);
    }

    @Override
    public List<MacroEntity> queryAllList(MacroQueryEntity macroQueryEntity) {
        return macroDao.queryList(macroQueryEntity);
    }

    @Override
    public MacroEntity queryObject(String id) {
        return macroDao.queryObject(id);
    }

    /**
     * 是否可以添加
     *
     * @param updateEntity
     * @param userId
     */
    private void verifyAddable(MacroUpdateEntity updateEntity, String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new ApiException("请传修改人参数");
        }
        MacroEntity parent = macroDao.queryObjectByKey(updateEntity.getParentKey());
        if (parent == null && !"0".equals(updateEntity.getParentKey())) {
            throw new ApiException("字典分类错误");
        } else if (parent != null && "0".equals(updateEntity.getParentKey())) {
            if (parent.getEdit() == 0 && !superRoleService.isSuperRoleByUser(userId)) {
                throw new ApiException("非超级管理员，无效新增该类别字典");
            }
        }
    }

    /**
     * 是否可以删除
     *
     * @param macroId
     * @param userId
     */
    private void verifyDelable(String macroId, String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new ApiException("请传修改人参数");
        }
        MacroEntity macroEntity = macroDao.queryObjectByKey(macroId);
        if (macroEntity.getEdit() == 0 && !superRoleService.isSuperRoleByUser(userId)) {
            throw new ApiException("非超级管理员，无法删除");
        }
    }

    /**
     * keg格式规范
     *
     * @param updateEntity
     */
    private void verifyKey(MacroUpdateEntity updateEntity) {
        if (updateEntity.getParentKey() == null && updateEntity.getType() != 0) {
            throw new ApiException("一级字典不能是值");
        }
        if (updateEntity.getParentKey() != null && !"0".equals(updateEntity.getParentKey())) {
            MacroEntity parent = macroDao.queryObjectByKey(updateEntity.getParentKey());
            if (parent == null) {
                throw new ApiException("上级字典不存在");
            }
            if (!updateEntity.getKey().startsWith(parent.getKey() + ".")) {
                throw new ApiException("键格式错误，请使用上级key加上'.'做当前key的前缀");
            }
        }
    }

    /**
     * 是否可以修改
     *
     * @param updateEntity
     * @param userId
     */
    private void verifyEdit(MacroUpdateEntity updateEntity, String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new ApiException("请传修改人参数");
        }
        MacroEntity macroEntity = macroDao.queryObject(updateEntity.getId());
        if (!superRoleService.isSuperRoleByUser(userId)) {
            if (macroEntity.getEdit() == 0) {
                throw new ApiException("非超级管理员，无法修改");
            } else if (updateEntity.getEdit() == 0) {
                throw new ApiException("非超级管理员，仅可设置可编辑");
            }
        }
        if ("0".equals(updateEntity.getParentKey())) {
            MacroEntity entity = macroDao.queryObject(updateEntity.getId());
            if (!entity.getKey().equals(updateEntity.getKey())) {
                throw new ApiException("字典分类键不能修改");
            }
        }
    }

    @Override
    public MacroEntity save(MacroUpdateEntity macroUpdateEntity, String userId) {
        verifyAddable(macroUpdateEntity, userId);
        verifyKey(macroUpdateEntity);
        verifyEdit(macroUpdateEntity, userId);
        if ("0".equals(macroUpdateEntity.getParentKey())) {
            macroUpdateEntity.setParentKey(null);
        }
        macroDao.save(macroUpdateEntity);
        return macroDao.queryObject(macroUpdateEntity.getId());
    }

    @Override
    public void update(MacroUpdateEntity macroUpdateEntity, String userId) {
        verifyKey(macroUpdateEntity);
        verifyEdit(macroUpdateEntity, userId);
        if ("0".equals(macroUpdateEntity.getParentKey())) {
            macroUpdateEntity.setParentKey(null);
        }
        macroDao.update(macroUpdateEntity);
    }

    @Override
    public void delete(String id, String userId) {
        verifyDelable(id, userId);
        macroDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {

    }
}
