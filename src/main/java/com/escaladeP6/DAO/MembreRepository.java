package com.escaladeP6.DAO;
import com.escaladeP6.beans.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembreRepository extends JpaRepository<Membre, Integer> {


List<Membre> findMembreById(int id);

String findMembreByPseudo(String pseudo);

}
