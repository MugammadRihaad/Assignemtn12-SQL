package ac.za.cput.service.MPService;

import ac.za.cput.domain.MP.MPBaker;
import ac.za.cput.service.IService;

import java.util.Set;

public interface MPBakerService extends IService<MPBaker, String> {
    Set<MPBaker> getAll();
}