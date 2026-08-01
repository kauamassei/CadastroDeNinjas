package dev.kauamassei.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissao() {
        return "Missoes listadas com sucesso";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missao criada com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missoes listadas com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missoes listadas com sucesso";
    }


}
