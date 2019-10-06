package ac.za.cput.repository.BellvilleRepo;

import ac.za.cput.domain.Bellville.BellvilleBranch;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface BellvilleBranchRepository extends IRepository<BellvilleBranch, String> {
    Set<BellvilleBranch> getAll();
}
