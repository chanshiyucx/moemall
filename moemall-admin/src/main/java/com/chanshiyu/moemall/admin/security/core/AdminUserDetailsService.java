package com.chanshiyu.moemall.admin.security.core;

import com.chanshiyu.moemall.admin.service.UmsAdminService;
import com.chanshiyu.moemall.mbg.model.UmsAdmin;
import com.chanshiyu.moemall.mbg.model.UmsPermission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author SHIYU
 * @date 2019/10/9 16:34
 * @description SpringSecurity 定义的核心接口，用于根据用户名获取用户信息
 */
@Component
@Slf4j
public class AdminUserDetailsService implements UserDetailsService {

    @Autowired
    private UmsAdminService umsAdminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmsAdmin admin = umsAdminService.getAdminByUsername(username);
        if (admin == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        List<UmsPermission> permissionList = umsAdminService.getPermissionList(admin.getId());
        return new AdminUserDetails(admin, permissionList);
    }

}
