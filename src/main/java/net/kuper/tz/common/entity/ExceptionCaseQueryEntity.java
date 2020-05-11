package net.kuper.tz.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.PaginationQuery;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;
/**
 * 分页查询
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-19 11:50:55
 */
@ApiModel(value = "分页查询")
@Data
public class ExceptionCaseQueryEntity extends PaginationQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @Length(max = 45 ,message = "不能超过45个字符")
    @ApiModelProperty(value = "，最大长度：45", required = true, position = 1 )
    private String exceptionId;
    @Length(max = 45 ,message = "不能超过45个字符")
    @ApiModelProperty(value = "，最大长度：45", position = 2 )
    private String serVersion;
    @Length(max = 30 ,message = "不能超过30个字符")
    @ApiModelProperty(value = "，最大长度：30", position = 3 )
    private Date serBuildTime;
    /**
    * 请求地址
    */
    @Length(max = 255 ,message = "请求地址不能超过255个字符")
    @ApiModelProperty(value = "请求地址，最大长度：255", position = 4 )
    private String servletPath;
    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间，默认值：CURRENT_TIMESTAMP", required = true, position = 5 )
    private Date createTime;

}
