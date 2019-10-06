package ac.za.cput.factory.HeadOffice;

import ac.za.cput.domain.HeadOffice;
import ac.za.cput.util.IDGenerator;

public class FactoryHeadOffice {

    public static HeadOffice getHeadOffice(){
        return new HeadOffice.Builder()
                    .officeId(IDGenerator.generateId())
                    .bellvilleBrId(IDGenerator.generateId())
                    .townBrId(IDGenerator.generateId())
                    .mpBrId(IDGenerator.generateId())
                    .build();

    }
}
