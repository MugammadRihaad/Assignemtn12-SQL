package ac.za.cput.factory.Ledger;

import ac.za.cput.domain.Ledger.Ledger;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryLedgerTest {

    @Test
    public void getLedger() {


        Ledger l=FactoryLedger.getLedger();

        Assert.assertNotNull(l);
    }
}