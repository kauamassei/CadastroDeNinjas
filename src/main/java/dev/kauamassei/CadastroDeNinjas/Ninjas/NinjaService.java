package dev.kauamassei.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    // injecao de dependencias
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // lista os ninjas
    public List<NinjaDTO> listarNinjas() {
       List<NinjaModel> ninjas = ninjaRepository.findAll();
       return ninjas.stream()
               .map(ninjaMapper::map)
               .collect(Collectors.toList());
    }

    // busca por ID
    public NinjaDTO listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    // Cria ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Deleta ninja
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Atualizar ninja - pego o id do ninja e o corpo da requisicao
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        if (ninjaPorId.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }

        return null;

    }

}
