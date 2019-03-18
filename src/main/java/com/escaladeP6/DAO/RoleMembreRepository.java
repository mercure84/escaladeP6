package com.escaladeP6.DAO;


import com.escaladeP6.beans.RoleMembre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMembreRepository extends JpaRepository<RoleMembre, Integer> {

}
