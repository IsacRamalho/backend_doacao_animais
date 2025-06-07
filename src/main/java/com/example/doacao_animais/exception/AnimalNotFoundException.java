package com.example.doacao_animais.exception;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(Long id) {
        super("Animal com ID " + id + " não encontrado.");
    }
}