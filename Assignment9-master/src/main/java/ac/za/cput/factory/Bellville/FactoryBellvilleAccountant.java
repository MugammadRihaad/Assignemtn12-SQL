package ac.za.cput.factory.Bellville;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.util.IDGenerator;

public class FactoryBellvilleAccountant {
    public static BellvilleAccountant getBellvilleAccountant(){
        return new BellvilleAccountant.Builder()
                .bellAccountId(IDGenerator.generateId())
                .bellLedgerId(IDGenerator.generateId())
                .bellBusinessLId(IDGenerator.generateId())
                .bellGeneralLId(IDGenerator.generateId())
                .bellCreditorsLId(IDGenerator.generateId())
                .build();



    }
}
