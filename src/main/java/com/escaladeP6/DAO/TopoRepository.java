package com.escaladeP6.DAO;
import com.escaladeP6.beans.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Integer> {

List<Topo> findToposByDepartementAndDifficulteAndNbVoiesIsBetweenAndDisponible (int Departement, String Difficulte, int nbVoiesmin, int nbVoiesmax, boolean disponible);

List<Topo> findToposByDepartement(int numDpt);
}
