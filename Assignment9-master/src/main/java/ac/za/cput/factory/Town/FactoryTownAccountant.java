package ac.za.cput.factory.Town;

import ac.za.cput.domain.Town.TownAccountant;
import ac.za.cput.util.IDGenerator;

public class FactoryTownAccountant {
    public static TownAccountant getTownAccountant(){
        return new TownAccountant.Builder()
                .tnAccountId(IDGenerator.generateId())
                .tnBusinessLId(IDGenerator.generateId())
                .tnGeneralLId(IDGenerator.generateId())
                .tnCreditorsLId(IDGenerator.generateId())
                .build();



    }
}
