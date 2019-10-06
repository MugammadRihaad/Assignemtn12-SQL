package ac.za.cput.repository.BellvilleRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.domain.Bellville.bellvilleBaker;
import ac.za.cput.factory.Bellville.FactoryBellvilleAccountant;
import ac.za.cput.factory.Bellville.FactoryBellvilleBaker;
import ac.za.cput.repository.BellvilleRepo.BellvilleBakerRepository;
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
public class BellvilleBakerRepositoryImplTest {
    @Autowired
    private BellvilleBakerRepositoryImpl bakerRepository;


    @Test
    public void create() {
        bellvilleBaker baker = FactoryBellvilleBaker.getBellvilleBaker("Rihaad",5000);
        bakerRepository.create(baker);

        assertNotNull(bakerRepository.getAll());
    }

    @Test
    public void read() {


        bellvilleBaker baker = FactoryBellvilleBaker.getBellvilleBaker("Rihaad",5000);
        bakerRepository.create(baker);


        bellvilleBaker bakerInSet = bakerRepository.read(baker.getBellBakerId());

        assertEquals(baker, bakerInSet);
    }

    @Test
    public void delete() {


        bellvilleBaker baker = FactoryBellvilleBaker.getBellvilleBaker("Rihaad",5000);
        bakerRepository.create(baker);


        assertNotNull(bakerRepository.getAll());

        bakerRepository.delete(baker.getBellBakerId());


        bellvilleBaker updatedVersion = bakerRepository.read(baker.getBellBakerId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        bellvilleBaker baker = FactoryBellvilleBaker.getBellvilleBaker("Rihaad",5000);
        bakerRepository.create(baker);


        bellvilleBaker bakerUpdate = FactoryBellvilleBaker.getBellvilleBaker("Tauriq",6000);
        bakerUpdate.setBellBakerID(baker.getBellBakerId());
        bakerRepository.update(bakerUpdate);


        bellvilleBaker updatedVersion = bakerRepository.read(bakerUpdate.getBellBakerId());

        assertEquals(bakerUpdate, updatedVersion);

    }


}