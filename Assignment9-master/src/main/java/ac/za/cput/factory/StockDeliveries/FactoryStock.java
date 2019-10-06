package ac.za.cput.factory.StockDeliveries;


import ac.za.cput.domain.StockDeliveries.Stock;
import ac.za.cput.util.IDGenerator;

public class FactoryStock {
    public static Stock getStock(String stockCategory,int stockAm,double stockWeight){
        return new Stock.Builder()
                .stockCate(stockCategory)
                .stockAmount(stockAm)
                .stockWeight(stockWeight)
                .stockId(IDGenerator.generateId())
                .build();

    }
}
