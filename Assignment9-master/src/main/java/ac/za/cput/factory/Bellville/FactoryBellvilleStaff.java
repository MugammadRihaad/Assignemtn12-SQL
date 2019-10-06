package ac.za.cput.factory.Bellville;

import ac.za.cput.domain.Bellville.BellvilleStaff;
import ac.za.cput.util.IDGenerator;

public class FactoryBellvilleStaff {
    public static BellvilleStaff getBellvilleStaff(){
        return new BellvilleStaff.Builder()
                    .bellStaffId(IDGenerator.generateId())
                    .bellAccountId(IDGenerator.generateId())
                    .bellDelivId(IDGenerator.generateId())
                    .bellBakerId(IDGenerator.generateId())
                    .build();

    }
}
