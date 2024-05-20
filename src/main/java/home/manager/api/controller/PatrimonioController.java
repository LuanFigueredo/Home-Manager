package home.manager.api.controller;

import home.manager.api.model.item.patrimonio.entity.Patrimonio;
import home.manager.api.service.PatrimonioService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrimonio")
@CrossOrigin(origins = "http://localhost:5173")
@Log4j2
public class PatrimonioController {
    @Autowired
    private PatrimonioService patrimonioService;


    @PostMapping
    public ResponseEntity<Patrimonio> criarPatrimonio(@RequestBody Patrimonio patrimonio) {
        Patrimonio novoPatrimonio = patrimonioService.criarPatrimonio(patrimonio);
        return new ResponseEntity<>(novoPatrimonio, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Patrimonio>> buscarTodosPatrimonios() {
        List<Patrimonio> patrimonios = patrimonioService.buscarTodosPatrimonios();
        return new ResponseEntity<>(patrimonios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patrimonio> buscarPatrimonioPorId(@PathVariable Long id) {
        Patrimonio patrimonio = patrimonioService.buscarPatrimonioPorId(id);
        return new ResponseEntity<>(patrimonio, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patrimonio> atualizarPatrimonio(@PathVariable Long id, @RequestBody Patrimonio patrimonioAtualizado) {
        Patrimonio patrimonio = patrimonioService.atualizarPatrimonio(id, patrimonioAtualizado);
        return new ResponseEntity<>(patrimonio, HttpStatus.OK);
    }

    // Endpoint para excluir um patrimônio
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirPatrimonio(@PathVariable Long id) {
        patrimonioService.excluirPatrimonio(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
