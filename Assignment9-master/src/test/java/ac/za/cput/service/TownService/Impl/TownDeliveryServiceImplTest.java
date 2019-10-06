package ac.za.cput.service.TownService.Impl;

import ac.za.cput.domain.Town.TownDelivery;
import ac.za.cput.factory.Town.FactoryTownDelivery;
import ac.za.cput.repository.TownRepo.TownDeliveryRepository;
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
public class TownDeliveryServiceImplTest {


    @Autowired
    private TownDeliveryServiceImpl deliveryService;


    @Test
    public void create() {
        TownDelivery delivery = FactoryTownDelivery.getTownDelivery();
        deliveryService.create(delivery);

        assertNotNull(deliveryService.getAll());
    }

    @Test
    public void read() {
        TownDelivery delivery = FactoryTownDelivery.getTownDelivery();
        deliveryService.create(delivery);

        assertNotNull(deliveryService.getAll());

        TownDelivery deliveryInSet =deliveryService.read(delivery.getTnDeliveId());

        assertEquals(delivery,deliveryInSet);
    }

    @Test
    public void delete() {

        TownDelivery delivery = FactoryTownDelivery.getTownDelivery();
        deliveryService.create(delivery);


        assertNotNull(deliveryService.getAll());

        deliveryService.delete(delivery.getTnDeliveId());


        TownDelivery updatedVersion = deliveryService.read(delivery.getTnDeliveId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        TownDelivery delivery = FactoryTownDelivery.getTownDelivery();
        deliveryService.create(delivery);


        TownDelivery deliveryUpdate = FactoryTownDelivery.getTownDelivery();
        deliveryUpdate.setTnDeliveId(delivery.getTnDeliveId());
        deliveryService.update(deliveryUpdate);


        TownDelivery updatedVersion = deliveryService.read(deliveryUpdate.getTnDeliveId());

        assertEquals(deliveryUpdate, updatedVersion);
    }

}