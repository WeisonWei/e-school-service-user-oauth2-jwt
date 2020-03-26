package com.es.user.jwt.repository.custom;

import com.es.user.jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserCustomRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, Long> {
}
