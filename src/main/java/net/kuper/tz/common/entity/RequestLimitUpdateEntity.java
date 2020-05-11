package net.kuper.tz.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.validator.group.AddGroup;
import net.kuper.tz.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 变更请求限制
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-25 18:02:28
 */
@ApiModel(value = "变更请求限制")
@Data
public class RequestLimitUpdateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @NotNull(message = "id为必填", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "ID，最大长度：45", required = true, position = 0 )
    private String id;
    /**
     * IP
     */
    @Length(max = 64 ,message = "IP不能超过64个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "IP，最大长度：64", position = 1 )
    private String ip;
    /**
     * 接口标记，代码中唯一标识。
     */
    @Length(max = 250 ,message = "接口标记，代码中唯一标识。不能超过250个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "接口标记，代码中唯一标识。，最大长度：250", position = 2 )
    private String limitId;
    /**
     * 会话ID
     */
    @Length(max = 64 ,message = "会话ID不能超过64个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "会话ID，最大长度：64", position = 3 )
    private String sessionId;
    /**
     * 用户Id
     */
    @Length(max = 45 ,message = "用户Id不能超过45个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "用户Id，最大长度：45", position = 4 )
    private String userId;
    /**
     * 接口地址
     */
    @Length(max = 255 ,message = "接口地址不能超过255个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "接口地址，最大长度：255", position = 5 )
    private String url;
    /**
     * 描述
     */
    @Length(max = 50 ,message = "描述不能超过50个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "描述，最大长度：50", position = 6 )
    private String description;
    /**
     * 变更时间
     */
    @ApiModelProperty(value = "变更时间", position = 7 )
    private Date updateTime;
    /**
     * 创建时间
     */
    @NotNull(message = "创建时间为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "创建时间，默认值：CURRENT_TIMESTAMP", required = true, position = 8 )
    private Date createTime;
    /**
     * 删除： >=1:是 ，0:否
     */
    @NotNull(message = "删除： >=1:是 ，0:否为必填", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "删除： >=1:是 ，0:否，默认值：0", required = true, position = 9 )
    private Date deleteTime;

}
