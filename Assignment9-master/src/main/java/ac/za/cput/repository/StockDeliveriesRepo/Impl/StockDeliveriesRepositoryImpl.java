package ac.za.cput.repository.StockDeliveriesRepo.Impl;

import ac.za.cput.domain.StockDeliveries.Deliveries;
import ac.za.cput.domain.StockDeliveries.Stock;
import ac.za.cput.domain.StockDeliveries.StockDeliveries;
import ac.za.cput.repository.StockDeliveriesRepo.StockDeliveriesRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("StockDeliveryInMemory")
public class StockDeliveriesRepositoryImpl implements StockDeliveriesRepository {
    private static StockDeliveriesRepositoryImpl repository = null;
    private Set<StockDeliveries> stockDeliveries;

    private StockDeliveriesRepositoryImpl(){
        this.stockDeliveries = new HashSet<>();
    }

    public static StockDeliveriesRepositoryImpl getRepository(){
        if (repository == null) repository = new StockDeliveriesRepositoryImpl();
        return repository;
    }

    @Override
    public StockDeliveries create(StockDeliveries stockdel){
        this.stockDeliveries.add(stockdel);
        return stockdel;
    }
    @Override
    public StockDeliveries read(String stockdelId){
        return stockDeliveries.stream().filter(stockdel -> stockdel.getDelId().equals(stockdelId)).findAny().orElse(null);
    }
    @Override
    public void delete(String stockdelId) {
        StockDeliveries toDelete = read(stockdelId);
        stockDeliveries.remove(toDelete);
    }
    @Override
    public StockDeliveries update(StockDeliveries stockdel){
        StockDeliveries toDelete = read(stockdel.getDelId());
        if(toDelete != null) {
            stockDeliveries.remove(toDelete);
            stockDeliveries.add(stockdel);
            return stockdel;
        }
        return null;
    }

    @Override
    public Set<StockDeliveries> getAll(){
        return this.stockDeliveries;
    }
}
