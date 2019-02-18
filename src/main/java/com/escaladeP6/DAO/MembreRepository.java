package com.escaladeP6.DAO;
import com.escaladeP6.beans.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MembreRepository extends JpaRepository<Membre, Integer> {

}
