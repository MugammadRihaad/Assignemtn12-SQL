package ac.za.cput.service.BellvilleService;

import ac.za.cput.domain.Bellville.BellvilleBranch;
import ac.za.cput.service.IService;

import java.util.Set;

public interface BellvilleBranchService extends IService<BellvilleBranch, String> {
    Set<BellvilleBranch> getAll();
}