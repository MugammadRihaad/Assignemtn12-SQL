package ac.za.cput.repository.TownRepo;

import ac.za.cput.domain.MP.MPStaff;
import ac.za.cput.domain.Town.TownStaff;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface TownStaffRepository extends IRepository<TownStaff, String> {
    Set<TownStaff> getAll();
}