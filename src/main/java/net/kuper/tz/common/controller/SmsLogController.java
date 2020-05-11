//package net.kuper.tz.common.controller;
//
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import net.kuper.tz.common.entity.SmsLogEntity;
//import net.kuper.tz.common.entity.SmsLogQueryEntity;
//import net.kuper.tz.common.entity.SmsLogUpdateEntity;
//import net.kuper.tz.common.service.SmsLogService;
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
// * 短信日志
// *
// * @author kuper
// * @email shengongwen@163.com
// * @date 2020-03-07 15:29:26
// */
//@Api(value = "短信日志" , description = "短信日志" )
//@RestController
//@RequestMapping("common/smslog" )
//public class SmsLogController {
//
//    @Autowired
//    private SmsLogService smsLogService;
//
//    /**
//     * 分页查询：短信日志
//     * @param smsLogQueryEntity
//     */
//    @Log(type = LogType.QUERY,value = "分页查询短信日志" )
//    @ApiOperation("分页查询短信日志" )
//    @RequiresPermissions("common:smslog:list" )
//    @ResponseBody
//    @GetMapping
//    public Res<Pagination<SmsLogEntity>> list(SmsLogQueryEntity smsLogQueryEntity) {
//        ValidatorUtils.validateEntity(smsLogQueryEntity);
//        Pagination pagination = smsLogService.queryList(smsLogQueryEntity);
//        return Res.ok(pagination);
//    }
//
//
//    /**
//     * 短信日志详情查询
//     *
//     * @param id
//     * @return
//     */
//    @Log(type = LogType.QUERY,value = "短信日志详情查询" )
//    @ApiOperation("短信日志详情查询" )
//    @RequiresPermissions("common:smslog:detail" )
//    @ResponseBody
//    @GetMapping(value = "/{id}" )
//    public Res<SmsLogEntity> detail(@PathVariable("id") String id) {
//        SmsLogEntity  smsLog = smsLogService.queryObject(id);
//        return Res.ok(smsLog);
//    }
//
//    /**
//     * 添加短信日志
//     *
//     * @param smsLogUpdateEntity
//     */
//    @Log(type = LogType.SAVE,value = "添加短信日志" )
//    @ApiOperation("添加短信日志" )
//    @RequiresPermissions("common:smslog:add" )
//    @ResponseBody
//    @PostMapping
//    public Res<SmsLogEntity> save(@RequestBody SmsLogUpdateEntity smsLogUpdateEntity) {
//        ValidatorUtils.validateEntity(smsLogUpdateEntity, AddGroup.class);
//        SmsLogEntity smsLogEntity =smsLogService.save(smsLogUpdateEntity);
//        return Res.ok(smsLogEntity);
//    }
//
//    /**
//     * 修改短信日志
//     * @param smsLogUpdateEntity
//     */
//    @Log(type = LogType.UPDATE,value = "修改短信日志" )
//    @ApiOperation("修改短信日志" )
//    @RequiresPermissions("common:smslog:update" )
//    @ResponseBody
//    @PutMapping
//    public Res update(@RequestBody SmsLogUpdateEntity smsLogUpdateEntity) {
//        ValidatorUtils.validateEntity(smsLogUpdateEntity, UpdateGroup.class);
//        smsLogService.update(smsLogUpdateEntity);
//        return Res.ok();
//    }
//
//    /**
//     * 删除短信日志
//     * @param id
//     */
//    @Log(type = LogType.DELETE, value = "删除短信日志" )
//    @ApiOperation("删除短信日志" )
//    @RequiresPermissions("common:smslog:delete" )
//    @ResponseBody
//    @DeleteMapping(value = "/{id}" )
//    public Res delete(@PathVariable("id") String id) {
//        smsLogService.delete(id);
//        return Res.ok();
//    }
//
//}