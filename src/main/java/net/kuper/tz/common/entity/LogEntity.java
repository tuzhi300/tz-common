package net.kuper.tz.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-20 01:04:36
 */
@ApiModel(value = "系统日志")
@Data
public class LogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    /**
     * 访问地址
     */
    @ApiModelProperty(value = "访问地址")
    private String servletPath;
    /**
     * 用户操作
     */
    @ApiModelProperty(value = "用户操作")
    private String operation;
    /**
     * 请求方法
     */
    @ApiModelProperty(value = "请求方法")
    private String method;
    /**
     * 请求参数
     */
    @ApiModelProperty(value = "请求参数")
    private String params;
    /**
     * 执行时长(毫秒)
     */
    @ApiModelProperty(value = "执行时长(毫秒)")
    private Long time;
    /**
     * IP地址
     */
    @ApiModelProperty(value = "IP地址")
    private String ip;
    @ApiModelProperty(value = "")
    private String ipLocationId;
    /**
     * 用户Id
     */
    @ApiModelProperty(value = "用户Id")
    private String userId;
    /**
     * 用户类型: 1管理员表，2用户表
     */
    @ApiModelProperty(value = "用户类型: 1管理员表，2用户表")
    private Integer userType;
    /**
     * 浏览器名称
     */
    @ApiModelProperty(value = "浏览器名称")
    private String browerName;
    /**
     * 浏览器版本
     */
    @ApiModelProperty(value = "浏览器版本")
    private String browerVersion;
    /**
     * 浏览器
     */
    @ApiModelProperty(value = "浏览器")
    private String browerType;
    /**
     * 系统名称
     */
    @ApiModelProperty(value = "系统名称")
    private String osName;
    /**
     * 系统版本
     */
    @ApiModelProperty(value = "系统版本")
    private String osVersion;
    /**
     * 返回结果
     */
    @ApiModelProperty(value = "返回结果")
    private String result;
    /**
     * 操作类型
     */
    @ApiModelProperty(value = "操作类型")
    private String type;
    /**
     * 项目版本
     */
    @ApiModelProperty(value = "项目版本")
    private String serVersion;
    /**
     * 项目构建时间
     */
    @ApiModelProperty(value = "项目构建时间")
    private Date serBuildTime;
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

}
