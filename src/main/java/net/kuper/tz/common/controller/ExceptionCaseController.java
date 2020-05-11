//package net.kuper.tz.common.controller;
//
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import net.kuper.tz.common.entity.ExceptionCaseEntity;
//import net.kuper.tz.common.entity.ExceptionCaseQueryEntity;
//import net.kuper.tz.common.entity.ExceptionCaseUpdateEntity;
//import net.kuper.tz.common.service.ExceptionCaseService;
//import net.kuper.tz.core.controller.Res;
//import net.kuper.tz.core.controller.log.Log;
//import net.kuper.tz.core.controller.log.LogType;
//import net.kuper.tz.core.mybatis.Pagination;
//import net.kuper.tz.core.validator.ValidatorUtils;
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
// * @date 2020-03-18 22:50:46
// */
//@Api(value = "异常" , description = "" )
//@RestController
//@RequestMapping("common/exceptioncase" )
//public class ExceptionCaseController {
//
//    @Autowired
//    private ExceptionCaseService exceptionCaseService;
//
//    /**
//     * 分页查询：
//     * @param exceptionCaseQueryEntity
//     */
//    @Log(type = LogType.QUERY,value = "分页查询异常" )
//    @ApiOperation("分页查询异常" )
//    @RequiresPermissions("common:exceptioncase:list" )
//    @ResponseBody
//    @GetMapping
//    public Res<Pagination<ExceptionCaseEntity>> list(ExceptionCaseQueryEntity exceptionCaseQueryEntity) {
//        ValidatorUtils.validateEntity(exceptionCaseQueryEntity);
//        Pagination pagination = exceptionCaseService.queryList(exceptionCaseQueryEntity);
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
//    @Log(type = LogType.QUERY,value = "异常详情查询" )
//    @ApiOperation("异常详情查询" )
//    @RequiresPermissions("common:exceptioncase:detail" )
//    @ResponseBody
//    @GetMapping(value = "/{id}" )
//    public Res<ExceptionCaseEntity> detail(@PathVariable("id") String id) {
//        ExceptionCaseEntity  exceptionCase = exceptionCaseService.queryObject(id);
//        return Res.ok(exceptionCase);
//    }
//
//    /**
//     * 修改
//     * @param exceptionCaseUpdateEntity
//     */
//    @Log(type = LogType.UPDATE,value = "修改异常" )
//    @ApiOperation("修改异常" )
//    @RequiresPermissions("common:exceptioncase:update" )
//    @ResponseBody
//    @PutMapping
//    public Res update(@RequestBody ExceptionCaseUpdateEntity exceptionCaseUpdateEntity) {
//        ValidatorUtils.validateEntity(exceptionCaseUpdateEntity, UpdateGroup.class);
//        exceptionCaseService.update(exceptionCaseUpdateEntity);
//        return Res.ok();
//    }
//
//    /**
//     * 删除
//     * @param id
//     */
//    @Log(type = LogType.DELETE, value = "删除异常" )
//    @ApiOperation("删除异常" )
//    @RequiresPermissions("common:exceptioncase:delete" )
//    @ResponseBody
//    @DeleteMapping(value = "/{id}" )
//    public Res delete(@PathVariable("id") String id) {
//        exceptionCaseService.delete(id);
//        return Res.ok();
//    }
//
//}