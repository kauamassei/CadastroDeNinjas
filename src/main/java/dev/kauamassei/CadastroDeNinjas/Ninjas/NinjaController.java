package dev.kauamassei.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os ninjas
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por ID
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjaPorId(@PathVariable Long id) {
       return ninjaService.listarNinjaPorId(id);
    }
    // Atualizar dados do ninja
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Alterar ninja por ID";
    }

    // Deletar ninja
    @DeleteMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        return "Ninja deletado";
    }

}
