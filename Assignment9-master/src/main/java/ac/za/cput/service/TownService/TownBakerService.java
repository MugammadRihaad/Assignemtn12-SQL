package ac.za.cput.service.TownService;

import ac.za.cput.domain.Town.TownBaker;
import ac.za.cput.service.IService;

import java.util.Set;

public interface TownBakerService extends IService<TownBaker, String> {
    Set<TownBaker> getAll();
}
