package com.maxtrain.prs.business.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUsernameAndPassword(String uname, String pwd);
}
