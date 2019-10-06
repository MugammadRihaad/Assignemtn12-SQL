package ac.za.cput.repository.StockDeliveriesRepo;

import ac.za.cput.domain.StockDeliveries.StockDeliveries;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface StockDeliveriesRepository extends IRepository<StockDeliveries, String> {
    Set<StockDeliveries> getAll();
}
