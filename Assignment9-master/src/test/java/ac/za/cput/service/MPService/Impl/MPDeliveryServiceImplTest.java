package ac.za.cput.service.MPService.Impl;

import ac.za.cput.domain.MP.MPDelivery;
import ac.za.cput.factory.MP.FactoryMPDelivery;
import ac.za.cput.repository.MPRepo.MPDeliveryRepository;
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
public class MPDeliveryServiceImplTest {


    @Autowired
    private MPDeliveryServiceImpl deliveryService;


    @Test
    public void create() {
        MPDelivery delivery = FactoryMPDelivery.getMPDelivery();
        deliveryService.create(delivery);

        assertNotNull(deliveryService.getAll());
    }

    @Test
    public void read() {
        MPDelivery delivery = FactoryMPDelivery.getMPDelivery();
        deliveryService.create(delivery);

        assertNotNull(deliveryService.getAll());

        MPDelivery deliveryInSet =deliveryService.read(delivery.getMpDeliveId());

        assertEquals(delivery,deliveryInSet);
    }

    @Test
    public void delete() {

        MPDelivery delivery = FactoryMPDelivery.getMPDelivery();
        deliveryService.create(delivery);


        assertNotNull(deliveryService.getAll());

        deliveryService.delete(delivery.getMpDeliveId());


        MPDelivery updatedVersion = deliveryService.read(delivery.getMpDeliveId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        MPDelivery delivery = FactoryMPDelivery.getMPDelivery();
        deliveryService.create(delivery);


        MPDelivery deliveryUpdate = FactoryMPDelivery.getMPDelivery();
        deliveryUpdate.setMpDeliveId(delivery.getMpDeliveId());
        deliveryService.update(deliveryUpdate);


        MPDelivery updatedVersion = deliveryService.read(deliveryUpdate.getMpDeliveId());

        assertEquals(deliveryUpdate, updatedVersion);
    }
}