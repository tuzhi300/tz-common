//package net.kuper.tz.common.controller;
//
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import net.kuper.tz.common.entity.RequestLimitEntity;
//import net.kuper.tz.common.entity.RequestLimitQueryEntity;
//import net.kuper.tz.common.entity.RequestLimitUpdateEntity;
//import net.kuper.tz.common.service.RequestLimitService;
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
// * 请求限制
// *
// * @author kuper
// * @email shengongwen@163.com
// * @date 2020-03-07 15:29:26
// */
//@Api(value = "请求限制" , description = "请求限制" )
//@RestController
//@RequestMapping("common/requestlimit" )
//public class RequestLimitController {
//
//    @Autowired
//    private RequestLimitService requestLimitService;
//
//    /**
//     * 分页查询：请求限制
//     * @param requestLimitQueryEntity
//     */
//    @Log(type = LogType.QUERY,value = "分页查询请求限制" )
//    @ApiOperation("分页查询请求限制" )
//    @RequiresPermissions("common:requestlimit:list" )
//    @ResponseBody
//    @GetMapping
//    public Res<Pagination<RequestLimitEntity>> list(RequestLimitQueryEntity requestLimitQueryEntity) {
//        ValidatorUtils.validateEntity(requestLimitQueryEntity);
//        Pagination pagination = requestLimitService.queryList(requestLimitQueryEntity);
//        return Res.ok(pagination);
//    }
//
//
//    /**
//     * 请求限制详情查询
//     *
//     * @param id
//     * @return
//     */
//    @Log(type = LogType.QUERY,value = "请求限制详情查询" )
//    @ApiOperation("请求限制详情查询" )
//    @RequiresPermissions("common:requestlimit:detail" )
//    @ResponseBody
//    @GetMapping(value = "/{id}" )
//    public Res<RequestLimitEntity> detail(@PathVariable("id") String id) {
//        RequestLimitEntity  requestLimit = requestLimitService.queryObject(id);
//        return Res.ok(requestLimit);
//    }
//
//    /**
//     * 添加请求限制
//     *
//     * @param requestLimitUpdateEntity
//     */
//    @Log(type = LogType.SAVE,value = "添加请求限制" )
//    @ApiOperation("添加请求限制" )
//    @RequiresPermissions("common:requestlimit:add" )
//    @ResponseBody
//    @PostMapping
//    public Res<RequestLimitEntity> save(@RequestBody RequestLimitUpdateEntity requestLimitUpdateEntity) {
//        ValidatorUtils.validateEntity(requestLimitUpdateEntity, AddGroup.class);
//        RequestLimitEntity requestLimitEntity =requestLimitService.save(requestLimitUpdateEntity);
//        return Res.ok(requestLimitEntity);
//    }
//
//    /**
//     * 修改请求限制
//     * @param requestLimitUpdateEntity
//     */
//    @Log(type = LogType.UPDATE,value = "修改请求限制" )
//    @ApiOperation("修改请求限制" )
//    @RequiresPermissions("common:requestlimit:update" )
//    @ResponseBody
//    @PutMapping
//    public Res update(@RequestBody RequestLimitUpdateEntity requestLimitUpdateEntity) {
//        ValidatorUtils.validateEntity(requestLimitUpdateEntity, UpdateGroup.class);
//        requestLimitService.update(requestLimitUpdateEntity);
//        return Res.ok();
//    }
//
//    /**
//     * 删除请求限制
//     * @param id
//     */
//    @Log(type = LogType.DELETE, value = "删除请求限制" )
//    @ApiOperation("删除请求限制" )
//    @RequiresPermissions("common:requestlimit:delete" )
//    @ResponseBody
//    @DeleteMapping(value = "/{id}" )
//    public Res delete(@PathVariable("id") String id) {
//        requestLimitService.delete(id);
//        return Res.ok();
//    }
//
//}