package home.manager.api.service;

import home.manager.api.model.item.patrimonio.entity.Patrimonio;
import home.manager.api.repository.PatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatrimonioService {
    @Autowired
    private PatrimonioRepository patrimonioRepository;

    public Patrimonio criarPatrimonio(Patrimonio patrimonio) {
        return patrimonioRepository.save(patrimonio);
    }

    public List<Patrimonio> buscarTodosPatrimonios() {
        return patrimonioRepository.findAll();
    }

    public Patrimonio buscarPatrimonioPorId(Long id) {
        Optional<Patrimonio> optionalPatrimonio = patrimonioRepository.findById(id);
        return optionalPatrimonio.orElse(null);
    }

    public Patrimonio atualizarPatrimonio(Long id, Patrimonio patrimonioAtualizado) {
        Patrimonio patrimonioExistente = buscarPatrimonioPorId(id);
        if (patrimonioExistente != null) {
            patrimonioAtualizado.setId(patrimonioExistente.getId());
            return patrimonioRepository.save(patrimonioAtualizado);
        }
        return null;
    }

    public void excluirPatrimonio(Long id) {
        patrimonioRepository.deleteById(id);
    }
}
