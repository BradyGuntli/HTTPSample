package com.HTTPPracticeProject.HTTPPractice.Repository;

import com.HTTPPracticeProject.HTTPPractice.Entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetEntity, Long> {
}
