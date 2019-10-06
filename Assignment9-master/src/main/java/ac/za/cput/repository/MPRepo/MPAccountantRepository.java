package ac.za.cput.repository.MPRepo;

import ac.za.cput.domain.MP.MPAccountant;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface MPAccountantRepository extends IRepository<MPAccountant, String> {
    Set<MPAccountant> getAll();
}
