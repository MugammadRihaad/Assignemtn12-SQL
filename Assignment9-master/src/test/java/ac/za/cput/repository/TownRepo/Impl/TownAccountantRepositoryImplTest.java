package ac.za.cput.repository.TownRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.domain.MP.MPAccountant;
import ac.za.cput.domain.Town.TownAccountant;
import ac.za.cput.factory.Bellville.FactoryBellvilleAccountant;
import ac.za.cput.factory.MP.FactoryMPAccountant;
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
public class TownAccountantRepositoryImplTest {

    @Autowired
    private TownAccountantRepository accountantRepository;


    @Test
    public void create() {
        TownAccountant accountant = FactoryTownAccountant.getTownAccountant();
        accountantRepository.create(accountant);

        assertNotNull(accountantRepository.getAll());
    }

    @Test
    public void read() {
        TownAccountant accountant = FactoryTownAccountant.getTownAccountant();
        accountantRepository.create(accountant);


        TownAccountant accountantInSet = accountantRepository.read(accountant.getTnAccountId());

        assertEquals(accountant, accountantInSet);
    }

    @Test
    public void delete() {

        TownAccountant accountant = FactoryTownAccountant.getTownAccountant();
        accountantRepository.create(accountant);


        assertNotNull(accountantRepository.getAll());

        accountantRepository.delete(accountant.getTnAccountId());


        TownAccountant updatedVersion = accountantRepository.read(accountant.getTnAccountId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {
        TownAccountant accountant = FactoryTownAccountant.getTownAccountant();
        accountantRepository.create(accountant);


        TownAccountant accountantUpdate = FactoryTownAccountant.getTownAccountant();
        accountantUpdate.setTnAccountId(accountant.getTnAccountId());
        accountantRepository.update(accountantUpdate);


        TownAccountant updatedVersion = accountantRepository.read(accountantUpdate.getTnAccountId());

        assertEquals(accountantUpdate, updatedVersion);
    }


}