package com.guilherme.apidecursos.modules.curso.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.apidecursos.modules.curso.entities.CursoEntity;

public interface CursoRepository extends JpaRepository<CursoEntity, UUID>{
    Optional<CursoEntity> findByName(String name);
    Optional<CursoEntity> findById(UUID id);
}