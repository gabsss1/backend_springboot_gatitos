package gabsss.backend.repository;

import gabsss.backend.model.Gatos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatosRepository extends MongoRepository<Gatos, String> {
}
