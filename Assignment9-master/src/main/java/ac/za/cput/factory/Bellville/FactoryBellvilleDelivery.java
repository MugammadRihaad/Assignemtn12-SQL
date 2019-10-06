package ac.za.cput.factory.Bellville;

import ac.za.cput.domain.Bellville.BellvilleDelivery;
import ac.za.cput.util.IDGenerator;

public class FactoryBellvilleDelivery {
    public static BellvilleDelivery getBellvilleDelivery(){
     return new BellvilleDelivery.Builder()
                .bellDeliveId(IDGenerator.generateId())
                .bellStockId(IDGenerator.generateId())
                .build();
    }
}
