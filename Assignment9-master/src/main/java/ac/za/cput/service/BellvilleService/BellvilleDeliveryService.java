package ac.za.cput.service.BellvilleService;

import ac.za.cput.domain.Bellville.BellvilleDelivery;
import ac.za.cput.service.IService;

import java.util.Set;

public interface BellvilleDeliveryService extends IService<BellvilleDelivery, String> {
    Set<BellvilleDelivery> getAll();
}
