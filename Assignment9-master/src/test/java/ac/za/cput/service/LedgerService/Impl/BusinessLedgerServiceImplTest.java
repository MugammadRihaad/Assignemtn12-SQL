package ac.za.cput.service.LedgerService.Impl;

import ac.za.cput.domain.Ledger.BusinessLedger;
import ac.za.cput.factory.Ledger.FactoryBusinessLedger;
import ac.za.cput.repository.LedgerRepo.BusinessLedgerRepository;
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
public class BusinessLedgerServiceImplTest {


    @Autowired
    private BusinessLedgerServiceImpl ledgerService;


    @Test
    public void create() {
        BusinessLedger ledger = FactoryBusinessLedger.getBusinessLedger("Makro",3000);
        ledgerService.create(ledger);

        assertNotNull(ledgerService.getAll());
    }

    @Test
    public void read() {
        BusinessLedger ledger = FactoryBusinessLedger.getBusinessLedger("Makro",3000);
        ledgerService.create(ledger);

        assertNotNull(ledgerService.getAll());

        BusinessLedger officeInSet =ledgerService.read(ledger.getBusniessLId());

        assertEquals(ledger,officeInSet);
    }

    @Test
    public void delete() {

        BusinessLedger ledger = FactoryBusinessLedger.getBusinessLedger("Makro",3000);
        ledgerService.create(ledger);


        assertNotNull(ledgerService.getAll());

        ledgerService.delete(ledger.getBusniessLId());


        BusinessLedger updatedVersion = ledgerService.read(ledger.getBusniessLId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        BusinessLedger ledger = FactoryBusinessLedger.getBusinessLedger("Makro",3000);
        ledgerService.create(ledger);


        BusinessLedger ledgerUpdate = FactoryBusinessLedger.getBusinessLedger("Sony",4000);
        ledgerUpdate.setBusinessLId(ledger.getBusniessLId());
        ledgerService.update(ledgerUpdate);


        BusinessLedger updatedVersion = ledgerService.read(ledgerUpdate.getBusniessLId());

        assertEquals(ledgerUpdate, updatedVersion);
    }

}