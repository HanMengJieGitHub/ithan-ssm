package org.ithan.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.ithan.ssm.domain.Orders;
import org.ithan.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/6 17:38
 **/
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrdersService ordersService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page" ,defaultValue = "1",required = true)int page,
                                @RequestParam(name = "size" ,defaultValue = "4",required = true)int size)
                                throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Orders> orders = ordersService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(orders);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");

        return mv;
    }


}
