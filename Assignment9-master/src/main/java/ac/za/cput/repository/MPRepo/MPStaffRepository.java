package ac.za.cput.repository.MPRepo;

import ac.za.cput.domain.MP.MPStaff;
import ac.za.cput.repository.IRepository;

import java.util.Set;


    public interface MPStaffRepository extends IRepository<MPStaff, String> {
        Set<MPStaff> getAll();
    }

