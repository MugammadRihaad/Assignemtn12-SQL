package ac.za.cput.service.BellvilleService.Impl;

import ac.za.cput.domain.Bellville.BellvilleDelivery;
import ac.za.cput.factory.Bellville.FactoryBellvilleDelivery;
import ac.za.cput.repository.BellvilleRepo.BellvilleDeliveryRepository;
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
public class BellvilleDeliveryServiceImplTest {

    @Autowired
    private BellvilleDeliveryServiceImpl deliveryService;


    @Test
    public void create() {
        BellvilleDelivery delivery = FactoryBellvilleDelivery.getBellvilleDelivery();
        deliveryService.create(delivery);

        assertNotNull(deliveryService.getAll());
    }

    @Test
    public void read() {

        BellvilleDelivery delivery = FactoryBellvilleDelivery.getBellvilleDelivery();
        deliveryService.create(delivery);

        assertNotNull(deliveryService.getAll());

        BellvilleDelivery deliveryInSet =deliveryService.read(delivery.getBellDeliveId());

        assertEquals(delivery,deliveryInSet);
    }

    @Test
    public void delete() {

        BellvilleDelivery delivery = FactoryBellvilleDelivery.getBellvilleDelivery();
        deliveryService.create(delivery);


        assertNotNull(deliveryService.getAll());

        deliveryService.delete(delivery.getBellDeliveId());


        BellvilleDelivery updatedVersion = deliveryService.read(delivery.getBellDeliveId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        BellvilleDelivery delivery = FactoryBellvilleDelivery.getBellvilleDelivery();
        deliveryService.create(delivery);


        BellvilleDelivery deliveryUpdate = FactoryBellvilleDelivery.getBellvilleDelivery();
        deliveryUpdate.setBellDeliveId(delivery.getBellDeliveId());
        deliveryService.update(deliveryUpdate);


        BellvilleDelivery updatedVersion = deliveryService.read(deliveryUpdate.getBellDeliveId());

        assertEquals(deliveryUpdate, updatedVersion);
    }
}