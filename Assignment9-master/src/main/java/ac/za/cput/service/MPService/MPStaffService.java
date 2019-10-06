package ac.za.cput.service.MPService;

import ac.za.cput.domain.MP.MPStaff;
import ac.za.cput.service.IService;

import java.util.Set;

public interface MPStaffService extends IService<MPStaff, String> {
    Set<MPStaff> getAll();
}


