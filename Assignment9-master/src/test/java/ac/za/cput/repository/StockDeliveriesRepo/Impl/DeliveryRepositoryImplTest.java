package ac.za.cput.repository.StockDeliveriesRepo.Impl;

import ac.za.cput.domain.Ledger.Ledger;
import ac.za.cput.domain.StockDeliveries.Deliveries;
import ac.za.cput.factory.Ledger.FactoryLedger;
import ac.za.cput.factory.StockDeliveries.FactoryDeliveries;
import ac.za.cput.repository.StockDeliveriesRepo.DeliveryRepository;
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
public class DeliveryRepositoryImplTest {

    @Autowired
    private DeliveryRepository deliveryRepository;


    @Test
    public void create() {
        Deliveries delivery = FactoryDeliveries.getDeliveries("Game",200,3000);
        deliveryRepository.create(delivery);

        assertNotNull(deliveryRepository.getAll());
    }

    @Test
    public void read() {

        Deliveries delivery = FactoryDeliveries.getDeliveries("Game",200,3000);
        deliveryRepository.create(delivery);

        assertNotNull(deliveryRepository.getAll());

        Deliveries deliveryInSet =deliveryRepository.read(delivery.getDelivId());

        assertEquals(delivery,deliveryInSet);
    }

    @Test
    public void delete() {

        Deliveries delivery = FactoryDeliveries.getDeliveries("Game",200,3000);
        deliveryRepository.create(delivery);



        assertNotNull(deliveryRepository.getAll());

        deliveryRepository.delete(delivery.getDelivId());


        Deliveries updatedVersion = deliveryRepository.read(delivery.getDelivId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {
        Deliveries delivery = FactoryDeliveries.getDeliveries("Game",200,3000);
        deliveryRepository.create(delivery);


        Deliveries deliveryUpdate = FactoryDeliveries.getDeliveries("Osmans",300,50);
        deliveryUpdate.setDelivId(delivery.getDelivId());
        deliveryRepository.update(deliveryUpdate);


        Deliveries updatedVersion = deliveryRepository.read(deliveryUpdate.getDelivId());

        assertEquals(deliveryUpdate, updatedVersion);
    }


}