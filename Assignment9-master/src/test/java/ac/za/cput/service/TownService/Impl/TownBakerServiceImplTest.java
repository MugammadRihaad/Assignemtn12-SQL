package ac.za.cput.service.TownService.Impl;

import ac.za.cput.domain.Town.TownBaker;
import ac.za.cput.factory.Town.FactoryTownBaker;
import ac.za.cput.repository.TownRepo.TownBakerRepository;
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
public class TownBakerServiceImplTest {


    @Autowired
    private TownBakerServiceImpl bakerService;


    @Test
    public void create() {
        TownBaker baker = FactoryTownBaker.getTownBaker("Rihaad",5000);
        bakerService.create(baker);

        assertNotNull(bakerService.getAll());
    }

    @Test
    public void read() {


        TownBaker baker = FactoryTownBaker.getTownBaker("Rihaad",5000);
        bakerService.create(baker);

        TownBaker bakerInSet = bakerService.read(baker.getTnBakerId());

        assertEquals(baker, bakerInSet);
    }

    @Test
    public void delete() {

        TownBaker baker = FactoryTownBaker.getTownBaker("Rihaad",5000);
        bakerService.create(baker);


        assertNotNull(bakerService.getAll());

        bakerService.delete(baker.getTnBakerId());


        TownBaker updatedVersion = bakerService.read(baker.getTnBakerId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        TownBaker baker = FactoryTownBaker.getTownBaker("Rihaad",5000);
        bakerService.create(baker);


        TownBaker bakerUpdate = FactoryTownBaker.getTownBaker("Tauriq",4000);
        bakerUpdate.setTnBakerId(baker.getTnBakerId());
        bakerService.update(bakerUpdate);


        TownBaker updatedVersion = bakerService.read(bakerUpdate.getTnBakerId());

        assertEquals(bakerUpdate, updatedVersion);
    }
}