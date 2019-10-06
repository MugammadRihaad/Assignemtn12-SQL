package ac.za.cput.factory.MP;

import ac.za.cput.domain.MP.MPDelivery;
import ac.za.cput.util.IDGenerator;

public class FactoryMPDelivery {
    public static MPDelivery getMPDelivery(){
        return new MPDelivery.Builder()
                .mpDeliveId(IDGenerator.generateId())
                .mpStockId(IDGenerator.generateId())
                .build();
    }
}
