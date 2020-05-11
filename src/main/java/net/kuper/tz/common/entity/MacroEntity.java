package net.kuper.tz.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
@ApiModel(value = "字典")
@Data
public class MacroEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
     private String id;
    /**
     * 父级id
     */
    @ApiModelProperty(value = "父级id")
    private String parentKey;
    /**
     * 显示名称
     */
    @ApiModelProperty(value = "显示名称")
    private String displayName;
    /**
     * 键，隐式名称
     */
    @ApiModelProperty(value = "键，隐式名称")
    private String key;
    /**
     * 值
     */
    @ApiModelProperty(value = "值")
    private String value;
    /**
     * 状态，0：隐藏   1：显示
     */
    @ApiModelProperty(value = "状态，0：隐藏   1：显示")
    private Integer status;
    /**
     * 类型,0:目录，1:参数配置
     */
    @ApiModelProperty(value = "类型,0:目录，1:参数配置")
    private Integer type;
    /**
     * 普通用户是否可编辑，0不可以，1可以
     */
    @ApiModelProperty(value = "普通用户是否可编辑，0不可以，1可以")
    private Integer edit;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer orderNum;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
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
