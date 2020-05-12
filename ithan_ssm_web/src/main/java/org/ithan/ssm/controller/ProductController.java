package org.ithan.ssm.controller;

import org.ithan.ssm.domain.Product;
import org.ithan.ssm.service.IProductService;
import org.ithan.ssm.utils.DateStringEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/4 12:24
 **/
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

//    @InitBinder
//    public void  initBinder(WebDataBinder binder){
//        binder.registerCustomEditor(Date.class,new DateStringEditor());
//    }

    /**
     * 产品添加
     * @param product
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }

    /**
     * 查询全部产品
     * @return
     * @throws Exception
     */
    @RequestMapping("findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list1");
        return mv;
    }

}
