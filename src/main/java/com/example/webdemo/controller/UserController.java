package com.example.webdemo.controller;

import net.dreamlu.mica.core.result.R;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author xiesn
 * @date 2022/04/08 10:03
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @PreAuthorize("hasAuthority('user:add')")
    @GetMapping("/add")
    public R add() {
        return R.success("增加一条用户信息");
    }

    @PreAuthorize("hasAuthority('user:add')")
    @GetMapping("/update")
    public R update() {
        return R.success("更新一条用户信息");
    }

    @PreAuthorize("hasAuthority('user:add')")
    @GetMapping("/delete")
    public R delete() {
        return R.success("删除一条用户信息");
    }

    @PreAuthorize("hasAuthority('user:query')")
    @GetMapping("/query")
    public R query(Authentication authentication) {
        return R.success(authentication);
    }


}
