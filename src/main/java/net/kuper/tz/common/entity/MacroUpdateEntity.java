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

/**
 * 变更字典
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
@ApiModel(value = "变更字典")
@Data
public class MacroUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "", required = true, position = 0 )
    private String id;
    /**
     * 父级id
     */
    @NotBlank(message = "上级Key不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 50 ,message = "上级Key不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "上级Key，最大长度：50", required = true, position = 1 )
    private String parentKey;
    /**
     * 显示名称
     */
    @NotNull(message = "显示名称为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "显示名称不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 30 ,message = "显示名称不能超过30个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "显示名称，最大长度：30", required = true, position = 2 )
    private String displayName;
    /**
     * 键，隐式名称
     */
    @NotNull(message = "键，隐式名称为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "键，隐式名称不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 50 ,message = "键，隐式名称不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "键，隐式名称，最大长度：50", required = true, position = 3 )
    private String key;
    /**
     * 值
     */
    @NotNull(message = "值为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "值不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 2000 ,message = "值不能超过2,000个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "值，最大长度：2,000", required = true, position = 4 )
    private String value;
    /**
     * 状态，0：隐藏   1：显示
     */
    @NotNull(message = "状态，0：隐藏   1：显示为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "状态，0：隐藏   1：显示，默认值：1", required = true, position = 5 )
    private Integer status;
    /**
     * 类型,0:目录，1:参数配置
     */
    @NotNull(message = "类型,0:目录，1:参数配置为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "类型,0:目录，1:参数配置", required = true, position = 6 )
    private Integer type;
    /**
     * 普通用户是否可编辑，0不可以，1可以
     */
    @NotNull(message = "普通用户是否可编辑，0不可以，1可以为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "普通用户是否可编辑，0不可以，1可以，默认值：0", required = true, position = 7 )
    private Integer edit;
    /**
     * 排序
     */
    @NotNull(message = "排序为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "排序，默认值：1", required = true, position = 8 )
    private Integer orderNum;
    /**
     * 备注
     */
    @Length(max = 500 ,message = "备注不能超过500个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "备注，最大长度：500", position = 9 )
    private String remark;

}
