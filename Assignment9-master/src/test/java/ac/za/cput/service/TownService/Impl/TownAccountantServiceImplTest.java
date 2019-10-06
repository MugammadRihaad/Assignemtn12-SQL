package ac.za.cput.service.TownService.Impl;

import ac.za.cput.domain.Town.TownAccountant;
import ac.za.cput.factory.Town.FactoryTownAccountant;
import ac.za.cput.repository.TownRepo.TownAccountantRepository;
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
public class TownAccountantServiceImplTest {


    @Autowired
    private TownAccountantServiceImpl accountantService;


    @Test
    public void create() {
        TownAccountant accountant = FactoryTownAccountant.getTownAccountant();
        accountantService.create(accountant);

        assertNotNull(accountantService.getAll());
    }

    @Test
    public void read() {
        TownAccountant accountant = FactoryTownAccountant.getTownAccountant();
        accountantService.create(accountant);


        TownAccountant accountantInSet = accountantService.read(accountant.getTnAccountId());

        assertEquals(accountant, accountantInSet);
    }

    @Test
    public void delete() {

        TownAccountant accountant = FactoryTownAccountant.getTownAccountant();
        accountantService.create(accountant);


        assertNotNull(accountantService.getAll());

        accountantService.delete(accountant.getTnAccountId());


        TownAccountant updatedVersion = accountantService.read(accountant.getTnAccountId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {
        TownAccountant accountant = FactoryTownAccountant.getTownAccountant();
        accountantService.create(accountant);


        TownAccountant accountantUpdate = FactoryTownAccountant.getTownAccountant();
        accountantUpdate.setTnAccountId(accountant.getTnAccountId());
        accountantService.update(accountantUpdate);


        TownAccountant updatedVersion = accountantService.read(accountantUpdate.getTnAccountId());

        assertEquals(accountantUpdate, updatedVersion);
    }
}