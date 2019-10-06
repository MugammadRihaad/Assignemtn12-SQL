package ac.za.cput.factory.Town;

import ac.za.cput.domain.Town.TownStaff;
import ac.za.cput.util.IDGenerator;

public class FactoryTownStaff {
    public static TownStaff getTownStaff(){
        return new TownStaff.Builder()
                .tnStaffId(IDGenerator.generateId())
                .tnAccountId(IDGenerator.generateId())
                .tnDelivId(IDGenerator.generateId())
                .tnBakerId(IDGenerator.generateId())
                .build();

    }
}
