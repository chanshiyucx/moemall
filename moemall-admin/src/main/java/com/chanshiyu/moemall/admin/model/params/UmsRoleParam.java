package com.chanshiyu.moemall.admin.model.params;

import com.chanshiyu.moemall.mbg.model.UmsRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/14 9:44
 * @description 用户角色参数
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UmsRoleParam extends UmsRole {

    @ApiModelProperty(value = "权限ID", required = true)
    @NotEmpty(message = "权限不能为空")
    List<Long> permissionIds;

}
