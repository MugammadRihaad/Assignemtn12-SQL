package ac.za.cput.service.LedgerService.Impl;

import ac.za.cput.domain.Ledger.Ledger;
import ac.za.cput.factory.Ledger.FactoryLedger;
import ac.za.cput.repository.LedgerRepo.LedgerRepository;
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
public class LedgerServiceImplTest {


    @Autowired
    private LedgerServiceImpl ledgerService;


    @Test
    public void create() {
        Ledger ledger = FactoryLedger.getLedger();
        ledgerService.create(ledger);

        assertNotNull(ledgerService.getAll());
    }

    @Test
    public void read() {

        Ledger ledger = FactoryLedger.getLedger();
        ledgerService.create(ledger);

        assertNotNull(ledgerService.getAll());

        Ledger ledgerInSet =ledgerService.read(ledger.getLedgerId());

        assertEquals(ledger,ledgerInSet);
    }

    @Test
    public void delete() {

        Ledger ledger = FactoryLedger.getLedger();
        ledgerService.create(ledger);


        assertNotNull(ledgerService.getAll());

        ledgerService.delete(ledger.getLedgerId());


        Ledger updatedVersion = ledgerService.read(ledger.getLedgerId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        Ledger ledger =FactoryLedger.getLedger();
        ledgerService.create(ledger);


        Ledger ledgerUpdate = FactoryLedger.getLedger();
        ledgerUpdate.setGeneralLId(ledger.getLedgerId());
        ledgerService.update(ledgerUpdate);


        Ledger updatedVersion = ledgerService.read(ledgerUpdate.getGeneralLId());


    }


}