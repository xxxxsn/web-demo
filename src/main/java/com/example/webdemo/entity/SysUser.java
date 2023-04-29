package com.example.webdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
* Description:
* @Author xiesn
* @Create 2023/4/22 19:12
*/
@Data
@TableName(value = "sys_user")
public class SysUser implements Serializable {
    /**
     * 编号
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 登陆名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 是否启动账户0禁用 1启用
     */
    @TableField(value = "enabled")
    private Integer enabled;

    /**
     * 账户是否没有过期0已过期 1 正常
     */
    @TableField(value = "account_no_expired")
    private Integer accountNoExpired;

    /**
     * 密码是否没有过期0已过期 1 正常
     */
    @TableField(value = "credentials_no_expired")
    private Integer credentialsNoExpired;

    /**
     * 账户是否没有锁定0已锁定 1 正常
     */
    @TableField(value = "account_no_locked")
    private Integer accountNoLocked;

    private static final long serialVersionUID = 1L;
}