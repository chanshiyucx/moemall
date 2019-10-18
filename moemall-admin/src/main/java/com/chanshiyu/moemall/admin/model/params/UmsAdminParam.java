package com.chanshiyu.moemall.admin.model.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/10 14:30
 * @description 用户注册参数
 */
@Data
public class UmsAdminParam {

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "用户头像", required = true)
    private String avatar;

    @ApiModelProperty(value = "邮箱", required = true)
    @Email(message = "邮箱格式不合法")
    private String email;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "角色")
    private List<Long> roleIds;

}
