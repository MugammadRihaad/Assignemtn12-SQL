package ac.za.cput.service.MPService.Impl;

import ac.za.cput.domain.MP.MPAccountant;
import ac.za.cput.factory.MP.FactoryMPAccountant;
import ac.za.cput.factory.MP.FactoryMPStaff;
import ac.za.cput.repository.MPRepo.MPAccountantRepository;
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
public class MPAccountantServiceImplTest {


    @Autowired
    private MPAccountantServiceImpl accountantService;



    @Test
    public void create() {
        MPAccountant accountant = FactoryMPAccountant.getMPAccountant();
        accountantService.create(accountant);

        assertNotNull(accountantService.getAll());
    }

    @Test
    public void read() {
        MPAccountant accountant = FactoryMPAccountant.getMPAccountant();
        accountantService.create(accountant);


        MPAccountant accountantInSet = accountantService.read(accountant.getMpAccountId());

        assertEquals(accountant, accountantInSet);
    }

    @Test
    public void delete() {

        MPAccountant accountant = FactoryMPAccountant.getMPAccountant();
        accountantService.create(accountant);


        assertNotNull(accountantService.getAll());

        accountantService.delete(accountant.getMpAccountId());


        MPAccountant updatedVersion = accountantService.read(accountant.getMpAccountId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        MPAccountant accountant = FactoryMPAccountant.getMPAccountant();
        accountantService.create(accountant);


        MPAccountant accountantUpdate = FactoryMPAccountant.getMPAccountant();
        accountantUpdate.setMpAccountId(accountant.getMpAccountId());
        accountantService.update(accountantUpdate);


        MPAccountant updatedVersion = accountantService.read(accountantUpdate.getMpAccountId());

        assertEquals(accountantUpdate, updatedVersion);
    }

}