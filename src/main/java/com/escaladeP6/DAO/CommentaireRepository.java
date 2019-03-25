package com.escaladeP6.DAO;

import com.escaladeP6.beans.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {




}
