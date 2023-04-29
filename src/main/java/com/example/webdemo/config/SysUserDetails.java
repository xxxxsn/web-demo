package com.example.webdemo.config;

import com.example.webdemo.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;

/**
 * Description:
 *
 * @Author xiesn
 * @Create 2023/4/22 14:35
 */
@Data
public class SysUserDetails implements UserDetails {

    private SysUser sysUser;
    private List<SimpleGrantedAuthority> grantedAuthorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return sysUser.getAccountNoExpired() == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return sysUser.getAccountNoLocked() == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return sysUser.getCredentialsNoExpired() == 1;
    }

    @Override
    public boolean isEnabled() {
        return sysUser.getEnabled() == 1;
    }
}
