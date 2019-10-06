package ac.za.cput.factory.Town;

import ac.za.cput.domain.Town.TownBranch;
import ac.za.cput.util.IDGenerator;

public class FactoryTownBranch {
    public static TownBranch getTownBranch(){
        return new TownBranch.Builder()
                .tnBrId(IDGenerator.generateId())
                .tnStaffId(IDGenerator.generateId())
                .build();

    }
}
