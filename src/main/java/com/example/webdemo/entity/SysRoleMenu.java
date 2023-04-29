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
@TableName(value = "sys_role_menu")
public class SysRoleMenu implements Serializable {
    /**
     * 菜单表的编号
     */
    private Integer mid;

    /**
     * 角色表的编号
     */
    private Integer rid;

    private static final long serialVersionUID = 1L;
}
