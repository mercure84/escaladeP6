package com.escaladeP6.DAO;

import com.escaladeP6.beans.Commentaire;
import com.escaladeP6.beans.Membre;
import com.escaladeP6.beans.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {

    List<Commentaire> findCommentairesByTopoOrderByDateAsc(Topo topo);
    List<Commentaire> findCommentairesByMembre(Membre membre);


}
