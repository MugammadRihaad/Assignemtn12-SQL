package ac.za.cput.repository.MPRepo;

import ac.za.cput.domain.MP.MPBaker;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface MPBakerRepository extends IRepository<MPBaker, String> {
    Set<MPBaker> getAll();
}