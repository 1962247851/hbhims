package com.example.hbhims.service;

import com.example.hbhims.entity.SysRole;
import com.sun.istack.Nullable;

import java.util.List;

/**
 * 权限表(SysRole)表服务接口
 */
public interface SysRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Nullable
    SysRole queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysRole> queryAllByLimit(Long offset, Long limit);

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    SysRole insert(SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    SysRole update(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    @Nullable
    SysRole queryByRoleName(String roleName);

    @Nullable
    SysRole queryByRoleCode(String roleCode);

    /**
     * 查询多条数据
     *
     * @return 多条数据
     */
    List<SysRole> queryAll();
}