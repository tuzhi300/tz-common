package net.kuper.tz.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.PaginationQuery;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
/**
 * 分页查询区域
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
@ApiModel(value = "分页查询区域")
@Data
public class AreaQueryEntity extends PaginationQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 父级ID
    */
    @ApiModelProperty(value = "父级ID，默认值：0", required = true, position = 1 )
    private Integer parentId;
    /**
    * 名称
    */
    @Length(max = 50 ,message = "名称不能超过50个字符")
    @ApiModelProperty(value = "名称，最大长度：50", required = true, position = 2 )
    private String name;
    /**
    * 简称
    */
    @Length(max = 50 ,message = "简称不能超过50个字符")
    @ApiModelProperty(value = "简称，最大长度：50", required = true, position = 3 )
    private String shortName;
    /**
    * 经度
    */
    @ApiModelProperty(value = "经度，默认值：0", required = true, position = 4 )
    private Float longitude;
    /**
    * 纬度
    */
    @ApiModelProperty(value = "纬度，默认值：0", required = true, position = 5 )
    private Float latitude;
    /**
    * 等级(1省/直辖市,2地级市,3区县,4镇/街道)
    */
    @ApiModelProperty(value = "等级(1省/直辖市,2地级市,3区县,4镇/街道)", required = true, position = 6 )
    private Integer level;
    /**
    * 排序
    */
    @ApiModelProperty(value = "排序，默认值：1", required = true, position = 7 )
    private Integer sort;
    /**
    * 状态(0禁用/1启用)
    */
    @ApiModelProperty(value = "状态(0禁用/1启用)，默认值：0", required = true, position = 8 )
    private Integer status;


}
