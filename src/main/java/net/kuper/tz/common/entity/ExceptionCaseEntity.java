package net.kuper.tz.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-19 11:50:55
 */
@ApiModel(value = "")
@Data
public class ExceptionCaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    @ApiModelProperty(value = "")
    private String exceptionId;
    @ApiModelProperty(value = "")
    private String serVersion;
    @ApiModelProperty(value = "")
    private Date serBuildTime;
    /**
     * 请求地址
     */
    @ApiModelProperty(value = "请求地址")
    private String servletPath;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
