package com.example.doacao_animais.animal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Table(name = "animais")
@Entity(name = "animais")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String imagem;
    private String tipo;
    private Integer idade;
    private String raca;
    private String statusadocao;
    private String descr;

    public Animal(AnimalRequestDTO data){
        if (data.nome() == null || data.nome().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        if (data.idade() == null || data.idade() < 0) {
            throw new IllegalArgumentException("Idade deve ser um número positivo.");
        }
        this.nome = data.nome();
        this.imagem = data.imagem();
        this.tipo = data.tipo();
        this.idade = data.idade();
        this.raca = data.raca();
        this.statusadocao = data.statusadocao();
        this.descr = data.descr();
    }
    public void updateFromDTO(AnimalRequestDTO data) {
        if (data.nome() == null || data.nome().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio ao atualizar.");
        }
        if (data.idade() == null || data.idade() < 0) {
            throw new IllegalArgumentException("Idade deve ser um número positivo ao atualizar.");
        }
        this.id = data.id();
        this.nome = data.nome();
        this.imagem = data.imagem();
        this.tipo = data.tipo();
        this.idade = data.idade();
        this.raca = data.raca();
        this.statusadocao = data.statusadocao();
        this.descr = data.descr();
    }

}
