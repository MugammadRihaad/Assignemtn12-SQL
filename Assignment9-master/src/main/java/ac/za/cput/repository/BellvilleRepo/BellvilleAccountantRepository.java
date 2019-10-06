package ac.za.cput.repository.BellvilleRepo;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface  BellvilleAccountantRepository extends IRepository<BellvilleAccountant, String> {
    Set<BellvilleAccountant> getAll();
}
