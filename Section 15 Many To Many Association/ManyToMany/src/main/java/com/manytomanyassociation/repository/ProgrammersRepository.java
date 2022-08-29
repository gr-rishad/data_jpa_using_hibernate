package com.manytomanyassociation.repository;

import com.manytomanyassociation.entity.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammersRepository extends JpaRepository<Programmer,Integer> {
}
