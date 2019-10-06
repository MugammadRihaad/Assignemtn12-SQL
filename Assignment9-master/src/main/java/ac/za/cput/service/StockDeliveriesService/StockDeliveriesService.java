package ac.za.cput.service.StockDeliveriesService;

import ac.za.cput.domain.StockDeliveries.StockDeliveries;
import ac.za.cput.service.IService;

import java.util.Set;

public interface StockDeliveriesService extends IService<StockDeliveries, String> {
    Set<StockDeliveries> getAll();
}