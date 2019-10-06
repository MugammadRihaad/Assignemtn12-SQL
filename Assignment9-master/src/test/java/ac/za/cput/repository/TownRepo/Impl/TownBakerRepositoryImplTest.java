package ac.za.cput.repository.TownRepo.Impl;

import ac.za.cput.domain.Bellville.bellvilleBaker;
import ac.za.cput.domain.Town.TownBaker;
import ac.za.cput.factory.Bellville.FactoryBellvilleBaker;
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
public class TownBakerRepositoryImplTest {

    @Autowired
    private TownBakerRepository bakerRepository;


    @Test
    public void create() {
        TownBaker baker = FactoryTownBaker.getTownBaker("Rihaad",5000);
        bakerRepository.create(baker);

        assertNotNull(bakerRepository.getAll());
    }

    @Test
    public void read() {


        TownBaker baker = FactoryTownBaker.getTownBaker("Rihaad",5000);
        bakerRepository.create(baker);

        TownBaker bakerInSet = bakerRepository.read(baker.getTnBakerId());

        assertEquals(baker, bakerInSet);
    }

    @Test
    public void delete() {

        TownBaker baker = FactoryTownBaker.getTownBaker("Rihaad",5000);
        bakerRepository.create(baker);


        assertNotNull(bakerRepository.getAll());

        bakerRepository.delete(baker.getTnBakerId());


        TownBaker updatedVersion = bakerRepository.read(baker.getTnBakerId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        TownBaker baker = FactoryTownBaker.getTownBaker("Rihaad",5000);
        bakerRepository.create(baker);


        TownBaker bakerUpdate = FactoryTownBaker.getTownBaker("Tauriq",4000);
        bakerUpdate.setTnBakerId(baker.getTnBakerId());
        bakerRepository.update(bakerUpdate);


        TownBaker updatedVersion = bakerRepository.read(bakerUpdate.getTnBakerId());

        assertEquals(bakerUpdate, updatedVersion);
    }


}