package net.kuper.tz.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 区域
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
@ApiModel(value = "区域")
@Data
public class AreaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    private Integer id;
    /**
     * 父级ID
     */
    @ApiModelProperty(value = "父级ID")
    private Integer parentId;
    
    @ApiModelProperty(value = "父级")
    private String parentName;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "ID路径")
    private String path;
    /**
     * 简称
     */
    @ApiModelProperty(value = "简称")
    private String shortName;
    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private Float longitude;
    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private Float latitude;
    /**
     * 等级(1省/直辖市,2地级市,3区县,4镇/街道)
     */
    @ApiModelProperty(value = "等级(1省/直辖市,2地级市,3区县,4镇/街道)")
    private Integer level;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;
    /**
     * 状态(0禁用/1启用)
     */
    @ApiModelProperty(value = "状态(0禁用/1启用)")
    private Integer status;
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
