package ac.za.cput.repository.MPRepo;

import ac.za.cput.domain.MP.MPBranch;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface MPBranchRepository extends IRepository<MPBranch, String> {
    Set<MPBranch> getAll();
}
