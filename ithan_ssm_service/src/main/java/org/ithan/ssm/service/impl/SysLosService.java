package org.ithan.ssm.service.impl;

import org.ithan.ssm.dao.ISysLogDao;
import org.ithan.ssm.domain.SysLog;
import org.ithan.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/13 21:51
 **/
@Service
@Transactional
public class SysLosService implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void saveLog(SysLog sysLog) throws Exception {
        sysLogDao.saveLog(sysLog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
