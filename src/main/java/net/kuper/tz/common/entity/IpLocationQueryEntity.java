package net.kuper.tz.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.PaginationQuery;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;
/**
 * 分页查询
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-20 01:18:37
 */
@ApiModel(value = "分页查询")
@Data
public class IpLocationQueryEntity extends PaginationQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * IP地址
    */
    @Length(max = 64 ,message = "IP地址不能超过64个字符")
    @ApiModelProperty(value = "IP地址，最大长度：64", required = true, position = 1 )
    private String ip;
    /**
    * 省
    */
    @Length(max = 45 ,message = "省不能超过45个字符")
    @ApiModelProperty(value = "省，最大长度：45", position = 2 )
    private String province;
    /**
    * 市
    */
    @Length(max = 45 ,message = "市不能超过45个字符")
    @ApiModelProperty(value = "市，最大长度：45", position = 3 )
    private String city;
    /**
    * 区县
    */
    @Length(max = 45 ,message = "区县不能超过45个字符")
    @ApiModelProperty(value = "区县，最大长度：45", position = 4 )
    private String district;
    /**
    * 地址
    */
    @Length(max = 60 ,message = "地址不能超过60个字符")
    @ApiModelProperty(value = "地址，最大长度：60", position = 5 )
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
    @Length(max = 20 ,message = "城市编码 不能超过20个字符")
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
    @Length(max = 45 ,message = "运营商不能超过45个字符")
    @ApiModelProperty(value = "运营商，最大长度：45", position = 8 )
    private String business;
    @Length(max = 20 ,message = "不能超过20个字符")
    @ApiModelProperty(value = "，最大长度：20", position = 9 )
    private String centerX;
    @Length(max = 20 ,message = "不能超过20个字符")
    @ApiModelProperty(value = "，最大长度：20", position = 10 )
    private String centerY;
    @Length(max = 20 ,message = "不能超过20个字符")
    @ApiModelProperty(value = "，最大长度：20", position = 11 )
    private String rectangleLeftBottomX;
    @Length(max = 20 ,message = "不能超过20个字符")
    @ApiModelProperty(value = "，最大长度：20", position = 12 )
    private String rectangleLeftBottomY;
    @Length(max = 20 ,message = "不能超过20个字符")
    @ApiModelProperty(value = "，最大长度：20", position = 13 )
    private String rectangleRightTopX;
    @Length(max = 20 ,message = "不能超过20个字符")
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
    @ApiModelProperty(value = "创建时间，默认值：CURRENT_TIMESTAMP", required = true, position = 16 )
    private Date createTime;
    /**
    * 状态：1已解析，0未解析
    */
    @ApiModelProperty(value = "状态：1已解析，0未解析，默认值：0", required = true, position = 17 )
    private Integer status;

}
