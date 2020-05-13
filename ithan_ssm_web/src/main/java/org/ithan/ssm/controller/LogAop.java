package org.ithan.ssm.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.ithan.ssm.domain.SysLog;
import org.ithan.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author HanMengJie
 * @Date 2020/5/13 21:07
 **/
@Component
@Aspect
public class LogAop {

    private Date visitTime;

    private Class clazz;

    private Method method;

    @Autowired
    private ISysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;
    /*
     * 前置通知
     */
    @Before("execution(* org.ithan.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        //开始时间
        visitTime = new Date();
        clazz = joinPoint.getTarget().getClass();//具体访问的类
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取访问的方法的名称
        Object[] args = joinPoint.getArgs();
        if (args==null||args.length==0){
            //无参
            method = clazz.getMethod(methodName);
        }else {
            //有参
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            clazz.getMethod(methodName,classArgs);
        }

    }
    /*
     * 后置通知
     */
    @After("execution(* org.ithan.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        //访问时长
        long time = new Date().getTime() - visitTime.getTime();
        String url = "";
        //获取url
        if (clazz!=null&&method!=null&&clazz!=LogAop.class){
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation!=null){
                String[] classValue = classAnnotation.value();
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation!=null){
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                    //获取ip
                    String ip = request.getRemoteAddr();
                    //获取当前用户
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名]"+clazz.getName()+"[方法名] "+method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);
                    sysLogService.saveLog(sysLog);
                }
            }
        }


    }

}
