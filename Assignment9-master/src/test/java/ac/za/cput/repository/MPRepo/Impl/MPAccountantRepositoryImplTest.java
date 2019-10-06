package ac.za.cput.repository.MPRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.domain.MP.MPAccountant;
import ac.za.cput.factory.Bellville.FactoryBellvilleAccountant;
import ac.za.cput.factory.MP.FactoryMPAccountant;
import ac.za.cput.factory.Town.FactoryTownAccountant;
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
public class MPAccountantRepositoryImplTest {

    @Autowired
    private MPAccountantRepository accountantRepository;



    @Test
    public void create() {
        MPAccountant accountant = FactoryMPAccountant.getMPAccountant();
        accountantRepository.create(accountant);

        assertNotNull(accountantRepository.getAll());
    }

    @Test
    public void read() {
        MPAccountant accountant = FactoryMPAccountant.getMPAccountant();
        accountantRepository.create(accountant);


        MPAccountant accountantInSet = accountantRepository.read(accountant.getMpAccountId());

        assertEquals(accountant, accountantInSet);
    }

    @Test
    public void delete() {

        MPAccountant accountant = FactoryMPAccountant.getMPAccountant();
        accountantRepository.create(accountant);


        assertNotNull(accountantRepository.getAll());

        accountantRepository.delete(accountant.getMpAccountId());


        MPAccountant updatedVersion = accountantRepository.read(accountant.getMpAccountId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        MPAccountant accountant = FactoryMPAccountant.getMPAccountant();
        accountantRepository.create(accountant);


        MPAccountant accountantUpdate = FactoryMPAccountant.getMPAccountant();
        accountantUpdate.setMpAccountId(accountant.getMpAccountId());
        accountantRepository.update(accountantUpdate);


        MPAccountant updatedVersion = accountantRepository.read(accountantUpdate.getMpAccountId());

        assertEquals(accountantUpdate, updatedVersion);
    }

}