package ac.za.cput.repository.StockDeliveriesRepo.Impl;

import ac.za.cput.domain.StockDeliveries.Stock;
import ac.za.cput.repository.StockDeliveriesRepo.StockRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("StockInMemory")
public class StockRepositoryImpl implements StockRepository {
    private static StockRepositoryImpl repository = null;
    private Set<Stock> stocks;

    private StockRepositoryImpl(){
        this.stocks = new HashSet<>();
    }

    public static StockRepositoryImpl getRepository(){
        if (repository == null) repository = new StockRepositoryImpl();
        return repository;
    }

    @Override
    public Stock create(Stock stocks){
        this.stocks.add(stocks);
        return stocks;
    }
    @Override
    public Stock read(String stocksId){
        return stocks.stream().filter(stocks -> stocks.getStockId().equals(stocksId)).findAny().orElse(null);
    }
    @Override
    public void delete(String stocksId) {
        Stock toDelete = read(stocksId);
        stocks.remove(stocksId);
    }
    @Override
    public Stock update(Stock stocksId){
        Stock toDelete = read(stocksId.getStockId());
        if(toDelete != null) {
            stocks.remove(toDelete);
            stocks.add(stocksId);
            return stocksId;
        }
        return null;
    }

    @Override
    public Set<Stock> getAll(){
        return this.stocks;
    }
}
