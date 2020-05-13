package org.ithan.ssm.service;

import org.ithan.ssm.domain.Permission;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/13 9:04
 **/
public interface IPermissionService {

    List<Permission> findAll() throws Exception ;

    void save(Permission permission) throws Exception;
}
