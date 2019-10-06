package ac.za.cput.factory.Ledger;

import ac.za.cput.domain.Ledger.BusinessLedger;
import ac.za.cput.util.IDGenerator;

public class FactoryBusinessLedger {
    public static BusinessLedger getBusinessLedger( String custName,double custAmountOwed){
        return new BusinessLedger.Builder()
                    .businessLId(IDGenerator.generateId())
                    .custName(custName)
                    .custAmountOwed(custAmountOwed)
                    .build();

    }
}
