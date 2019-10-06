package ac.za.cput.repository.BellvilleRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleStaff;
import ac.za.cput.domain.Bellville.ProductCakes;
import ac.za.cput.factory.Bellville.FactoryBellvilleStaff;
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
public class ProductCakesRepositoryImplTest {

    @Autowired
    private ProductCakesRepository cakeRepository;


    @Test
    public void create() {
        ProductCakes cakes = FactoryProductCakes.getProductCakes("Chocolate",10);
        cakeRepository.create(cakes);

        assertNotNull(cakeRepository.getAll());
    }

    @Test
    public void read() {

        ProductCakes cakes = FactoryProductCakes.getProductCakes("Chocolate",10);
        cakeRepository.create(cakes);

        assertNotNull(cakeRepository.getAll());

        ProductCakes cakesInSet =cakeRepository.read(cakes.getProductCakeId());

        assertEquals(cakes,cakesInSet);
    }

    @Test
    public void delete() {

        ProductCakes cakes = FactoryProductCakes.getProductCakes("Chocolate",10);
        cakeRepository.create(cakes);


        assertNotNull(cakeRepository.getAll());

        cakeRepository.delete(cakes.getProductCakeId());


        ProductCakes updatedVersion = cakeRepository.read(cakes.getProductCakeId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        ProductCakes cakes = FactoryProductCakes.getProductCakes("Chocolate",10);
        cakeRepository.create(cakes);


        ProductCakes cakesUpdate = FactoryProductCakes.getProductCakes("Icing",20);
        cakesUpdate.setProductCakeId(cakes.getProductCakeId());
        cakeRepository.update(cakesUpdate);


        ProductCakes updatedVersion = cakeRepository.read(cakesUpdate.getProductCakeId());

        assertEquals(cakesUpdate, updatedVersion);
    }


}