package ac.za.cput.service.TownService;

import ac.za.cput.domain.Town.TownAccountant;
import ac.za.cput.service.IService;

import java.util.Set;

public interface TownAccountantService extends IService<TownAccountant, String> {
    Set<TownAccountant> getAll();
}