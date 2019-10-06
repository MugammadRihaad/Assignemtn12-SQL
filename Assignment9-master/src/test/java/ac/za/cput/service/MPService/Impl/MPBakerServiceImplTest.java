package ac.za.cput.service.MPService.Impl;

import ac.za.cput.domain.MP.MPBaker;
import ac.za.cput.factory.MP.FactoryMPBaker;
import ac.za.cput.repository.MPRepo.MPBakerRepository;
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
public class MPBakerServiceImplTest {


    @Autowired
    private MPBakerServiceImpl bakerService;



    @Test
    public void create() {
        MPBaker baker = FactoryMPBaker.getMPBaker("Rihaad",5000);
        bakerService.create(baker);

        assertNotNull(bakerService.getAll());
    }

    @Test
    public void read() {


        MPBaker baker = FactoryMPBaker.getMPBaker("Rihaad",5000);
        bakerService.create(baker);


        MPBaker bakerInSet = bakerService.read(baker.getMpBakerId());

        assertEquals(baker, bakerInSet);
    }

    @Test
    public void delete() {
        MPBaker baker = FactoryMPBaker.getMPBaker("Rihaad",5000);
        bakerService.create(baker);


        assertNotNull(bakerService.getAll());

        bakerService.delete(baker.getMpBakerId());


        MPBaker updatedVersion = bakerService.read(baker.getMpBakerId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        MPBaker baker = FactoryMPBaker.getMPBaker("Rihaad",5000);
        bakerService.create(baker);


        MPBaker bakerUpdate = FactoryMPBaker.getMPBaker("Tauriq",4000);
        bakerUpdate.setMpBakerId(baker.getMpBakerId());
        bakerService.update(bakerUpdate);


        MPBaker updatedVersion = bakerService.read(bakerUpdate.getMpBakerId());

        assertEquals(bakerUpdate, updatedVersion);
    }

}