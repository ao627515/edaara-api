package com.forcen.edaara.repository;

import com.forcen.edaara.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
    @Query("SELECT c FROM Cours c WHERE c.formateur.nom = :nomFormateur")
    List<Cours> findByFormateurNom(@Param("nomFormateur") String nomFormateur);

}
