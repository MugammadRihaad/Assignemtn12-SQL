package ac.za.cput.factory.MP;

import ac.za.cput.domain.MP.MPAccountant;
import ac.za.cput.util.IDGenerator;

public class FactoryMPAccountant {
    public static MPAccountant getMPAccountant(){
        return new MPAccountant.Builder()
                .mpAccountId(IDGenerator.generateId())
                .mpBusinessLId(IDGenerator.generateId())
                .mpGeneralLId(IDGenerator.generateId())
                .mpCreditorsLId(IDGenerator.generateId())
                .build();



    }
}
