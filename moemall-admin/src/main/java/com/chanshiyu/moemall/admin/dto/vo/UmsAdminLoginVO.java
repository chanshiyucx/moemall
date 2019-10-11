package com.chanshiyu.moemall.admin.dto.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author SHIYU
 * @date 2019/10/11 16:48
 * @description 登录返回数据
 */
@Data
public class UmsAdminLoginVO {

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

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

    @ApiModelProperty("Token")
    private String token;

}
