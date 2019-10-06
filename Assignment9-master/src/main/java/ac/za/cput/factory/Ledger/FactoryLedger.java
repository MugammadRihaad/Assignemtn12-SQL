package ac.za.cput.factory.Ledger;

import ac.za.cput.domain.Ledger.Ledger;
import ac.za.cput.util.IDGenerator;

public class FactoryLedger {
    public static Ledger getLedger(){
        return new Ledger.Builder()
                    .ledgerId(IDGenerator.generateId())
                    .generalLId(IDGenerator.generateId())
                    .businessLId(IDGenerator.generateId())
                    .creditorsLId(IDGenerator.generateId())
                    .build();

    }
}
