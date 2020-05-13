package org.ithan.ssm.controller;

import org.ithan.ssm.domain.SysLog;
import org.ithan.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/13 22:05
 **/
@Controller
@RequestMapping("sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;
    @RequestMapping("findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll();
        mv.addObject("sysLogs",sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }
}
