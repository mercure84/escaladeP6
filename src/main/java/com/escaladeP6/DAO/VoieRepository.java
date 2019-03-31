package com.escaladeP6.DAO;


import com.escaladeP6.beans.Topo;
import com.escaladeP6.beans.Voie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoieRepository extends JpaRepository<Voie, Integer> {

    List<Voie> findVoiesByTopo(Topo topo);

}
