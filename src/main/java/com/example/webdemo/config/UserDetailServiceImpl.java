package com.example.webdemo.config;

import cn.hutool.log.Log;
import com.example.webdemo.entity.SysMenu;
import com.example.webdemo.entity.SysUser;
import com.example.webdemo.service.SysMenuService;
import com.example.webdemo.service.SysUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.core.utils.StringUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @Author xiesn
 * @Create 2023/4/22 14:35
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final SysUserService sysUserService;
    private final SysMenuService sysMenuService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUserDetails userDetails = new SysUserDetails();

        //查询用户
        SysUser sysUser = sysUserService.getUserByUsername(username);
        if (null==sysUser) {
            log.error("用户不存在[{}]",username);
            throw new UsernameNotFoundException("用户不存在");
        }
        userDetails.setSysUser(sysUser);
        //查询权限
        List<SysMenu> sysMenuList = sysMenuService.getSysmenuByUserId(sysUser.getUserId());

        List<SimpleGrantedAuthority> simpleGrantedAuthorities = sysMenuList.stream().map(SysMenu::getCode)
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        userDetails.setGrantedAuthorities(simpleGrantedAuthorities);
        return userDetails;
    }
}
