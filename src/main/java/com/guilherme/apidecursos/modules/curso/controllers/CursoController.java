package com.guilherme.apidecursos.modules.curso.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.apidecursos.modules.curso.entities.CursoEntity;
import com.guilherme.apidecursos.modules.curso.useCases.CreateCursoUseCase;

import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CreateCursoUseCase createCursoUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CursoEntity cursoEntity) {
       try{
        var result = this.createCursoUseCase.create(cursoEntity);
        return ResponseEntity.ok().body(result);
       }catch(Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> get() {
        try{
            var result = this.createCursoUseCase.list();
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable UUID id, @RequestBody CursoEntity entity) {
        try{
            var result = this.createCursoUseCase.update(id, entity);
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try{
            var result = this.createCursoUseCase.delete(id);
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> active(@PathVariable UUID id) {
        try{
            var result = this.createCursoUseCase.active(id);
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
