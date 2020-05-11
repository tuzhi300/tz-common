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
 * @date 2020-03-19 11:50:55
 */
@ApiModel(value = "变更")
@Data
public class ExceptionCaseUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：45", required = true, position = 0 )
    private String id;
    @NotNull(message = "为必填", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "不能为空字符", groups = {AddGroup.class, UpdateGroup.class})
    @Length(max = 45 ,message = "不能超过45个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：45", required = true, position = 1 )
    private String exceptionId;
    @Length(max = 45 ,message = "不能超过45个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：45", position = 2 )
    private String serVersion;
    @Length(max = 30 ,message = "不能超过30个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "，最大长度：30", position = 3 )
    private Date serBuildTime;
    /**
     * 请求地址
     */
    @Length(max = 255 ,message = "请求地址不能超过255个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "请求地址，最大长度：255", position = 4 )
    private String servletPath;
    /**
     * 创建时间
     */
    @NotNull(message = "创建时间为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "创建时间，默认值：CURRENT_TIMESTAMP", required = true, position = 5 )
    private Date createTime;

}
