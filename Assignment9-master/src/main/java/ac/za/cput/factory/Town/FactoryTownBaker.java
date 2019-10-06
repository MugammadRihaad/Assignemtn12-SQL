package ac.za.cput.factory.Town;

import ac.za.cput.domain.Town.TownBaker;
import ac.za.cput.util.IDGenerator;

public class FactoryTownBaker {
    public static TownBaker getTownBaker(String tnBakerName,
                                       double tnBakerSalary){
        return new TownBaker.Builder()
                .tnBakerId(IDGenerator.generateId())
                .tnBakerName(tnBakerName)
                .tnBakerSalary(tnBakerSalary)
                .build();





    }
}
