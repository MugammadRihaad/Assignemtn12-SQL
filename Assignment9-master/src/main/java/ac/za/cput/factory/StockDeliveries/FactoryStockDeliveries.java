package ac.za.cput.factory.StockDeliveries;

import ac.za.cput.domain.StockDeliveries.StockDeliveries;
import ac.za.cput.util.IDGenerator;

public class FactoryStockDeliveries {
    public static StockDeliveries getStockDeliveries(String stockdelId,String stockId){
        return new StockDeliveries.Builder()
                    .delId(IDGenerator.generateId())
                    .stockdelId(stockdelId)
                    .stockId(stockId)
                    .build();
    }
}
