package com.guilherme.apidecursos.modules.curso.useCases;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.apidecursos.modules.curso.entities.CursoEntity;
import com.guilherme.apidecursos.modules.curso.repositories.CursoRepository;

@Service
public class CreateCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity create(CursoEntity cursoEntity) {

        if(cursoEntity.getName().isEmpty() || cursoEntity.getCategory().isEmpty())
            throw new RuntimeException("Campos obrigatórios não preenchidos");

        this.cursoRepository
            .findByName(cursoEntity.getName())
            .ifPresent(curso -> {
                throw new RuntimeException("Curso já existe");
            });

        return this.cursoRepository.save(cursoEntity);
    }

    public ArrayList<CursoEntity> list() {
        return (ArrayList<CursoEntity>) this.cursoRepository.findAll();
    }

    public CursoEntity update(UUID id, CursoEntity cursoEntity) {
        if(cursoEntity.getName().isEmpty() || cursoEntity.getCategory().isEmpty())
            throw new RuntimeException("Campos obrigatórios não preenchidos");

        var curso = this.cursoRepository
                    .findById(id)
                    .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        
        curso.setName(cursoEntity.getName());
        curso.setCategory(cursoEntity.getCategory());
        curso.setActive(cursoEntity.isActive());
        
        return this.cursoRepository.save(curso);
    }

    public CursoEntity delete(UUID id) {
        var curso = this.cursoRepository
                    .findById(id)
                    .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        
        this.cursoRepository.delete(curso);
        return curso;
    }

    public CursoEntity active(UUID id) {
        var curso = this.cursoRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        curso.setActive(curso.isActive() ? false : true);
        return this.cursoRepository.save(curso);
    }

}
