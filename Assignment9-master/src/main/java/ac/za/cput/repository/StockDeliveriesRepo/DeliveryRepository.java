package ac.za.cput.repository.StockDeliveriesRepo;

import ac.za.cput.domain.StockDeliveries.Deliveries;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface DeliveryRepository extends IRepository<Deliveries, String> {
    Set<Deliveries> getAll();
}