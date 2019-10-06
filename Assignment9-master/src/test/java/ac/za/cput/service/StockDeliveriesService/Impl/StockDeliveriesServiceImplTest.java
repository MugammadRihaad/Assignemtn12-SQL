package ac.za.cput.service.StockDeliveriesService.Impl;

import ac.za.cput.domain.StockDeliveries.StockDeliveries;
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
public class StockDeliveriesServiceImplTest {




    @Autowired
    private StockDeliveriesServiceImpl stockDeliveryService;


    @Test
    public void create() {
        StockDeliveries stockDelivery = FactoryStockDeliveries.getStockDeliveries("consoles","23c");
        stockDeliveryService.create(stockDelivery);

        assertNotNull(stockDeliveryService.getAll());
    }

    @Test
    public void read() {
        StockDeliveries stockDelivery = FactoryStockDeliveries.getStockDeliveries("consoles","23c");
        stockDeliveryService.create(stockDelivery);

        assertNotNull(stockDeliveryService.getAll());

        StockDeliveries stockDeliveryInSet =stockDeliveryService.read(stockDelivery.getDelId());


    }

    @Test
    public void delete() {

        StockDeliveries stockDelivery = FactoryStockDeliveries.getStockDeliveries("consoles","23c");
        stockDeliveryService.create(stockDelivery);


        assertNotNull(stockDeliveryService.getAll());

        stockDeliveryService.delete(stockDelivery.getDelId());


        StockDeliveries updatedVersion = stockDeliveryService.read(stockDelivery.getDelId());

        assertNull(updatedVersion);
    }

    @Test
    public void update() {

        StockDeliveries stockDelivery = FactoryStockDeliveries.getStockDeliveries("consoles","23c");
        stockDeliveryService.create(stockDelivery);



        StockDeliveries stockDeliveryUpdate = FactoryStockDeliveries.getStockDeliveries("Fridges","21f");
        stockDeliveryUpdate.setStockdelId(stockDelivery.getDelId());
        stockDeliveryService.update(stockDeliveryUpdate);


        StockDeliveries updatedVersion = stockDeliveryService.read(stockDelivery.getDelId());


    }
}