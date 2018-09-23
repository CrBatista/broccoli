package com.broccoli.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.broccoli.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String>{

	User findUserByName(String name);

}
