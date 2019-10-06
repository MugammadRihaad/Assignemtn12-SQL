package ac.za.cput.repository.BellvilleRepo;

import ac.za.cput.domain.Bellville.BellvilleDelivery;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface BellvilleDeliveryRepository extends IRepository<BellvilleDelivery, String> {
    Set<BellvilleDelivery> getAll();
}
