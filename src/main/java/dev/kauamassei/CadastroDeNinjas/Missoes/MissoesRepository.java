package dev.kauamassei.CadastroDeNinjas.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;

//Passando qual classe será escaneada pelo ORM e o tipo de dado do ID
public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
