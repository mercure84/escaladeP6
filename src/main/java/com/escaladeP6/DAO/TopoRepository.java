package com.escaladeP6.DAO;
import com.escaladeP6.beans.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Integer> {

List<Topo> findToposByDepartement(int numDpt);

@Query("Select topo from Topo topo Where (?1=0 or topo.departement = ?1) and (?2='all' or topo.difficulte =?2 ) and (topo.disponible = ?3)")
List<Topo> filtrerTopos(int numDpt, String difficulte, boolean disponible);



}

