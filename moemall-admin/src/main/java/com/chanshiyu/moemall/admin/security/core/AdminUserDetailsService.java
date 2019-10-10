package com.chanshiyu.moemall.admin.security.core;

import com.chanshiyu.moemall.admin.service.UmsAdminService;
import com.chanshiyu.moemall.mbg.model.UmsAdmin;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author SHIYU
 * @date 2019/10/9 16:34
 * @description SpringSecurity 定义的核心接口，用于根据用户名获取用户信息
 */
//@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminUserDetailsService implements UserDetailsService {

    private final UmsAdminService umsAdminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmsAdmin admin = umsAdminService.getAdminByUsername(username);
        return null;
    }

}
