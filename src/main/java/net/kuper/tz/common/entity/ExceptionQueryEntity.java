package net.kuper.tz.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.PaginationQuery;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;
/**
 * 分页查询系统错误
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-19 08:52:02
 */
@ApiModel(value = "分页查询系统错误")
@Data
public class ExceptionQueryEntity extends PaginationQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 类名
    */
    @Length(max = 200 ,message = "类名不能超过200个字符")
    @ApiModelProperty(value = "类名，最大长度：200", position = 1 )
    private String clazz;
    /**
    * 方法
    */
    @Length(max = 200 ,message = "方法不能超过200个字符")
    @ApiModelProperty(value = "方法，最大长度：200", position = 2 )
    private String method;
    /**
    * 行号
    */
    @ApiModelProperty(value = "行号", position = 3 )
    private Integer lineNum;
    /**
    * 错误类型
    */
    @Length(max = 200 ,message = "错误类型不能超过200个字符")
    @ApiModelProperty(value = "错误类型，最大长度：200", position = 4 )
    private String type;
    /**
    * 异常提示消息
    */
    @Length(max = 65535 ,message = "异常提示消息不能超过65,535个字符")
    @ApiModelProperty(value = "异常提示消息，最大长度：65,535", position = 5 )
    private String message;
    /**
    * 异常详情
    */
    @Length(max = 65535 ,message = "异常详情不能超过65,535个字符")
    @ApiModelProperty(value = "异常详情，最大长度：65,535", position = 6 )
    private String error;
    /**
    * 修复状态：1修改，0未修复
    */
    @ApiModelProperty(value = "修复状态：1修改，0未修复，默认值：0", required = true, position = 7 )
    private Integer fixStatus;
    /**
    * 变更时间
    */
    @ApiModelProperty(value = "变更时间", position = 8 )
    private Date updateTime;
    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间，默认值：CURRENT_TIMESTAMP", required = true, position = 9 )
    private Date createTime;
    /**
    * 删除： >=1:是 ，0:否
    */
    @ApiModelProperty(value = "删除： >=1:是 ，0:否，默认值：0", required = true, position = 10 )
    private Date deleteTime;

}
