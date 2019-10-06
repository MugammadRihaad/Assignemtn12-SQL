package ac.za.cput.repository.BellvilleRepo.hibernate;

import ac.za.cput.domain.Bellville.bellvilleBaker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BellvilleBakerRepositoryHibernate extends CrudRepository<bellvilleBaker, String> {
}
