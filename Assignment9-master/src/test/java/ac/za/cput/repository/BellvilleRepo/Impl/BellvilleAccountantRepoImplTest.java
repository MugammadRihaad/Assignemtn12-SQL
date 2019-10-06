package ac.za.cput.repository.BellvilleRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.factory.Bellville.FactoryBellvilleAccountant;
import ac.za.cput.repository.BellvilleRepo.BellvilleAccountantRepository;
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
public class BellvilleAccountantRepoImplTest {

    @Autowired
    private BellvilleAccountantRepoImpl accountantRepository;



    @Test
    public void create() {
        BellvilleAccountant accountant = FactoryBellvilleAccountant.getBellvilleAccountant();
        accountantRepository.create(accountant);

        assertNotNull(accountantRepository.getAll());
    }

    @Test
    public void read() {

        BellvilleAccountant accountant = FactoryBellvilleAccountant.getBellvilleAccountant();
        accountantRepository.create(accountant);


        BellvilleAccountant accountantInSet = accountantRepository.read(accountant.getBellAccountId());

        assertEquals(accountant, accountantInSet);

    }

    @Test
    public void delete() {

        BellvilleAccountant accountant = FactoryBellvilleAccountant.getBellvilleAccountant();
        accountantRepository.create(accountant);


        assertNotNull(accountantRepository.getAll());

        accountantRepository.delete(accountant.getBellAccountId());


        BellvilleAccountant updatedVersion = accountantRepository.read(accountant.getBellAccountId());

        assertNull(updatedVersion);

    }

    @Test
    public void update() {

        BellvilleAccountant accountant = FactoryBellvilleAccountant.getBellvilleAccountant();
        accountantRepository.create(accountant);


        BellvilleAccountant accountantUpdate = FactoryBellvilleAccountant.getBellvilleAccountant();
        accountantUpdate.setBellAccountID(accountant.getBellAccountId());
        accountantRepository.update(accountantUpdate);


        BellvilleAccountant updatedVersion = accountantRepository.read(accountantUpdate.getBellAccountId());

        assertEquals(accountantUpdate, updatedVersion);

    }


}