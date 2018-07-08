package com.bupt.miaoshao.service;

import com.bupt.miaoshao.dao.UserInfoBiz;
import com.bupt.miaoshao.domain.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserInfoBiz userInfoBiz;

    public UserInfo getUserInfoById(int id) {

        return userInfoBiz.getUserInfoById(id);
    }

    @Transactional
    public boolean insertUserInfo(UserInfo userInfo1, UserInfo userInfo2) {
        userInfoBiz.insertUserInfo(userInfo1);

        return userInfoBiz.insertUserInfo(userInfo2);
    }


}
