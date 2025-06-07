package com.example.doacao_animais.controller;

import com.example.doacao_animais.animal.Animal;
import com.example.doacao_animais.animal.AnimalRepository;
import com.example.doacao_animais.animal.AnimalRequestDTO;
import com.example.doacao_animais.animal.AnimalResponseDTO;
import com.example.doacao_animais.exception.AnimalNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/animais")

public class AnimaisController {

    @Autowired
    private AnimalRepository repository;

    @PostMapping
    public ResponseEntity<String> saveAnimal(@RequestBody AnimalRequestDTO data) {
        validateAnimalData(data); // Valida os dados do animal
        Animal animalData = new Animal(data);
        repository.save(animalData);
        return ResponseEntity.status(HttpStatus.CREATED).body("Animal criado com sucesso.");
    }
    @GetMapping
    public List<AnimalResponseDTO> getAll(){
        List<AnimalResponseDTO> animalList = repository.findAll().stream().map(AnimalResponseDTO::new).toList();
        return animalList;
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AnimalResponseDTO> updateAnimal(@PathVariable Long id, @RequestBody AnimalRequestDTO data) {
        validateAnimalData(data);
        Animal animal = repository.findById(id).orElseThrow(() -> new AnimalNotFoundException(id));
        animal.updateFromDTO(data);
        repository.save(animal);
        return ResponseEntity.ok(new AnimalResponseDTO(animal));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    private void validateAnimalData(AnimalRequestDTO data) {
        if (data.nome() == null || data.nome().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        if (data.idade() == null) {
            throw new IllegalArgumentException("Idade não pode ser nula.");
        }
        if (data.idade() < 0) {
            throw new IllegalArgumentException("Idade deve ser um número positivo.");
        }
    }
}

