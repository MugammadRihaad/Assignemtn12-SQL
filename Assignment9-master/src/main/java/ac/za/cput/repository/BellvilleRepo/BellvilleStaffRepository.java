package ac.za.cput.repository.BellvilleRepo;

import ac.za.cput.domain.Bellville.BellvilleStaff;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface BellvilleStaffRepository extends IRepository<BellvilleStaff, String> {
    Set<BellvilleStaff> getAll();
}
