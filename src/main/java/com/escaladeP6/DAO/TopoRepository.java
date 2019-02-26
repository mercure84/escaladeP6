package com.escaladeP6.DAO;
import com.escaladeP6.beans.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Integer> {

//List<Topo> findToposByDepartementAndDifficulteAnd (int numDept, String difficulte, boolean disponible);


}
