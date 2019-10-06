package ac.za.cput.repository.StockDeliveriesRepo.Impl;

import ac.za.cput.domain.StockDeliveries.Stock;
import ac.za.cput.domain.StockDeliveries.StockDeliveries;
import ac.za.cput.factory.StockDeliveries.FactoryStock;
import ac.za.cput.factory.StockDeliveries.FactoryStockDeliveries;
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
public class StockRepositoryImplTest {

    @Autowired
    private StockRepository stockRepository;


    @Test
    public void create() {
        Stock stock = FactoryStock.getStock("food",200,5.3);
        stockRepository.create(stock);

        assertNotNull(stockRepository.getAll());
    }

    @Test
    public void read() {

        Stock stock = FactoryStock.getStock("food",200,5.3);
        stockRepository.create(stock);

        assertNotNull(stockRepository.getAll());

        Stock stockInSet =stockRepository.read(stock.getStockId());

        assertEquals(stock,stockInSet);
    }

    @Test
    public void delete() {

        Stock stock = FactoryStock.getStock("food",200,5.3);
        stockRepository.create(stock);

        assertNotNull(stockRepository.getAll());

        stockRepository.delete(stock.getStockId());


        Stock updatedVersion = stockRepository.read(stock.getStockId());

        assertNotNull(updatedVersion);
    }

    @Test
    public void update() {

        Stock stock = FactoryStock.getStock("food",200,5.3);
        stockRepository.create(stock);



        Stock stockUpdate = FactoryStock.getStock("utensils",300,0.4);
        stockUpdate.setStockId(stock.getStockId());
        stockRepository.update(stockUpdate);


        Stock updatedVersion = stockRepository.read(stock.getStockId());

        assertEquals(stockUpdate, updatedVersion);
    }


}