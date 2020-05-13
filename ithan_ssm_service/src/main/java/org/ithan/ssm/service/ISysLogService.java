package org.ithan.ssm.service;

import org.ithan.ssm.domain.SysLog;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/13 21:50
 **/
public interface ISysLogService {

    void saveLog(SysLog sysLog) throws Exception;

    List<SysLog> findAll() throws Exception;

}
