package ac.za.cput.repository.MPRepo.Impl;

import ac.za.cput.domain.Bellville.bellvilleBaker;
import ac.za.cput.domain.MP.MPBaker;
import ac.za.cput.factory.Bellville.FactoryBellvilleBaker;
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
public class MPBakerRepositoryImplTest {

    @Autowired
    private MPBakerRepository bakerRepository;



    @Test
    public void create() {
        MPBaker baker = FactoryMPBaker.getMPBaker("Rihaad",5000);
        bakerRepository.create(baker);

        assertNotNull(bakerRepository.getAll());
    }

    @Test
    public void read() {


        MPBaker baker = FactoryMPBaker.getMPBaker("Rihaad",5000);
        bakerRepository.create(baker);


        MPBaker bakerInSet = bakerRepository.read(baker.getMpBakerId());

        assertEquals(baker, bakerInSet);
    }

    @Test
    public void delete() {
        MPBaker baker = FactoryMPBaker.getMPBaker("Rihaad",5000);
        bakerRepository.create(baker);


        assertNotNull(bakerRepository.getAll());

        bakerRepository.delete(baker.getMpBakerId());


        MPBaker updatedVersion = bakerRepository.read(baker.getMpBakerId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        MPBaker baker = FactoryMPBaker.getMPBaker("Rihaad",5000);
        bakerRepository.create(baker);


        MPBaker bakerUpdate = FactoryMPBaker.getMPBaker("Tauriq",4000);
        bakerUpdate.setMpBakerId(baker.getMpBakerId());
        bakerRepository.update(bakerUpdate);


        MPBaker updatedVersion = bakerRepository.read(bakerUpdate.getMpBakerId());

        assertEquals(bakerUpdate, updatedVersion);
    }


}