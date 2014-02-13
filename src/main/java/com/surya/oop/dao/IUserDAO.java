package com.surya.oop.dao;

import com.surya.oop.po.UserPO;

public interface IUserDAO extends IBaseDAO<UserPO> {
	UserPO findUser(String emailId);
	UserPO save(UserPO user);
}
