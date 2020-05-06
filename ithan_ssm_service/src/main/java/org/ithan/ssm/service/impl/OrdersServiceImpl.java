package org.ithan.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.ithan.ssm.dao.IOrdersDao;
import org.ithan.ssm.domain.Orders;
import org.ithan.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/6 17:34
 **/
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }
}
