package net.kuper.tz.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.kuper.tz.core.mybatis.PaginationQuery;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;
/**
 * 分页查询短信日志
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-07 15:29:26
 */
@ApiModel(value = "分页查询短信日志")
@Data
public class SmsLogQueryEntity extends PaginationQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 备注信息
    */
    @Length(max = 255 ,message = "备注信息不能超过255个字符")
    @ApiModelProperty(value = "备注信息，最大长度：255", position = 1 )
    private String remarks;
    /**
    * 业务类型
    */
    @Length(max = 4 ,message = "业务类型不能超过4个字符")
    @ApiModelProperty(value = "业务类型，最大长度：4", required = true, position = 2 )
    private String businessType;
    /**
    * 联系电话
    */
//    @Length(max = 4294967295 ,message = "联系电话不能超过4,294,967,295个字符")
    @ApiModelProperty(value = "联系电话，最大长度：4,294,967,295", required = true, position = 3 )
    private String phone;
    /**
    * 模板ID
    */
    @Length(max = 8 ,message = "模板ID不能超过8个字符")
    @ApiModelProperty(value = "模板ID，最大长度：8", position = 4 )
    private String templateId;
    /**
    * 模板类型
    */
    @Length(max = 255 ,message = "模板类型不能超过255个字符")
    @ApiModelProperty(value = "模板类型，最大长度：255", position = 5 )
    private String templateContent;
    /**
    * 发送数据
    */
    @Length(max = 255 ,message = "发送数据不能超过255个字符")
    @ApiModelProperty(value = "发送数据，最大长度：255", required = true, position = 6 )
    private String senddata;
    /**
    * 发送状态
    */
    @Length(max = 4 ,message = "发送状态不能超过4个字符")
    @ApiModelProperty(value = "发送状态，最大长度：4", required = true, position = 7 )
    private String status;
    /**
    * 发送响应消息ID
    */
    @Length(max = 50 ,message = "发送响应消息ID不能超过50个字符")
    @ApiModelProperty(value = "发送响应消息ID，最大长度：50", position = 8 )
    private String smsid;
    /**
    * 返回码
    */
    @Length(max = 40 ,message = "返回码不能超过40个字符")
    @ApiModelProperty(value = "返回码，最大长度：40", position = 9 )
    private String code;
    /**
    * 返回消息
    */
    @Length(max = 40 ,message = "返回消息不能超过40个字符")
    @ApiModelProperty(value = "返回消息，最大长度：40", position = 10 )
    private String msg;
    /**
    * 删除标记（0：正常；-1：删除）
    */
    @ApiModelProperty(value = "删除标记（0：正常；-1：删除），默认值：0", required = true, position = 11 )
    private Integer flag;
    /**
    * 响应时间
    */
    @ApiModelProperty(value = "响应时间", position = 12 )
    private Date responseDate;
    /**
    * 变更时间
    */
    @ApiModelProperty(value = "变更时间", position = 13 )
    private Date updateTime;
    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间，默认值：CURRENT_TIMESTAMP", required = true, position = 14 )
    private Date createTime;
    /**
    * 删除： >=1:是 ，0:否
    */
    @ApiModelProperty(value = "删除： >=1:是 ，0:否，默认值：0", required = true, position = 15 )
    private Date deleteTime;


}
