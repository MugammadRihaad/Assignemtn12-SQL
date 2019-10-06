package ac.za.cput.service.BellvilleService;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.service.IService;

import java.util.Set;

public interface  BellvilleAccountantService extends IService<BellvilleAccountant, String> {
    Set<BellvilleAccountant> getAll();
}
