package org.ithan.ssm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.ithan.ssm.domain.SysLog;

import java.util.List;

/**
 * @Author HanMengJie
 * @Date 2020/5/13 21:52
 **/
public interface ISysLogDao {
    @Select("select * from syslog")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "visitTime", property = "visitTime"),
            @Result(column = "ip", property = "ip"),
            @Result(column = "url", property = "url"),
            @Result(column = "executionTime", property = "executionTime"),
            @Result(column = "method", property = "method"),
            @Result(column = "username", property = "username")})
    public List<SysLog> findAll() throws Exception;

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void saveLog(SysLog sysLog) throws Exception;

}
