package ac.za.cput.service.TownService.Impl;

import ac.za.cput.domain.Town.ProductBiscuits;
import ac.za.cput.factory.Town.FactoryProductBiscuits;
import ac.za.cput.repository.TownRepo.ProductBiscuitsRepository;
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
public class ProductBiscuitsServiceImplTest {


    @Autowired
    private ProductBiscuitsServiceImpl biscuitsService;



    @Test
    public void create() {
        ProductBiscuits biscuits = FactoryProductBiscuits.getProductBiscuits("raisin",10);
        biscuitsService.create(biscuits);

        assertNotNull(biscuitsService.getAll());
    }

    @Test
    public void read() {

        ProductBiscuits biscuits = FactoryProductBiscuits.getProductBiscuits("raisin",10);
        biscuitsService.create(biscuits);

        assertNotNull(biscuitsService.getAll());

        ProductBiscuits biscuitsInSet =biscuitsService.read(biscuits.getProductBiscuitsId());

        assertEquals(biscuits,biscuitsInSet);
    }

    @Test
    public void delete() {


        ProductBiscuits biscuits = FactoryProductBiscuits.getProductBiscuits("raisin",10);
        biscuitsService.create(biscuits);


        assertNotNull(biscuitsService.getAll());

        biscuitsService.delete(biscuits.getProductBiscuitsId());


        ProductBiscuits updatedVersion = biscuitsService.read(biscuits.getProductBiscuitsId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {
        ProductBiscuits biscuits = FactoryProductBiscuits.getProductBiscuits("raisin",10);
        biscuitsService.create(biscuits);


        ProductBiscuits biscuitsUpdate = FactoryProductBiscuits.getProductBiscuits("ChocChip",20);
        biscuitsUpdate.setProductBiscuitsId(biscuits.getProductBiscuitsId());
        biscuitsService.update(biscuitsUpdate);


        ProductBiscuits updatedVersion = biscuitsService.read(biscuitsUpdate.getProductBiscuitsId());

        assertEquals(biscuitsUpdate, updatedVersion);
    }
}