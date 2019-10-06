package ac.za.cput.repository.BellvilleRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleBranch;
import ac.za.cput.domain.Bellville.BellvilleDelivery;
import ac.za.cput.factory.Bellville.FactoryBellvilleBranch;
import ac.za.cput.factory.Bellville.FactoryBellvilleDelivery;
import ac.za.cput.factory.StockDeliveries.FactoryDeliveries;
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
public class BellvilleDeliveryRepositoryImplTest {
    @Autowired
    private BellvilleDeliveryRepository deliveryRepository;


    @Test
    public void create() {
        BellvilleDelivery delivery = FactoryBellvilleDelivery.getBellvilleDelivery();
        deliveryRepository.create(delivery);

        assertNotNull(deliveryRepository.getAll());
    }

    @Test
    public void read() {

        BellvilleDelivery delivery = FactoryBellvilleDelivery.getBellvilleDelivery();
        deliveryRepository.create(delivery);

        assertNotNull(deliveryRepository.getAll());

        BellvilleDelivery deliveryInSet =deliveryRepository.read(delivery.getBellDeliveId());

        assertEquals(delivery,deliveryInSet);
    }

    @Test
    public void delete() {

        BellvilleDelivery delivery = FactoryBellvilleDelivery.getBellvilleDelivery();
        deliveryRepository.create(delivery);


        assertNotNull(deliveryRepository.getAll());

        deliveryRepository.delete(delivery.getBellDeliveId());


        BellvilleDelivery updatedVersion = deliveryRepository.read(delivery.getBellDeliveId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        BellvilleDelivery delivery = FactoryBellvilleDelivery.getBellvilleDelivery();
        deliveryRepository.create(delivery);


        BellvilleDelivery deliveryUpdate = FactoryBellvilleDelivery.getBellvilleDelivery();
        deliveryUpdate.setBellDeliveId(delivery.getBellDeliveId());
        deliveryRepository.update(deliveryUpdate);


        BellvilleDelivery updatedVersion = deliveryRepository.read(deliveryUpdate.getBellDeliveId());

        assertEquals(deliveryUpdate, updatedVersion);
    }


}