package com.example.doacao_animais.animal;

public record AnimalRequestDTO(Long id, String nome, String imagem, String tipo, Integer idade, String raca, String statusadocao, String descr) {
}
