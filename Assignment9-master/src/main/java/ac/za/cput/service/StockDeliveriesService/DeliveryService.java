package ac.za.cput.service.StockDeliveriesService;

import ac.za.cput.domain.StockDeliveries.Deliveries;
import ac.za.cput.service.IService;

import java.util.Set;

public interface DeliveryService extends IService<Deliveries, String> {
    Set<Deliveries> getAll();
}