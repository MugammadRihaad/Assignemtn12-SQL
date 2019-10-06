package ac.za.cput.factory.MP;

import ac.za.cput.domain.MP.MPBaker;
import ac.za.cput.util.IDGenerator;

public class FactoryMPBaker {
    public static MPBaker getMPBaker(String mpBakerName,
                                            double mpBakerSalary){
        return new MPBaker.Builder()
                .mpBakerId(IDGenerator.generateId())
                .mpBakerName(mpBakerName)
                .mpBakerSalary(mpBakerSalary)
                .build();





    }
}
