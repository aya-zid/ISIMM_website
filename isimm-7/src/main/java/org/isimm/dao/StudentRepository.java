package org.isimm.dao;

import java.util.List;

import org.isimm.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentRepository extends JpaRepository <Student, Long> {
public Page<Student> findByCycleAndSpecialiteAndNiveauEtude(String mc1,String mc2,Long mc3,Pageable pageable);
List<Student> findByCycleAndSpecialiteAndNiveauEtude(String mc1, String mc2, Long mc3);
}
