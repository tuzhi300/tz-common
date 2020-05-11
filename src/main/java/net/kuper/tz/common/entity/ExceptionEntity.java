package net.kuper.tz.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统错误
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-19 08:52:02
 */
@ApiModel(value = "系统错误")
@Data
public class ExceptionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    /**
     * 类名
     */
    @ApiModelProperty(value = "类名")
    private String clazz;
    /**
     * 方法
     */
    @ApiModelProperty(value = "方法")
    private String method;
    /**
     * 行号
     */
    @ApiModelProperty(value = "行号")
    private Integer lineNum;
    /**
     * 错误类型
     */
    @ApiModelProperty(value = "错误类型")
    private String type;
    /**
     * 异常提示消息
     */
    @ApiModelProperty(value = "异常提示消息")
    private String message;
    /**
     * 异常详情
     */
    @ApiModelProperty(value = "异常详情")
    private String error;
    /**
     * 修复状态：1修改，0未修复
     */
    @ApiModelProperty(value = "修复状态：1修改，0未修复")
    private Integer fixStatus;
    /**
     * 变更时间
     */
    @ApiModelProperty(value = "变更时间")
    private Date updateTime;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 删除： >=1:是 ，0:否
     */
    @ApiModelProperty(value = "删除： >=1:是 ，0:否")
    private Date deleteTime;
    @ApiModelProperty(value = "次数")
    private Integer count;

}
