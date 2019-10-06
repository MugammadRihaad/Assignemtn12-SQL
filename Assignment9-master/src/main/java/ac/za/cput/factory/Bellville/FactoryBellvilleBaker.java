package ac.za.cput.factory.Bellville;

import ac.za.cput.domain.Bellville.bellvilleBaker;
import ac.za.cput.util.IDGenerator;

public class FactoryBellvilleBaker {
    public static bellvilleBaker getBellvilleBaker( String bellBakerName,
                                                   double bellBakerSalary){
        return new bellvilleBaker.Builder()
                .bellBakerId(IDGenerator.generateId())
                .bellBakerName(bellBakerName)
                .bellBakerSalary(bellBakerSalary)
                .build();





    }
}
