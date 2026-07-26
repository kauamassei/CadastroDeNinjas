package dev.kauamassei.CadastroDeNinjas.Ninjas;

import dev.kauamassei.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// transforma uma classe em uma entidade do banco de dados
// JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String nome;
    private String email;
    private int idade;

    //muitos ninjas so podem fazer uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //foreing key
    private MissoesModel missoes;


}
