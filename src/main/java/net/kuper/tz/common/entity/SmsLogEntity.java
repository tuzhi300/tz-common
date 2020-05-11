package net.kuper.tz.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 短信日志
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
@ApiModel(value = "短信日志")
@Data
public class SmsLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
     private String id;
    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息")
    private String remarks;
    /**
     * 业务类型
     */
    @ApiModelProperty(value = "业务类型")
    private String businessType;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String phone;
    /**
     * 模板ID
     */
    @ApiModelProperty(value = "模板ID")
    private String templateId;
    /**
     * 模板类型
     */
    @ApiModelProperty(value = "模板类型")
    private String templateContent;
    /**
     * 发送数据
     */
    @ApiModelProperty(value = "发送数据")
    private String senddata;
    /**
     * 发送状态
     */
    @ApiModelProperty(value = "发送状态")
    private String status;
    /**
     * 发送响应消息ID
     */
    @ApiModelProperty(value = "发送响应消息ID")
    private String smsid;
    /**
     * 返回码
     */
    @ApiModelProperty(value = "返回码")
    private String code;
    /**
     * 返回消息
     */
    @ApiModelProperty(value = "返回消息")
    private String msg;
    /**
     * 删除标记（0：正常；-1：删除）
     */
    @ApiModelProperty(value = "删除标记（0：正常；-1：删除）")
    private Integer flag;
    /**
     * 响应时间
     */
    @ApiModelProperty(value = "响应时间")
    private Date responseDate;
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
