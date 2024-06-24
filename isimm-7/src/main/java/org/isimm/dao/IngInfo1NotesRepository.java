package org.isimm.dao;

import org.isimm.entities.Inginfo1Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngInfo1NotesRepository extends JpaRepository<Inginfo1Notes, Long>{

}
