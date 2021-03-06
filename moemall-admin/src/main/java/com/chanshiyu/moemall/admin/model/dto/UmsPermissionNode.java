package com.chanshiyu.moemall.admin.model.dto;

import com.chanshiyu.moemall.mbg.model.UmsPermission;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/12 10:44
 * @description 后台用户权限节点
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UmsPermissionNode extends UmsPermission {

    private List<UmsPermissionNode> children;

}
