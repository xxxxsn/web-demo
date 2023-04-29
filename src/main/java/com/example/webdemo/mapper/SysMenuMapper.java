package com.example.webdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webdemo.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 *
 * @Author xiesn
 * @Create 2023/4/22 19:12
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getSysmenuByUserId(@Param("userId") Integer userId);
}
