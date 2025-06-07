package com.example.doacao_animais.animal;

public record AnimalResponseDTO(Long id, String nome, String imagem, String tipo, Integer idade, String raca, String statusadocao, String descr) {
    public AnimalResponseDTO(Animal animal) { this(animal.getId(), animal.getNome(), animal.getImagem(), animal.getTipo(), animal.getIdade(), animal.getRaca(), animal.getStatusadocao(), animal.getDescr());
    }
}
