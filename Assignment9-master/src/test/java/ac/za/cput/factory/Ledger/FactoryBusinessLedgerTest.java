package ac.za.cput.factory.Ledger;

import ac.za.cput.domain.Ledger.BusinessLedger;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryBusinessLedgerTest {

    @Test
    public void getBusinessLedger() {

        String custName="StarBucks";
        double custAmountOwed=3000.00;

        BusinessLedger bl=FactoryBusinessLedger.getBusinessLedger(custName,custAmountOwed);

        Assert.assertNotNull(bl);
    }
}