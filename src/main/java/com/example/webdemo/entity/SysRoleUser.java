package com.example.webdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * Description:
 *
 * @Author xiesn
 * @Create 2023/4/22 19:12
 */
@Data
@TableName(value = "sys_role_user")
public class SysRoleUser implements Serializable {
    /**
     * 用户编号
     */
    private Integer uid;

    /**
     * 角色编号
     */
    private Integer rid;

    private static final long serialVersionUID = 1L;
}
