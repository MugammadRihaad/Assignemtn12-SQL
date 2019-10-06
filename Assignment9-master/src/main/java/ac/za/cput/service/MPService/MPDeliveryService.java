package ac.za.cput.service.MPService;

import ac.za.cput.domain.MP.MPDelivery;
import ac.za.cput.service.IService;

import java.util.Set;

public interface MPDeliveryService extends IService<MPDelivery, String> {
    Set<MPDelivery> getAll();
}