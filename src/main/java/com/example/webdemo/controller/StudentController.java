package com.example.webdemo.controller;

import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.core.result.R;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @Author xiesn
 * @Create 2023/4/22 13:05
 */
@RequestMapping("/student")
@RestController

public class StudentController {

    @PreAuthorize("hasAuthority('student:add')")
    @GetMapping("/add")
    public R add() {
        return R.success("增加一条学生信息");
    }

    @PreAuthorize("hasAuthority('student:update')")
    @GetMapping("/update")
    public R update() {
        return R.success("更新一条学生信息");
    }

    @PreAuthorize("hasAuthority('student:delete')")
    @GetMapping("/delete")
    public R delete() {
        return R.success("删除一条学生信息");
    }

    @PreAuthorize("hasAuthority('student:query')")
    @GetMapping("/query")
    public R query() {
        return R.success( SecurityContextHolder.getContext().getAuthentication());
    }

}
