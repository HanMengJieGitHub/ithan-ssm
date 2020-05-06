package org.ithan.ssm.dao;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.ithan.ssm.domain.Orders;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/6 17:33
 **/
public interface IOrdersDao {

    @Select("select * from orders")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product",
                    one = @One(select = "org.ithan.ssm.dao.IProductDao.findById"))})
    List<Orders> findAll() throws Exception;


}
