package dev.kauamassei.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar todos os ninjas
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas() {
        return "Mostrar ninja";
    }

    // Mostrar ninja por ID
    @GetMapping("/listarID")
    public String mostrarNinjaPorId() {
        return "Ninja ID";
    }
    // Atualizar dados do ninja
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Alterar ninja por ID";
    }
    // Deletar ninja
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja criado";
    }
}
