package ac.za.cput.service.StockDeliveriesService.Impl;

import ac.za.cput.domain.StockDeliveries.StockDeliveries;
import ac.za.cput.repository.StockDeliveriesRepo.Impl.StockDeliveriesRepositoryImpl;
import ac.za.cput.repository.StockDeliveriesRepo.StockDeliveriesRepository;
import ac.za.cput.service.StockDeliveriesService.StockDeliveriesService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("StockDeliveriesServiceImpl")
public class StockDeliveriesServiceImpl implements StockDeliveriesService {
    private  StockDeliveriesServiceImpl service = null;
    private StockDeliveriesRepository repository;

    private StockDeliveriesServiceImpl(){
        this.repository = StockDeliveriesRepositoryImpl.getRepository();
    }
    public StockDeliveriesServiceImpl getService(){
        if (service == null){
            service = new StockDeliveriesServiceImpl();
        }
        return service;
    }



    @Override
    public Set<StockDeliveries> getAll() {
        return this.repository.getAll();
    }

    @Override
    public StockDeliveries create(StockDeliveries stockDeliveries) {
        return this.repository.create(stockDeliveries);
    }

    @Override
    public StockDeliveries read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public StockDeliveries update(StockDeliveries stockDeliveries) {
        return this.repository.update(stockDeliveries);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
