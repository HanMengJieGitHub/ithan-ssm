package org.ithan.ssm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.ithan.ssm.domain.Product;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/4 11:36
 **/
public interface IProductDao {

    @Select("select * from product where productId=#{id}")
    Product findById(Integer id)throws Exception;
    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * 产品保存
     * @param product
     * @throws Exception
     */
    @Insert("insert into product(productName,cityName,DepartureTime,productPrice,productDesc,productStatus) " +
            "values(#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;


}
