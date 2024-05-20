package home.manager.api.service;

import home.manager.api.model.costant.Grupo;
import home.manager.api.model.item.marca.entity.Marca;
import home.manager.api.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public Marca criarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public List<Marca> buscarTodasMarcas() {
        List<Marca> marcas = marcaRepository.findAll().stream().toList();
        return marcas;
    }

    public Marca buscarMarcaPorId(Long id) {
        Optional<Marca> marcaOptional = marcaRepository.findById(id);
        return marcaOptional.orElse(null);
    }
    public Marca atualizarMarca(Long id, Marca marcaAtualizada) {
        Optional<Marca> marcaOptional = marcaRepository.findById(id);
        if (marcaOptional.isPresent()) {
            Marca marcaExistente = marcaOptional.get();
            marcaExistente.setNome(marcaAtualizada.getNome());
            marcaExistente.setGrupo(Grupo.valueOf(marcaAtualizada.getGrupo().getDescricao()));
            return marcaRepository.save(marcaExistente);
        } else {
            return null;
        }
    }

    public void excluirMarca(Long id) {
        marcaRepository.deleteById(id);
    }
}
