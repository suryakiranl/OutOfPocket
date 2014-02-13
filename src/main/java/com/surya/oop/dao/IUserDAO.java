package com.surya.oop.dao;

import com.surya.oop.po.UserPO;

public interface IUserDAO {
	UserPO findUser(long id);
	UserPO findUser(String emailId);
	UserPO loadAll();
	UserPO save(UserPO user);
	UserPO delete(UserPO user);
}
