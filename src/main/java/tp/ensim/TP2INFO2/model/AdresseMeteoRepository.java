package tp.ensim.TP2INFO2.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseMeteoRepository extends CrudRepository<AdresseMeteo, Long> {
    List<AdresseMeteo> findByAddressContaining(String query);
}
