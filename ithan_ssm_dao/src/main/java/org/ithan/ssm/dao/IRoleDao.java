package org.ithan.ssm.dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.ithan.ssm.domain.Role;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/12 15:21
 **/
public interface IRoleDao {
    /**
     * 根据用户id查询出所有角色
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where userId=#{id}) ")
    @Results({
            @Result(id = true ,property = "id" ,column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions" ,column = "id" ,javaType = java.util.List.class,
                        many = @Many(select = "org.ithan.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
   public List<Role> findByUserId(Integer id)throws Exception;

}
