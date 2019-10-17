package com.chanshiyu.moemall.admin.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/11 16:48
 * @description 后台用户信息
 */
@Data
public class UmsAdminVO {

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    @JsonIgnore
    private String password;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("邮箱")
    private String email;

    @Column(name = "nick_name")
    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("备注信息")
    private String note;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("帐号启用状态：0->禁用；1->启用")
    private Integer status;

    @ApiModelProperty("角色")
    private List<Long> roleIds;

    @ApiModelProperty("权限")
    private List<Long> permissionIds;

    @ApiModelProperty("Token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

}
