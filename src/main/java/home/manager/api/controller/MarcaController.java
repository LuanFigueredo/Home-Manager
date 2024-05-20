package home.manager.api.controller;
import home.manager.api.model.item.marca.entity.Marca;
import home.manager.api.service.MarcaService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/marca")
@CrossOrigin(origins = "http://localhost:5173")
@Log4j2
public class MarcaController {

    @Autowired
    private  MarcaService marcaService;


    @PostMapping
    public ResponseEntity<Marca> criarMarca(@Valid @RequestBody Marca marca) {
        Marca novaMarca = marcaService.criarMarca(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMarca);
    }

    @GetMapping
    public ResponseEntity<List<Marca>> buscarTodasMarcas() {
        List<Marca> marcas = marcaService.buscarTodasMarcas();
        return ResponseEntity.ok(marcas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarMarcaPorId(@PathVariable Long id) {
        Marca marca = marcaService.buscarMarcaPorId(id);
        if (marca != null) {
            return ResponseEntity.ok(marca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> atualizarMarca(@PathVariable Long id, @Valid @RequestBody Marca marcaAtualizada) {
        Marca marca = marcaService.atualizarMarca(id, marcaAtualizada);
        if (marca != null) {
            return ResponseEntity.ok(marca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMarca(@PathVariable Long id) {
        marcaService.excluirMarca(id);
        return ResponseEntity.noContent().build();
    }
}