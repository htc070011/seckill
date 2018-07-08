package com.bupt.miaoshao.dao;

import com.bupt.miaoshao.domain.model.MUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MUserInfoBiz {

    @Select("select * from miaosha_user where mobile = #{mobile}")
    MUserInfo getMUserInfoByMobile(@Param("mobile") String mobile);

}
