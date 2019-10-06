package ac.za.cput.service.TownService.Impl;


import ac.za.cput.domain.Town.TownDelivery;
import ac.za.cput.repository.TownRepo.Impl.TownDeliveryRepositoryImpl;
import ac.za.cput.repository.TownRepo.TownDeliveryRepository;
import ac.za.cput.service.TownService.TownDeliveryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("TownDeliveryServiceImpl")
public class TownDeliveryServiceImpl implements TownDeliveryService {
    private  TownDeliveryServiceImpl service = null;
    private TownDeliveryRepository repository;

    private TownDeliveryServiceImpl(){
        this.repository = TownDeliveryRepositoryImpl.getRepository();
    }
    public TownDeliveryServiceImpl getService(){
        if (service == null){
            service = new TownDeliveryServiceImpl();
        }
        return service;
    }



    @Override
    public Set<TownDelivery> getAll() {
        return this.repository.getAll();
    }

    @Override
    public TownDelivery create(TownDelivery delivery) {
        return this.repository.create(delivery);
    }

    @Override
    public TownDelivery read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public TownDelivery update(TownDelivery delivery) {
        return this.repository.update(delivery);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
