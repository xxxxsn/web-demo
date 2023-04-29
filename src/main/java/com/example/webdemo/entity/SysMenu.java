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
@TableName(value = "sys_menu")
public class SysMenu implements Serializable {
    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父级编号
     */
    @TableField(value = "pid")
    private Integer pid;

    /**
     * 名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 权限编码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 0代表菜单1权限2 url
     */
    @TableField(value = "`type`")
    private Integer type;

    /**
     * 0代表未删除，1 代表已删除
     */
    @TableField(value = "delete_flag")
    private Byte deleteFlag;

    private static final long serialVersionUID = 1L;
}