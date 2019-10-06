package ac.za.cput.factory.MP;

import ac.za.cput.domain.MP.MPStaff;
import ac.za.cput.util.IDGenerator;

public class FactoryMPStaff {
    public static MPStaff getMPStaff( ){
        return new MPStaff.Builder()
                .mpStaffId(IDGenerator.generateId())
                .mpAccountId(IDGenerator.generateId())
                .mpDelivId(IDGenerator.generateId())
                .mpBakerId(IDGenerator.generateId())
                .build();

    }
}
