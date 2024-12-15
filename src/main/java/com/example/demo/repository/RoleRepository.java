package com.example.demo.repository;

import com.example.demo.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    @Modifying
    @Transactional
    @Query(value = """
            insert into user_and_role(user_id ,role_id) values (:id ,2)
            """, nativeQuery = true)
    void setRole(Integer id);

}
