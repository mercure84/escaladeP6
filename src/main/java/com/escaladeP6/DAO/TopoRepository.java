package com.escaladeP6.DAO;
import com.escaladeP6.beans.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Integer> {


}
