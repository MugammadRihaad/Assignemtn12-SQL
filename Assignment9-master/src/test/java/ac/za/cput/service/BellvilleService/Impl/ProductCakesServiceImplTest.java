package ac.za.cput.service.BellvilleService.Impl;

import ac.za.cput.domain.Bellville.ProductCakes;
import ac.za.cput.factory.Bellville.FactoryProductCakes;
import ac.za.cput.repository.BellvilleRepo.ProductCakesRepository;
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
public class ProductCakesServiceImplTest {



    @Autowired
    private ProductCakesServiceImpl cakeServices;


    @Test
    public void create() {
        ProductCakes cakes = FactoryProductCakes.getProductCakes("Chocolate",10);
        cakeServices.create(cakes);

        assertNotNull(cakeServices.getAll());
    }

    @Test
    public void read() {

        ProductCakes cakes = FactoryProductCakes.getProductCakes("Chocolate",10);
        cakeServices.create(cakes);

        assertNotNull(cakeServices.getAll());

        ProductCakes cakesInSet =cakeServices.read(cakes.getProductCakeId());

        assertEquals(cakes,cakesInSet);
    }

    @Test
    public void delete() {

        ProductCakes cakes = FactoryProductCakes.getProductCakes("Chocolate",10);
        cakeServices.create(cakes);


        assertNotNull(cakeServices.getAll());

        cakeServices.delete(cakes.getProductCakeId());


        ProductCakes updatedVersion = cakeServices.read(cakes.getProductCakeId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        ProductCakes cakes = FactoryProductCakes.getProductCakes("Chocolate",10);
        cakeServices.create(cakes);


        ProductCakes cakesUpdate = FactoryProductCakes.getProductCakes("Icing",20);
        cakesUpdate.setProductCakeId(cakes.getProductCakeId());
        cakeServices.update(cakesUpdate);


        ProductCakes updatedVersion = cakeServices.read(cakesUpdate.getProductCakeId());

        assertEquals(cakesUpdate, updatedVersion);
    }

}