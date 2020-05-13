package org.ithan.ssm.service;

import org.ithan.ssm.domain.Permission;
import org.ithan.ssm.domain.Role;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/13 8:28
 **/

public interface IRoleService {

    public List<Role> findAll()throws Exception;

    void save(Role role) throws Exception;

    Role findById(Integer id)throws Exception;

    void deleteRoleById(Integer roleId) throws Exception;

    List<Permission> findOtherPermissions(Integer roleId) throws Exception;

    void addPermissionToRole(Integer roleId, Integer[] permissionIds);
}
