package net.kuper.tz.common.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.common.entity.LogEntity;
import net.kuper.tz.common.entity.LogQueryEntity;
import net.kuper.tz.common.service.LogService;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.form.RepeatForm;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.core.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 系统日志
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 17:29:34
 */
@Api(value = "系统日志", description = "系统日志")
@RestController
@RequestMapping("common/log")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 分页查询：系统日志
     *
     * @param logQueryEntity
     */
//    @Log(type = LogType.QUERY,value = "分页查询系统日志" )
//    @Limit(userCount = 5, userTime = Time.DAY, type = LimitType.USER, error = "系统日志每天只能请求5次")
    @RepeatForm
    @ApiOperation("分页查询系统日志")
    @RequiresPermissions("common:log:list")
    @ResponseBody
    @GetMapping
    public Res<Pagination<LogEntity>> list(LogQueryEntity logQueryEntity) {
        ValidatorUtils.validateEntity(logQueryEntity);
        Pagination pagination = logService.queryList(logQueryEntity);
        return Res.ok(pagination);
    }


    /**
     * 系统日志详情查询
     *
     * @param id
     * @return
     */
//    @Log(type = LogType.QUERY,value = "系统日志详情查询" )
    @ApiOperation("系统日志详情查询")
    @RequiresPermissions("common:log:detail")
    @ResponseBody
    @GetMapping(value = "/{id}")
    public Res<LogEntity> detail(@PathVariable("id") String id) {
        LogEntity log = logService.queryObject(id);
        return Res.ok(log);
    }

//    /**
//     * 添加系统日志
//     *
//     * @param logUpdateEntity
//     */
//    @Log(type = LogType.SAVE,value = "添加系统日志" )
//    @ApiOperation("添加系统日志" )
//    @RequiresPermissions("common:log:add" )
//    @ResponseBody
//    @PostMapping
//    public Res<LogEntity> save(@RequestBody LogUpdateEntity logUpdateEntity) {
//        ValidatorUtils.validateEntity(logUpdateEntity, AddGroup.class);
//        LogEntity logEntity =logService.save(logUpdateEntity);
//        return Res.ok(logEntity);
//    }

//    /**
//     * 修改系统日志
//     * @param logUpdateEntity
//     */
//    @Log(type = LogType.UPDATE,value = "修改系统日志" )
//    @ApiOperation("修改系统日志" )
//    @RequiresPermissions("common:log:update" )
//    @ResponseBody
//    @PutMapping
//    public Res update(@RequestBody LogUpdateEntity logUpdateEntity) {
//        ValidatorUtils.validateEntity(logUpdateEntity, UpdateGroup.class);
//        logService.update(logUpdateEntity);
//        return Res.ok();
//    }

//    /**
//     * 删除系统日志
//     *
//     * @param id
//     */
//    @Log(type = LogType.DELETE, value = "删除系统日志")
//    @ApiOperation("删除系统日志")
//    @RequiresPermissions("common:log:delete")
//    @ResponseBody
//    @DeleteMapping(value = "/{id}")
//    public Res delete(@PathVariable("id") String id) {
//        logService.delete(id);
//        return Res.ok();
//    }

}