package org.ithan.ssm.service.impl;

import org.ithan.ssm.dao.IPermissionDao;
import org.ithan.ssm.domain.Permission;
import org.ithan.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/13 9:05
 **/
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }
}
