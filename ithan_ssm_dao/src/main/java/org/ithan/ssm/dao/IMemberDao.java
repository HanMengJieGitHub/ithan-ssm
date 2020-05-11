package org.ithan.ssm.dao;

import org.apache.ibatis.annotations.Select;
import org.ithan.ssm.domain.Member;

/**
 * @Author HanMengJie
 * @Date 2020/5/11 20:50
 **/
public interface IMemberDao {

    @Select("select * from `member` where id=#{id}")
    Member findById(int id) throws Exception;


}
