package com.chanshiyu.moemall.admin.model.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author SHIYU
 * @date 2019/11/7 10:14
 * @description 更新用户密码参数
 */
@Data
public class UmsUpdateAdminPasswordParam {

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "旧密码", required = true)
    private String oldPassword;

    @ApiModelProperty(value = "新密码", required = true)
    private String newPassword;

}
