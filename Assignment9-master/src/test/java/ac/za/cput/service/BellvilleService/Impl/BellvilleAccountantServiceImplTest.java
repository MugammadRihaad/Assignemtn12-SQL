package ac.za.cput.service.BellvilleService.Impl;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.factory.Bellville.FactoryBellvilleAccountant;
import ac.za.cput.repository.BellvilleRepo.Impl.BellvilleAccountantRepoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.FixMethodOrder;

import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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

public class BellvilleAccountantServiceImplTest {

    @Autowired
    private BellvilleAccountantServiceImpl accountantSerivice;



    @Test
    public void create() {
        BellvilleAccountant accountant = FactoryBellvilleAccountant.getBellvilleAccountant();
        accountantSerivice.create(accountant);

        assertNotNull(accountantSerivice.getAll());
    }

    @Test
    public void read() {

        BellvilleAccountant accountant = FactoryBellvilleAccountant.getBellvilleAccountant();
        accountantSerivice.create(accountant);


        BellvilleAccountant accountantInSet = accountantSerivice.read(accountant.getBellAccountId());

        assertEquals(accountant, accountantInSet);

    }

    @Test
    public void delete() {

        BellvilleAccountant accountant = FactoryBellvilleAccountant.getBellvilleAccountant();
        accountantSerivice.create(accountant);


        assertNotNull(accountantSerivice.getAll());

        accountantSerivice.delete(accountant.getBellAccountId());


        BellvilleAccountant updatedVersion = accountantSerivice.read(accountant.getBellAccountId());

        assertNull(updatedVersion);

    }

    @Test
    public void update() {

        BellvilleAccountant accountant = FactoryBellvilleAccountant.getBellvilleAccountant();
        accountantSerivice.create(accountant);


        BellvilleAccountant accountantUpdate = FactoryBellvilleAccountant.getBellvilleAccountant();
        accountantUpdate.setBellAccountID(accountant.getBellAccountId());
        accountantSerivice.update(accountantUpdate);


        BellvilleAccountant updatedVersion = accountantSerivice.read(accountantUpdate.getBellAccountId());

        assertEquals(accountantUpdate, updatedVersion);

    }
}