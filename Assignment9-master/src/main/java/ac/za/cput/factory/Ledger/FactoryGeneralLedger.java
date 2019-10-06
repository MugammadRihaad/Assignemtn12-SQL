package ac.za.cput.factory.Ledger;

import ac.za.cput.domain.Ledger.GeneralLedger;
import ac.za.cput.util.IDGenerator;

public class FactoryGeneralLedger {
    public static GeneralLedger getGeneralLedger(String date,
            int totalTransaction,
            double totalAmount){

        return new GeneralLedger.Builder()
                    .date(date)
                    .generalLId(IDGenerator.generateId())
                    .totalTrans(totalTransaction)
                    .totalAmount(totalAmount)
                    .build();

    }
}
