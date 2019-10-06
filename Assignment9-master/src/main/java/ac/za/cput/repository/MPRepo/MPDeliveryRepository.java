package ac.za.cput.repository.MPRepo;

import ac.za.cput.domain.MP.MPDelivery;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface MPDeliveryRepository extends IRepository<MPDelivery, String> {
    Set<MPDelivery> getAll();
}