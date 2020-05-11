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
 * 变更区域
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
@ApiModel(value = "变更区域")
@Data
public class AreaUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "", required = true, position = 0 )
    private Integer id;
    /**
     * 父级ID
     */
    @NotNull(message = "父级ID为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "父级ID，默认值：0", required = true, position = 1 )
    private Integer parentId;
    /**
     * 名称
     */
    @NotNull(message = "名称为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "名称不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 50 ,message = "名称不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "名称，最大长度：50", required = true, position = 2 )
    private String name;
    /**
     * 简称
     */
    @NotNull(message = "简称为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "简称不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 50 ,message = "简称不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "简称，最大长度：50", required = true, position = 3 )
    private String shortName;
    /**
     * 经度
     */
    @NotNull(message = "经度为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "经度，默认值：0", required = true, position = 4 )
    private Float longitude;
    /**
     * 纬度
     */
    @NotNull(message = "纬度为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "纬度，默认值：0", required = true, position = 5 )
    private Float latitude;
    /**
     * 等级(1省/直辖市,2地级市,3区县,4镇/街道)
     */
    @NotNull(message = "等级(1省/直辖市,2地级市,3区县,4镇/街道)为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "等级(1省/直辖市,2地级市,3区县,4镇/街道)", required = true, position = 6 )
    private Integer level;
    /**
     * 排序
     */
    @NotNull(message = "排序为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "排序，默认值：1", required = true, position = 7 )
    private Integer sort;
    /**
     * 状态(0禁用/1启用)
     */
    @NotNull(message = "状态(0禁用/1启用)为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "状态(0禁用/1启用)，默认值：0", required = true, position = 8 )
    private Integer status;

}
