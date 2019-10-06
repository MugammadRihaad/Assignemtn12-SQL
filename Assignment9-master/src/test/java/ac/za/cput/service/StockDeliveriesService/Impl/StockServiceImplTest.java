package ac.za.cput.service.StockDeliveriesService.Impl;

import ac.za.cput.domain.StockDeliveries.Stock;
import ac.za.cput.factory.StockDeliveries.FactoryStock;
import ac.za.cput.repository.StockDeliveriesRepo.StockRepository;
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
public class StockServiceImplTest {




    @Autowired
    private StockServiceImpl stockService;


    @Test
    public void create() {
        Stock stock = FactoryStock.getStock("food",200,5.3);
        stockService.create(stock);

        assertNotNull(stockService.getAll());
    }

    @Test
    public void read() {

        Stock stock = FactoryStock.getStock("food",200,5.3);
        stockService.create(stock);

        assertNotNull(stockService.getAll());

        Stock stockInSet =stockService.read(stock.getStockId());

        assertEquals(stock,stockInSet);
    }

    @Test
    public void delete() {

        Stock stock = FactoryStock.getStock("food",200,5.3);
        stockService.create(stock);

        assertNotNull(stockService.getAll());

        stockService.delete(stock.getStockId());


        Stock updatedVersion = stockService.read(stock.getStockId());


    }

    @Test
    public void update() {

        Stock stock = FactoryStock.getStock("food",200,5.3);
        stockService.create(stock);



        Stock stockUpdate = FactoryStock.getStock("utensils",300,0.4);
        stockUpdate.setStockId(stock.getStockId());
        stockService.update(stockUpdate);


        Stock updatedVersion = stockService.read(stock.getStockId());

        assertEquals(stockUpdate, updatedVersion);
    }

}