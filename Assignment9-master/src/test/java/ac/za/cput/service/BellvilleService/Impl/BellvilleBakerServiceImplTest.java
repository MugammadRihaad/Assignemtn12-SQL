package ac.za.cput.service.BellvilleService.Impl;

import ac.za.cput.domain.Bellville.bellvilleBaker;
import ac.za.cput.factory.Bellville.FactoryBellvilleBaker;
import ac.za.cput.repository.BellvilleRepo.Impl.BellvilleBakerRepositoryImpl;
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
public class BellvilleBakerServiceImplTest {

    @Autowired
    private BellvilleBakerServiceImpl bakerService;


    @Test
    public void create() {
        bellvilleBaker baker = FactoryBellvilleBaker.getBellvilleBaker("Rihaad",5000);
        bakerService.create(baker);

        assertNotNull(bakerService.getAll());
    }

    @Test
    public void read() {


        bellvilleBaker baker = FactoryBellvilleBaker.getBellvilleBaker("Rihaad",5000);
        bakerService.create(baker);


        bellvilleBaker bakerInSet = bakerService.read(baker.getBellBakerId());

        assertEquals(baker, bakerInSet);
    }

    @Test
    public void delete() {


        bellvilleBaker baker = FactoryBellvilleBaker.getBellvilleBaker("Rihaad",5000);
        bakerService.create(baker);


        assertNotNull(bakerService.getAll());

        bakerService.delete(baker.getBellBakerId());


        bellvilleBaker updatedVersion = bakerService.read(baker.getBellBakerId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        bellvilleBaker baker = FactoryBellvilleBaker.getBellvilleBaker("Rihaad",5000);
        bakerService.create(baker);


        bellvilleBaker bakerUpdate = FactoryBellvilleBaker.getBellvilleBaker("Tauriq",6000);
        bakerUpdate.setBellBakerID(baker.getBellBakerId());
        bakerService.update(bakerUpdate);


        bellvilleBaker updatedVersion = bakerService.read(bakerUpdate.getBellBakerId());

        assertEquals(bakerUpdate, updatedVersion);

    }}