package ac.za.cput.service.MPService;

import ac.za.cput.domain.MP.MPAccountant;
import ac.za.cput.service.IService;

import java.util.Set;

public interface MPAccountantService extends IService<MPAccountant, String> {
    Set<MPAccountant> getAll();
}