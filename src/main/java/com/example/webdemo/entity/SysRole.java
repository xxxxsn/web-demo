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
@TableName(value = "sys_role")
public class SysRole implements Serializable {
    /**
     * 角色ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称，英文名称
     */
    @TableField(value = "rolename")
    private String rolename;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    private static final long serialVersionUID = 1L;
}