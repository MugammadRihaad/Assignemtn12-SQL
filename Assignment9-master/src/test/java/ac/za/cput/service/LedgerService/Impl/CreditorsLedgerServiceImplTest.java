package ac.za.cput.service.LedgerService.Impl;

import ac.za.cput.domain.Ledger.CreditorsLedger;
import ac.za.cput.factory.Ledger.FactoryCreditorsLedger;
import ac.za.cput.repository.LedgerRepo.CreditorsLedgerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditorsLedgerServiceImplTest {


    @Autowired
    private CreditorsLedgerServiceImpl credLedgeService;


    @Test
    public void create() {
        CreditorsLedger creditor = FactoryCreditorsLedger.getCreditorsLedger("Makro",3000);
        credLedgeService.create(creditor);

        assertNotNull(credLedgeService.getAll());
    }

    @Test
    public void read() {
        CreditorsLedger creditor = FactoryCreditorsLedger.getCreditorsLedger("Makro",3000);
        credLedgeService.create(creditor);

        assertNotNull(credLedgeService.getAll());

        CreditorsLedger credInSet =credLedgeService.read(creditor.getCreditorsLId());

        assertEquals(creditor,credInSet);
    }

    @Test
    public void delete() {

        CreditorsLedger creditor = FactoryCreditorsLedger.getCreditorsLedger("Makro",3000);
        credLedgeService.create(creditor);


        assertNotNull(credLedgeService.getAll());

        credLedgeService.delete(creditor.getCreditorsLId());


        CreditorsLedger updatedVersion = credLedgeService.read(creditor.getCreditorsLId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        CreditorsLedger creditor = FactoryCreditorsLedger.getCreditorsLedger("Makro",3000);
        credLedgeService.create(creditor);


        CreditorsLedger credUpdate = FactoryCreditorsLedger.getCreditorsLedger("Sony",4000);
        credUpdate.setCreditorsLId(creditor.getCreditorsLId());
        credLedgeService.update(credUpdate);


        CreditorsLedger updatedVersion = credLedgeService.read(credUpdate.getCreditorsLId());

        assertEquals(credUpdate, updatedVersion);
    }

}