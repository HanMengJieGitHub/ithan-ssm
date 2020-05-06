package org.ithan.ssm.service;

import org.ithan.ssm.domain.Product;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/4 11:41
 **/
public interface IProductService {
    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws Exception;


    void save(Product product) throws Exception;

}
