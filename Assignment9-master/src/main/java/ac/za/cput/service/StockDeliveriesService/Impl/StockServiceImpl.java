package ac.za.cput.service.StockDeliveriesService.Impl;

import ac.za.cput.domain.Bellville.ProductCakes;
import ac.za.cput.domain.StockDeliveries.Stock;
import ac.za.cput.repository.StockDeliveriesRepo.Impl.StockRepositoryImpl;
import ac.za.cput.repository.StockDeliveriesRepo.StockRepository;
import ac.za.cput.service.StockDeliveriesService.StockService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("StockServiceImpl")
public class StockServiceImpl implements StockService {
    private  StockServiceImpl service = null;
    private StockRepository repository;

    private StockServiceImpl(){
        this.repository = StockRepositoryImpl.getRepository();
    }
    public StockServiceImpl getService(){
        if (service == null){
            service = new StockServiceImpl();
        }
        return service;
    }



    @Override
    public Set<Stock> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Stock create(Stock stock) {
        return this.repository.create(stock);
    }

    @Override
    public Stock read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public Stock update(Stock stock) {
        return this.repository.update(stock);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
