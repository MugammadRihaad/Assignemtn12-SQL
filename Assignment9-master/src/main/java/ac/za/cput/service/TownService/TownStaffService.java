package ac.za.cput.service.TownService;

import ac.za.cput.domain.Town.TownStaff;
import ac.za.cput.service.IService;

import java.util.Set;

public interface TownStaffService extends IService<TownStaff, String> {
    Set<TownStaff> getAll();
}