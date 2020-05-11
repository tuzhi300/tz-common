//package net.kuper.tz.common.controller;
//
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import net.kuper.tz.common.entity.IpLocationEntity;
//import net.kuper.tz.common.entity.IpLocationQueryEntity;
//import net.kuper.tz.common.entity.IpLocationUpdateEntity;
//import net.kuper.tz.common.service.IpLocationService;
//import net.kuper.tz.core.controller.Res;
//import net.kuper.tz.core.controller.log.Log;
//import net.kuper.tz.core.controller.log.LogType;
//import net.kuper.tz.core.mybatis.Pagination;
//import net.kuper.tz.core.validator.ValidatorUtils;
//import net.kuper.tz.core.validator.group.AddGroup;
//import net.kuper.tz.core.validator.group.UpdateGroup;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
///**
// *
// *
// * @author kuper
// * @email shengongwen@163.com
// * @date 2020-03-20 01:18:37
// */
//@Api(value = "" , description = "" )
//@RestController
//@RequestMapping("common/iplocation" )
//public class IpLocationController {
//
//    @Autowired
//    private IpLocationService ipLocationService;
//
//    /**
//     * 分页查询：
//     * @param ipLocationQueryEntity
//     */
//    @ApiOperation("分页查询" )
//    @RequiresPermissions("common:iplocation:list" )
//    @ResponseBody
//    @GetMapping
//    public Res<Pagination<IpLocationEntity>> list(IpLocationQueryEntity ipLocationQueryEntity) {
//        ValidatorUtils.validateEntity(ipLocationQueryEntity);
//        Pagination pagination = ipLocationService.queryList(ipLocationQueryEntity);
//        return Res.ok(pagination);
//    }
//
//
//    /**
//     * 详情查询
//     *
//     * @param id
//     * @return
//     */
//    @ApiOperation("详情查询" )
//    @RequiresPermissions("common:iplocation:detail" )
//    @ResponseBody
//    @GetMapping(value = "/{id}" )
//    public Res<IpLocationEntity> detail(@PathVariable("id") String id) {
//        IpLocationEntity  ipLocation = ipLocationService.queryObject(id);
//        return Res.ok(ipLocation);
//    }
//
//    /**
//     * 添加
//     *
//     * @param ipLocationUpdateEntity
//     */
//    @Log(type = LogType.SAVE,value = "添加" )
//    @ApiOperation("添加" )
//    @RequiresPermissions("common:iplocation:add" )
//    @ResponseBody
//    @PostMapping
//    public Res<IpLocationEntity> save(@RequestBody IpLocationUpdateEntity ipLocationUpdateEntity) {
//        ValidatorUtils.validateEntity(ipLocationUpdateEntity, AddGroup.class);
//        IpLocationEntity ipLocationEntity =ipLocationService.save(ipLocationUpdateEntity);
//        return Res.ok(ipLocationEntity);
//    }
//
//    /**
//     * 修改
//     * @param ipLocationUpdateEntity
//     */
//    @Log(type = LogType.UPDATE,value = "修改" )
//    @ApiOperation("修改" )
//    @RequiresPermissions("common:iplocation:update" )
//    @ResponseBody
//    @PutMapping
//    public Res update(@RequestBody IpLocationUpdateEntity ipLocationUpdateEntity) {
//        ValidatorUtils.validateEntity(ipLocationUpdateEntity, UpdateGroup.class);
//        ipLocationService.update(ipLocationUpdateEntity);
//        return Res.ok();
//    }
//
//    /**
//     * 删除
//     * @param id
//     */
//    @Log(type = LogType.DELETE, value = "删除" )
//    @ApiOperation("删除" )
//    @RequiresPermissions("common:iplocation:delete" )
//    @ResponseBody
//    @DeleteMapping(value = "/{id}" )
//    public Res delete(@PathVariable("id") String id) {
//        ipLocationService.delete(id);
//        return Res.ok();
//    }
//
//}