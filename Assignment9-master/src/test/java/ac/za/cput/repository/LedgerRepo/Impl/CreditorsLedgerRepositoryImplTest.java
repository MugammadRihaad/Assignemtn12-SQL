package ac.za.cput.repository.LedgerRepo.Impl;

import ac.za.cput.domain.Ledger.BusinessLedger;
import ac.za.cput.domain.Ledger.CreditorsLedger;
import ac.za.cput.factory.Ledger.FactoryBusinessLedger;
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
public class CreditorsLedgerRepositoryImplTest {

    @Autowired
    private CreditorsLedgerRepository credLedgeRepository;


    @Test
    public void create() {
        CreditorsLedger creditor = FactoryCreditorsLedger.getCreditorsLedger("Makro",3000);
        credLedgeRepository.create(creditor);

        assertNotNull(credLedgeRepository.getAll());
    }

    @Test
    public void read() {
        CreditorsLedger creditor = FactoryCreditorsLedger.getCreditorsLedger("Makro",3000);
        credLedgeRepository.create(creditor);

        assertNotNull(credLedgeRepository.getAll());

        CreditorsLedger credInSet =credLedgeRepository.read(creditor.getCreditorsLId());

        assertEquals(creditor,credInSet);
    }

    @Test
    public void delete() {

        CreditorsLedger creditor = FactoryCreditorsLedger.getCreditorsLedger("Makro",3000);
        credLedgeRepository.create(creditor);


        assertNotNull(credLedgeRepository.getAll());

        credLedgeRepository.delete(creditor.getCreditorsLId());


        CreditorsLedger updatedVersion = credLedgeRepository.read(creditor.getCreditorsLId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        CreditorsLedger creditor = FactoryCreditorsLedger.getCreditorsLedger("Makro",3000);
        credLedgeRepository.create(creditor);


        CreditorsLedger credUpdate = FactoryCreditorsLedger.getCreditorsLedger("Sony",4000);
        credUpdate.setCreditorsLId(creditor.getCreditorsLId());
        credLedgeRepository.update(credUpdate);


        CreditorsLedger updatedVersion = credLedgeRepository.read(credUpdate.getCreditorsLId());

        assertEquals(credUpdate, updatedVersion);
    }


}