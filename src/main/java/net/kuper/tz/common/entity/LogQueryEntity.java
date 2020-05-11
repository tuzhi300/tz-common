package net.kuper.tz.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.PaginationQuery;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 * 分页查询系统日志
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-20 01:04:36
 */
@ApiModel(value = "分页查询系统日志")
@Data
public class LogQueryEntity extends PaginationQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 访问地址
    */
    @Length(max = 300 ,message = "访问地址不能超过300个字符")
    @ApiModelProperty(value = "访问地址，最大长度：300", position = 1 )
    private String servletPath;
    /**
    * 用户操作
    */
    @Length(max = 50 ,message = "用户操作不能超过50个字符")
    @ApiModelProperty(value = "用户操作，最大长度：50", position = 2 )
    private String operation;
    /**
    * 请求方法
    */
    @Length(max = 200 ,message = "请求方法不能超过200个字符")
    @ApiModelProperty(value = "请求方法，最大长度：200", position = 3 )
    private String method;
    /**
    * 请求参数
    */
    @Length(max = 65535 ,message = "请求参数不能超过65,535个字符")
    @ApiModelProperty(value = "请求参数，最大长度：65,535", position = 4 )
    private String params;
    /**
    * 执行时长(毫秒)
    */
    @ApiModelProperty(value = "执行时长(毫秒)", required = true, position = 5 )
    private Long time;
    /**
    * IP地址
    */
    @Length(max = 64 ,message = "IP地址不能超过64个字符")
    @ApiModelProperty(value = "IP地址，最大长度：64", position = 6 )
    private String ip;
    @Length(max = 45 ,message = "不能超过45个字符")
    @ApiModelProperty(value = "，最大长度：45", required = true, position = 7 )
    private String ipLocationId;
    /**
    * 用户Id
    */
    @ApiModelProperty(value = "用户Id", position = 8 )
    private String userId;
    /**
    * 用户类型: 1管理员表，2用户表
    */
    @ApiModelProperty(value = "用户类型: 1管理员表，2用户表", required = true, position = 9 )
    private Integer userType;
    /**
    * 浏览器名称
    */
    @Length(max = 45 ,message = "浏览器名称不能超过45个字符")
    @ApiModelProperty(value = "浏览器名称，最大长度：45", position = 10 )
    private String browerName;
    /**
    * 浏览器版本
    */
    @Length(max = 45 ,message = "浏览器版本不能超过45个字符")
    @ApiModelProperty(value = "浏览器版本，最大长度：45", position = 11 )
    private String browerVersion;
    /**
    * 浏览器
    */
    @Length(max = 45 ,message = "浏览器不能超过45个字符")
    @ApiModelProperty(value = "浏览器，最大长度：45", position = 12 )
    private String browerType;
    /**
    * 系统名称
    */
    @Length(max = 45 ,message = "系统名称不能超过45个字符")
    @ApiModelProperty(value = "系统名称，最大长度：45", position = 13 )
    private String osName;
    /**
    * 系统版本
    */
    @Length(max = 45 ,message = "系统版本不能超过45个字符")
    @ApiModelProperty(value = "系统版本，最大长度：45", position = 14 )
    private String osVersion;
    /**
    * 返回结果
    */
    @Length(max = 65535 ,message = "返回结果不能超过65,535个字符")
    @ApiModelProperty(value = "返回结果，最大长度：65,535", position = 15 )
    private String result;
    /**
    * 操作类型
    */
    @Length(max = 50 ,message = "操作类型不能超过50个字符")
    @ApiModelProperty(value = "操作类型，最大长度：50", position = 16 )
    private String type;
    /**
    * 项目版本
    */
    @Length(max = 45 ,message = "项目版本不能超过45个字符")
    @ApiModelProperty(value = "项目版本，最大长度：45", position = 17 )
    private String serVersion;
    /**
    * 项目构建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "项目构建时间", position = 18 )
    private Date serBuildTime;
    /**
    * 变更时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "变更时间", position = 19 )
    private Date updateTime;
    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间，默认值：CURRENT_TIMESTAMP", required = true, position = 20 )
    private Date createTime;
    /**
    * 删除： >=1:是 ，0:否
    */
    @ApiModelProperty(value = "删除： >=1:是 ，0:否，默认值：0", required = true, position = 21 )
    private Date deleteTime;

}
