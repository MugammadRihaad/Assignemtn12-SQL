package ac.za.cput.repository.TownRepo;

import ac.za.cput.domain.Town.TownBaker;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface TownBakerRepository extends IRepository<TownBaker, String> {
    Set<TownBaker> getAll();
}
