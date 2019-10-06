package ac.za.cput.repository.TownRepo;

import ac.za.cput.domain.Town.TownBranch;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface TownBranchRepository extends IRepository<TownBranch, String> {
    Set<TownBranch> getAll();
}
