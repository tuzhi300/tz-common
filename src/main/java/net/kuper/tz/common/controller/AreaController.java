package net.kuper.tz.common.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.common.entity.AreaEntity;
import net.kuper.tz.common.entity.AreaQueryEntity;
import net.kuper.tz.common.entity.AreaUpdateEntity;
import net.kuper.tz.common.service.AreaService;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.core.validator.ValidatorUtils;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 区域
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
@Api(value = "区域", description = "区域")
@RestController
@RequestMapping("common/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    /**
     * 分页查询：区域
     *
     * @param areaQueryEntity
     */
    @Log(type = LogType.QUERY,value = "分页查询区域" )
    @ApiOperation("分页查询区域")
    @RequiresPermissions("common:area:list")
    @ResponseBody
    @GetMapping
    public Res<Pagination<AreaEntity>> list(AreaQueryEntity areaQueryEntity) {
        ValidatorUtils.validateEntity(areaQueryEntity);
        Pagination pagination = areaService.queryList(areaQueryEntity);
        return Res.ok(pagination);
    }


    @Log(type = LogType.QUERY,value = "查询子集区域" )
    @ApiOperation("查询子集区域")
    @RequiresPermissions("common:area:children" )
    @ResponseBody
    @GetMapping(value = "/{parentId}/children")
    public Res<List<AreaEntity>> list(@PathVariable("parentId") Integer parentId) {
        List list = areaService.queryList(parentId, 1);
        return Res.ok(list);
    }

    @Log(type = LogType.QUERY,value = "查询全部子集区域" )
    @ApiOperation("查询全部子集区域")
    @RequiresPermissions("common:area:children-all" )
    @ResponseBody
    @GetMapping(value = "/{parentId}/all-children")
    public Res<List<AreaEntity>> listAll(@PathVariable("parentId") Integer parentId) {
        List list = areaService.queryList(parentId, null);
        return Res.ok(list);
    }

    /**
     * 区域详情查询
     *
     * @param id
     * @return
     */
    @Log(type = LogType.QUERY,value = "区域详情查询" )
    @ApiOperation("区域详情查询")
    @RequiresPermissions("common:area:detail")
    @ResponseBody
    @GetMapping(value = "/{id}")
    public Res<AreaEntity> detail(@PathVariable("id") Integer id) {
        AreaEntity area = areaService.queryObject(id);
        return Res.ok(area);
    }

    /**
     * 添加区域
     *
     * @param areaUpdateEntity
     */
    @Log(type = LogType.SAVE, value = "添加区域")
    @ApiOperation("添加区域")
    @RequiresPermissions("common:area:add")
    @ResponseBody
    @PostMapping
    public Res<AreaEntity> save(@RequestBody AreaUpdateEntity areaUpdateEntity) {
        ValidatorUtils.validateEntity(areaUpdateEntity, AddGroup.class);
        AreaEntity areaEntity = areaService.save(areaUpdateEntity);
        return Res.ok(areaEntity);
    }

    /**
     * 修改区域
     *
     * @param areaUpdateEntity
     */
    @Log(type = LogType.UPDATE, value = "修改区域")
    @ApiOperation("修改区域")
    @RequiresPermissions("common:area:update")
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody AreaUpdateEntity areaUpdateEntity) {
        ValidatorUtils.validateEntity(areaUpdateEntity, UpdateGroup.class);
        areaService.update(areaUpdateEntity);
        return Res.ok();
    }

    /**
     * 删除区域
     *
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除区域")
    @ApiOperation("删除区域")
    @RequiresPermissions("common:area:delete")
    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public Res delete(@PathVariable("id") Integer id) {
        areaService.delete(id);
        return Res.ok();
    }

}