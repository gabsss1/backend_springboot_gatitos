package gabsss.backend.controller;

import gabsss.backend.model.Gatos;
import gabsss.backend.service.GatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gatos")
public class GatosController {
    private final GatosService gatosService;

    @Autowired
    public GatosController(GatosService gatosService){
        this.gatosService = gatosService;
    }
    @PostMapping
    public ResponseEntity<Gatos> createGatos(@RequestBody Gatos gatos){
        Gatos newGatos = gatosService.createGatos(gatos);
        return new ResponseEntity<>(newGatos,HttpStatus.CREATED);
    }
    @GetMapping
    public List<Gatos> getAllGatos(){
        return gatosService.getAllGatos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Gatos> getGatosById(@PathVariable String id){
        Optional<Gatos> gatos = gatosService.getGatosById(id);
        return gatos.map(ResponseEntity::ok).orElseGet( () -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Gatos> updateGatos(@PathVariable String id, @RequestBody Gatos updateGatos) {
        Gatos gatos = gatosService.updateGatos(id, updateGatos);
        return gatos != null ? ResponseEntity.ok(gatos) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGatos(@PathVariable String id) {
        boolean isDeleted = gatosService.deleteGatos(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
