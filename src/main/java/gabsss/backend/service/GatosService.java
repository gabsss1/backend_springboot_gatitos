package gabsss.backend.service;

import gabsss.backend.model.Gatos;
import gabsss.backend.repository.GatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GatosService {
    private final GatosRepository gatosRepository;

    @Autowired
    public GatosService(GatosRepository gatosRepository){
        this.gatosRepository = gatosRepository;
    }
    public Gatos createGatos(Gatos gatos){
        return gatosRepository.save(gatos);
    }
    public List<Gatos> getAllGatos(){
        return gatosRepository.findAll();
    }
    public Optional<Gatos> getGatosById(String id){
        return gatosRepository.findById(id);
    }
    public Gatos updateGatos(String id, Gatos updateGatos){
        if(gatosRepository.existsById(id)){
            updateGatos.setId(id);
            return gatosRepository.save(updateGatos);
        }
        return null;
    }
    public boolean deleteGatos(String id){
        if(gatosRepository.existsById(id)){
            gatosRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
