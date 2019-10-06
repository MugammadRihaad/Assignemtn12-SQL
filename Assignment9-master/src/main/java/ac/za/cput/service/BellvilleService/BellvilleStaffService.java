package ac.za.cput.service.BellvilleService;

import ac.za.cput.domain.Bellville.BellvilleStaff;
import ac.za.cput.service.IService;

import java.util.Set;

public interface BellvilleStaffService extends IService<BellvilleStaff, String> {
    Set<BellvilleStaff> getAll();
}