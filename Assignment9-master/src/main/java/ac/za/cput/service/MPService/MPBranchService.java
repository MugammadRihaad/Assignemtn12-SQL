package ac.za.cput.service.MPService;

import ac.za.cput.domain.MP.MPBranch;
import ac.za.cput.service.IService;

import java.util.Set;

public interface MPBranchService extends IService<MPBranch, String> {
    Set<MPBranch> getAll();
}