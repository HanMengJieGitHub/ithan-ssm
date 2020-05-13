package org.ithan.ssm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.ithan.ssm.domain.Permission;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/12 20:44
 **/
public interface IPermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(Integer id)throws  Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url}) ")
    void save(Permission permission);
}
