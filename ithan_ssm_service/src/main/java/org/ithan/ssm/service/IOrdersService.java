package org.ithan.ssm.service;

import org.ithan.ssm.domain.Orders;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/6 17:33
 **/
public interface IOrdersService {

    List<Orders> findAll(int page,int size) throws Exception;

    Orders findById(Integer id) throws Exception;
}
