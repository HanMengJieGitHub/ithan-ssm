package org.ithan.ssm.dao;

import org.apache.ibatis.annotations.*;
import org.ithan.ssm.domain.Permission;
import org.ithan.ssm.domain.Role;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/12 15:21
 **/
public interface IRoleDao {
    /**
     * 根据用户id查询出所有角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where userId=#{id}) ")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "org.ithan.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findByUserId(Integer id) throws Exception;

    @Select("select * from role")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "org.ithan.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "org.ithan.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(Integer id) throws Exception;

    @Delete("delete from role where id=#{roleId}")
    void deleteRoleById(Integer roleId) throws Exception;

    @Delete("delete from users_role where roleId=#{roleId}")
    void deleteFromUser_RoleByRoleId(Integer roleId);

    @Delete("delete from role_permission where roleId=#{roleId}")
    void deleteFromRole_PermissionByRoleId(Integer roleId);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(Integer roleId) throws Exception;

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId);
}
