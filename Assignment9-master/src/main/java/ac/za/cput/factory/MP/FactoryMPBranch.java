package ac.za.cput.factory.MP;

import ac.za.cput.domain.MP.MPBranch;
import ac.za.cput.util.IDGenerator;

public class FactoryMPBranch {
    public static MPBranch getMPBranch(){
        return new MPBranch.Builder()
        .mpBrId(IDGenerator.generateId())
        .mpStaffId(IDGenerator.generateId())
        .build();

        }
        }
