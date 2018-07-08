package com.bupt.miaoshao.dao;

import com.bupt.miaoshao.domain.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoBiz {


    @Select("select * from userinfo where id=#{id}")
    UserInfo getUserInfoById(@Param("id") int id);

    @Insert("insert into userinfo(id, name) values(#{id}, #{name})")
    Boolean insertUserInfo(UserInfo userInfo);

}
