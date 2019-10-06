package ac.za.cput.service.StockDeliveriesService.Impl;

import ac.za.cput.domain.StockDeliveries.Deliveries;
import ac.za.cput.repository.StockDeliveriesRepo.DeliveryRepository;
import ac.za.cput.repository.StockDeliveriesRepo.Impl.DeliveryRepositoryImpl;
import ac.za.cput.service.StockDeliveriesService.DeliveryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("DeliveryServiceImpl")
public class DeliveryServiceImpl implements DeliveryService {
    private  DeliveryServiceImpl service = null;
    private DeliveryRepository repository;

    private DeliveryServiceImpl(){
        this.repository = DeliveryRepositoryImpl.getRepository();
    }
    public DeliveryServiceImpl getService(){
        if (service == null){
            service = new DeliveryServiceImpl();
        }
        return service;
    }



    @Override
    public Set<Deliveries> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Deliveries create(Deliveries deliveries) {
        return this.repository.create(deliveries);
    }

    @Override
    public Deliveries read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public Deliveries update(Deliveries deliveries) {
        return this.repository.update(deliveries);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
