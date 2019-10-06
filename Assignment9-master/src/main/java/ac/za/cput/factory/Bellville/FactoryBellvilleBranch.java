package ac.za.cput.factory.Bellville;

import ac.za.cput.domain.Bellville.BellvilleBranch;
import ac.za.cput.util.IDGenerator;

public class FactoryBellvilleBranch {
    public static BellvilleBranch getBellvillBranch(){
       return new BellvilleBranch.Builder()
                 .bellBrId(IDGenerator.generateId())
                 .bellStaffId(IDGenerator.generateId())
                  .build();

    }
}
