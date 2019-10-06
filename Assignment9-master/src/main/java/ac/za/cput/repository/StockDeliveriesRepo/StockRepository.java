package ac.za.cput.repository.StockDeliveriesRepo;

import ac.za.cput.domain.StockDeliveries.Stock;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface StockRepository extends IRepository<Stock, String> {
    Set<Stock> getAll();
}