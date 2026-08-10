package dev.kauamassei.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
@CrossOrigin(origins = "http://localhost:5173")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Mostrar todos os ninjas
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Adicionar ninja
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criacão do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaCriado = ninjaService.criarNinja(ninja);
         return ResponseEntity.status(HttpStatus.CREATED)
                .body("O ninja " + ninjaCriado.getNome() + " foi criado com o ID: " + ninjaCriado.getId());
    }

    // Mostrar ninja por ID
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por ID", description = "Rota lista um ninja por seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id) {

        NinjaDTO ninjaPorId = ninjaService.listarNinjaPorId(id);

        if (ninjaPorId != null ) {
            return ResponseEntity.status(HttpStatus.FOUND).body(ninjaPorId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
        }
    }

    // Atualizar dados do ninja
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por ID", description = "Rota altera um ninja por seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, não foi possível alterar.")
    })
    public ResponseEntity<?> alterarNinjaPorId(
            @Parameter(description = "Usuário manda o id no caminho da requisicão.")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do ninja a ser atualizado no caminho da requisicão.")
            @RequestBody NinjaDTO ninjaAtualizado) {

        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);

        if (ninja != null ) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado");
        }
    }

    // Deletar ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity <String> deletarNinjaPorId(@PathVariable Long id) {
        NinjaDTO ninjaDeletado = ninjaService.listarNinjaPorId(id);
        if (ninjaDeletado != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID " + id + " foi deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o ID: " + id + " não foi encontrado.");
        }
    }


}
