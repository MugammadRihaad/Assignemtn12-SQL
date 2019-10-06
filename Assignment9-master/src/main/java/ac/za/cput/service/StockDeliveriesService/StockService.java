package ac.za.cput.service.StockDeliveriesService;

import ac.za.cput.domain.StockDeliveries.Stock;
import ac.za.cput.service.IService;

import java.util.Set;

public interface StockService extends IService<Stock, String> {
    Set<Stock> getAll();
}