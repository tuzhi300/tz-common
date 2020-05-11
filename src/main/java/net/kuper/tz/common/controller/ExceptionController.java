package net.kuper.tz.common.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.kuper.tz.common.entity.ExceptionEntity;
import net.kuper.tz.common.entity.ExceptionQueryEntity;
import net.kuper.tz.common.entity.ExceptionUpdateEntity;
import net.kuper.tz.common.service.ExceptionService;
import net.kuper.tz.core.controller.Res;
import net.kuper.tz.core.controller.log.Log;
import net.kuper.tz.core.controller.log.LogType;
import net.kuper.tz.core.mybatis.Pagination;
import net.kuper.tz.core.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 系统错误
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-18 22:50:46
 */
@Api(value = "系统错误" , description = "系统错误" )
@RestController
@RequestMapping("common/exception" )
public class ExceptionController {

    @Autowired
    private ExceptionService exceptionService;

    /**
     * 分页查询：系统错误
     * @param exceptionQueryEntity
     */
    @Log(type = LogType.QUERY,value = "分页查询系统错误" )
    @ApiOperation("分页查询系统错误" )
    @RequiresPermissions("common:exception:list" )
    @ResponseBody
    @GetMapping
    public Res<Pagination<ExceptionEntity>> list(ExceptionQueryEntity exceptionQueryEntity) {
        ValidatorUtils.validateEntity(exceptionQueryEntity);
        Pagination pagination = exceptionService.queryList(exceptionQueryEntity);
        return Res.ok(pagination);
    }


    /**
     * 系统错误详情查询
     *
     * @param id
     * @return
     */
    @Log(type = LogType.QUERY,value = "系统错误详情查询" )
    @ApiOperation("系统错误详情查询" )
    @RequiresPermissions("common:exception:detail" )
    @ResponseBody
    @GetMapping(value = "/{id}" )
    public Res<ExceptionEntity> detail(@PathVariable("id") String id) {
        ExceptionEntity  exception = exceptionService.queryObject(id);
        return Res.ok(exception);
    }

    /**
     * 修改系统错误
     * @param exceptionUpdateEntity
     */
    @Log(type = LogType.UPDATE,value = "修改系统错误" )
    @ApiOperation("修改系统错误" )
    @RequiresPermissions("common:exception:update" )
    @ResponseBody
    @PutMapping
    public Res update(@RequestBody ExceptionUpdateEntity exceptionUpdateEntity) {
        exceptionService.update(exceptionUpdateEntity);
        return Res.ok();
    }

    /**
     * 删除系统错误
     * @param id
     */
    @Log(type = LogType.DELETE, value = "删除系统错误" )
    @ApiOperation("删除系统错误" )
    @RequiresPermissions("common:exception:delete" )
    @ResponseBody
    @DeleteMapping(value = "/{id}" )
    public Res delete(@PathVariable("id") String id) {
        exceptionService.delete(id);
        return Res.ok();
    }

}