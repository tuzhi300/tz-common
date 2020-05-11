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
 * @date 2020-03-20 01:18:37
 */
@ApiModel(value = "")
@Data
public class IpLocationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private String id;
    /**
     * IP地址
     */
    @ApiModelProperty(value = "IP地址")
    private String ip;
    /**
     * 省
     */
    @ApiModelProperty(value = "省")
    private String province;
    /**
     * 市
     */
    @ApiModelProperty(value = "市")
    private String city;
    /**
     * 区县
     */
    @ApiModelProperty(value = "区县")
    private String district;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String address;
    /**
     * 简要地址
     */
    private String shortAddress;
    /**
     * 城市编码 
     */
    @ApiModelProperty(value = "城市编码 ")
    private String cityCode;
    /**
     * 来源：1百度，2高德
     */
    @ApiModelProperty(value = "来源：1百度，2高德")
    private Integer source;
    /**
     * 运营商
     */
    @ApiModelProperty(value = "运营商")
    private String business;
    @ApiModelProperty(value = "")
    private String centerX;
    @ApiModelProperty(value = "")
    private String centerY;
    @ApiModelProperty(value = "")
    private String rectangleLeftBottomX;
    @ApiModelProperty(value = "")
    private String rectangleLeftBottomY;
    @ApiModelProperty(value = "")
    private String rectangleRightTopX;
    @ApiModelProperty(value = "")
    private String rectangleRightTopY;
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
     * 状态：1已解析，0未解析
     */
    @ApiModelProperty(value = "状态：1已解析，0未解析")
    private Integer status;

}
