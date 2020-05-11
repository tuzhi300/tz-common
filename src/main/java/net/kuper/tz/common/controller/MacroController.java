package net.kuper.tz.common.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.common.entity.MacroEntity;
import net.kuper.tz.common.entity.MacroQueryEntity;
import net.kuper.tz.common.entity.MacroUpdateEntity;
import net.kuper.tz.common.service.MacroService;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.auth.UserId;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * 字典
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
@Api(value = "字典", description = "字典")
@RestController
@RequestMapping("common/macro")
public class MacroController {

    @Autowired
    private MacroService macroService;


    @Log(type = LogType.QUERY, value = "查询一级字典")
    @ApiOperation("查询一级字典")
    @RequiresPermissions("common:macro:type:list")
    @ResponseBody
    @GetMapping(value = "/type")
    public Res<List<MacroEntity>> queryTypeList() {
        List list = macroService.queryTypeList();
        return Res.ok(list);
    }

    /**
     * 分页查询：字典
     *
     * @param macroQueryEntity
     */
    @Log(type = LogType.QUERY, value = "分页查询字典")
    @ApiOperation("分页查询字典")
    @RequiresPermissions("common:macro:list")
    @ResponseBody
    @GetMapping
    public Res<Pagination<MacroEntity>> list(MacroQueryEntity macroQueryEntity) {
        ValidatorUtils.validateEntity(macroQueryEntity);
        Pagination pagination = macroService.queryList(macroQueryEntity);
        return Res.ok(pagination);
    }

    @Log(type = LogType.QUERY, value = "查询字典子集")
    @ApiOperation("查询字典子集")
    @RequiresPermissions("common:macro:children")
    @ResponseBody
    @GetMapping(value = "/type-{key}")
    public Res<List<MacroEntity>> queryList(@PathVariable("key") String key) {
        MacroQueryEntity macroQueryEntity = new MacroQueryEntity();
        macroQueryEntity.setParentKey(key);
        macroQueryEntity.setStatus(0);
        List list = macroService.queryAllList(macroQueryEntity);
        return Res.ok(list);
    }


    /**
     * 字典详情查询
     *
     * @param id
     * @return
     */
    @Log(type = LogType.QUERY, value = "字典详情查询")
    @ApiOperation("字典详情查询")
    @RequiresPermissions("common:macro:detail")
    @ResponseBody
    @GetMapping(value = "/{id}")
    public Res<MacroEntity> detail(@PathVariable("id") String id) {
        MacroEntity macro = macroService.queryObject(id);
        return Res.ok(macro);
    }

    /**
     * 添加字典
     *
     * @param macroUpdateEntity
     */
    @Log(type = LogType.SAVE, value = "添加字典")
    @ApiOperation("添加字典")
    @RequiresPermissions("common:macro:add")
    @ResponseBody
    @PostMapping
    public Res<MacroEntity> save(@RequestBody MacroUpdateEntity macroUpdateEntity, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(macroUpdateEntity, AddGroup.class);
        MacroEntity macroEntity = macroService.save(macroUpdateEntity, userId);
        return Res.ok(macroEntity);
    }

    /**
     * 修改字典
     *
     * @param macroUpdateEntity
     */
    @Log(type = LogType.UPDATE, value = "修改字典")
    @ApiOperation("修改字典")
    @RequiresPermissions("common:macro:update")
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody MacroUpdateEntity macroUpdateEntity, @ApiIgnore @UserId String userId) {
        ValidatorUtils.validateEntity(macroUpdateEntity, UpdateGroup.class);
        macroService.update(macroUpdateEntity, userId);
        return Res.ok();
    }

    /**
     * 删除字典
     *
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除字典")
    @ApiOperation("删除字典")
    @RequiresPermissions("common:macro:delete")
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public Res delete(@PathVariable("id") String id, @ApiIgnore @UserId String userId) {
        macroService.delete(id, userId);
        return Res.ok();
    }

}