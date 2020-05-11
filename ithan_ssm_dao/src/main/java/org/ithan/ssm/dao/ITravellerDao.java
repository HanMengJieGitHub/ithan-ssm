package org.ithan.ssm.dao;

import org.apache.ibatis.annotations.Select;
import org.ithan.ssm.domain.Traveller;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/11 20:52
 **/
public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(int ordersId) throws Exception;
}
