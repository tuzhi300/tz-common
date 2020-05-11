package net.kuper.tz.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求限制
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-25 18:02:28
 */
@ApiModel(value = "请求限制")
@Data
public class RequestLimitEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * IP
     */
    @ApiModelProperty(value = "IP")
    private String ip;
    /**
     * 接口标记，代码中唯一标识。
     */
    @ApiModelProperty(value = "接口标记，代码中唯一标识。")
    private String limitId;
    /**
     * 会话ID
     */
    @ApiModelProperty(value = "会话ID")
    private String sessionId;
    /**
     * 用户Id
     */
    @ApiModelProperty(value = "用户Id")
    private String userId;
    /**
     * 接口地址
     */
    @ApiModelProperty(value = "接口地址")
    private String url;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;
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
