package ac.za.cput.repository.TownRepo;

import ac.za.cput.domain.Town.TownDelivery;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface TownDeliveryRepository extends IRepository<TownDelivery, String> {
    Set<TownDelivery> getAll();
}
