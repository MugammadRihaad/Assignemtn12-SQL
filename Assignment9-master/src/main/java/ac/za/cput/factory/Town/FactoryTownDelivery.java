package ac.za.cput.factory.Town;

import ac.za.cput.domain.Town.TownDelivery;
import ac.za.cput.util.IDGenerator;

public class FactoryTownDelivery {
    public static TownDelivery getTownDelivery(){
        return new TownDelivery.Builder()
                .tnDeliveId(IDGenerator.generateId())
                .tnStockId(IDGenerator.generateId())
                .build();
    }
}
