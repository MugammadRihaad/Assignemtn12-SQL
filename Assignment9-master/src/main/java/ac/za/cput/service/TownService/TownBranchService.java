package ac.za.cput.service.TownService;

import ac.za.cput.domain.Town.TownBranch;
import ac.za.cput.service.IService;

import java.util.Set;

public interface TownBranchService extends IService<TownBranch, String> {
    Set<TownBranch> getAll();
}
