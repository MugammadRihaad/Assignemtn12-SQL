package ac.za.cput.factory.StockDeliveries;

import ac.za.cput.domain.StockDeliveries.Deliveries;
import ac.za.cput.util.IDGenerator;

public class FactoryDeliveries {
    public static Deliveries getDeliveries(String delivName,int delivAmount, double delivPriceUnit){
        return new Deliveries.Builder()
                .delivId(IDGenerator.generateId())
                .delivName(delivName)
                .delivAmount(delivAmount)
                .delivPriceUnit(delivPriceUnit)
                .build();

    }
}
