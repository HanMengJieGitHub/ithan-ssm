package org.ithan.ssm.service;

import org.ithan.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/12 13:33
 **/
public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo)throws Exception;

    UserInfo findById(Integer id) throws Exception;
}
