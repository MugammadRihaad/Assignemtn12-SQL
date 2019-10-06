package ac.za.cput.repository.StockDeliveriesRepo.Impl;

import ac.za.cput.domain.StockDeliveries.Deliveries;
import ac.za.cput.domain.StockDeliveries.StockDeliveries;
import ac.za.cput.factory.StockDeliveries.FactoryDeliveries;
import ac.za.cput.factory.StockDeliveries.FactoryStockDeliveries;
import ac.za.cput.repository.StockDeliveriesRepo.StockDeliveriesRepository;
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
public class StockDeliveriesRepositoryImplTest {

    @Autowired
    private StockDeliveriesRepository stockDeliveryRepository;


    @Test
    public void create() {
        StockDeliveries stockDelivery = FactoryStockDeliveries.getStockDeliveries("consoles","23c");
        stockDeliveryRepository.create(stockDelivery);

        assertNotNull(stockDeliveryRepository.getAll());
    }

    @Test
    public void read() {
        StockDeliveries stockDelivery = FactoryStockDeliveries.getStockDeliveries("consoles","23c");
        stockDeliveryRepository.create(stockDelivery);

        assertNotNull(stockDeliveryRepository.getAll());

        StockDeliveries stockDeliveryInSet =stockDeliveryRepository.read(stockDelivery.getDelId());

        assertNull(stockDeliveryInSet);
    }

    @Test
    public void delete() {

        StockDeliveries stockDelivery = FactoryStockDeliveries.getStockDeliveries("consoles","23c");
        stockDeliveryRepository.create(stockDelivery);


        assertNotNull(stockDeliveryRepository.getAll());

        stockDeliveryRepository.delete(stockDelivery.getDelId());


        StockDeliveries updatedVersion = stockDeliveryRepository.read(stockDelivery.getDelId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        StockDeliveries stockDelivery = FactoryStockDeliveries.getStockDeliveries("consoles","23c");
        stockDeliveryRepository.create(stockDelivery);



        StockDeliveries stockDeliveryUpdate = FactoryStockDeliveries.getStockDeliveries("Fridges","21f");
        stockDeliveryUpdate.setStockdelId(stockDelivery.getDelId());
        stockDeliveryRepository.update(stockDeliveryUpdate);


        StockDeliveries updatedVersion = stockDeliveryRepository.read(stockDelivery.getDelId());

        assertNull(updatedVersion);
    }


}