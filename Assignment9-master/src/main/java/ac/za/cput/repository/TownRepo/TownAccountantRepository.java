package ac.za.cput.repository.TownRepo;

import ac.za.cput.domain.Town.TownAccountant;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface TownAccountantRepository extends IRepository<TownAccountant, String> {
    Set<TownAccountant> getAll();
}
