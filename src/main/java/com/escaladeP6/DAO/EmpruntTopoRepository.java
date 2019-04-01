package com.escaladeP6.DAO;

import com.escaladeP6.beans.EmpruntTopo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpruntTopoRepository extends JpaRepository<EmpruntTopo, Integer> {

    List<EmpruntTopo> findEmpruntToposByEnCoursIsTrue();
}
