package dev.kauamassei.CadastroDeNinjas.Ninjas;

import dev.kauamassei.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    // DTO - Data Transfer Object
    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private String rank;
    private int idade;
    private MissoesModel missoes;

}
