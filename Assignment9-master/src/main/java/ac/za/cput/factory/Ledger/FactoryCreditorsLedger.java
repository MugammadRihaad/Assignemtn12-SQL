package ac.za.cput.factory.Ledger;

import ac.za.cput.domain.Ledger.CreditorsLedger;
import ac.za.cput.util.IDGenerator;

public class FactoryCreditorsLedger {
    public static CreditorsLedger getCreditorsLedger(
                                                     String supplierName,double suppAmountOwed){
        return new CreditorsLedger.Builder()
                    .creditorsLId(IDGenerator.generateId())
                    .supplierName(supplierName)
                    .suppAmountOwed(suppAmountOwed)
                    .build();

    }

}
