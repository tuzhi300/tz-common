package net.kuper.tz.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 变更
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-20 01:18:37
 */
@ApiModel(value = "变更")
@Data
public class IpLocationUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：45", required = true, position = 0 )
    private String id;
    /**
     * IP地址
     */
    @NotNull(message = "IP地址为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "IP地址不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 64 ,message = "IP地址不能超过64个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "IP地址，最大长度：64", required = true, position = 1 )
    private String ip;
    /**
     * 省
     */
    @Length(max = 45 ,message = "省不能超过45个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "省，最大长度：45", position = 2 )
    private String province;
    /**
     * 市
     */
    @Length(max = 45 ,message = "市不能超过45个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "市，最大长度：45", position = 3 )
    private String city;
    /**
     * 区县
     */
    @Length(max = 45 ,message = "区县不能超过45个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "区县，最大长度：45", position = 4 )
    private String district;
    /**
     * 地址
     */
    @Length(max = 100 ,message = "地址不能超过100个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "地址，最大长度：100", position = 5 )
    private String address;
    /**
     * 简要地址
     */
    @Length(max = 45 ,message = "地址不能超过45个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "地址，最大长度：45", position = 5 )
    private String shortAddress;
    /**
     * 城市编码 
     */
    @Length(max = 20 ,message = "城市编码 不能超过20个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "城市编码 ，最大长度：20", position = 6 )
    private String cityCode;
    /**
     * 来源：1百度，2高德
     */
    @ApiModelProperty(value = "来源：1百度，2高德", position = 7 )
    private Integer source;
    /**
     * 运营商
     */
    @Length(max = 45 ,message = "运营商不能超过45个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "运营商，最大长度：45", position = 8 )
    private String business;
    @Length(max = 20 ,message = "不能超过20个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：20", position = 9 )
    private String centerX;
    @Length(max = 20 ,message = "不能超过20个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：20", position = 10 )
    private String centerY;
    @Length(max = 20 ,message = "不能超过20个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：20", position = 11 )
    private String rectangleLeftBottomX;
    @Length(max = 20 ,message = "不能超过20个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：20", position = 12 )
    private String rectangleLeftBottomY;
    @Length(max = 20 ,message = "不能超过20个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：20", position = 13 )
    private String rectangleRightTopX;
    @Length(max = 20 ,message = "不能超过20个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：20", position = 14 )
    private String rectangleRightTopY;
    /**
     * 变更时间
     */
    @ApiModelProperty(value = "变更时间", position = 15 )
    private Date updateTime;
    /**
     * 创建时间
     */
    @NotNull(message = "创建时间为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "创建时间，默认值：CURRENT_TIMESTAMP", required = true, position = 16 )
    private Date createTime;
    /**
     * 状态：1已解析，0未解析
     */
    @NotNull(message = "状态：1已解析，0未解析为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "状态：1已解析，0未解析，默认值：0", required = true, position = 17 )
    private Integer status;

}
