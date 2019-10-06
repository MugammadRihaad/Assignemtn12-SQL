package ac.za.cput.service.TownService;

import ac.za.cput.domain.Town.TownDelivery;
import ac.za.cput.service.IService;

import java.util.Set;

public interface TownDeliveryService extends IService<TownDelivery, String> {
    Set<TownDelivery> getAll();
}
