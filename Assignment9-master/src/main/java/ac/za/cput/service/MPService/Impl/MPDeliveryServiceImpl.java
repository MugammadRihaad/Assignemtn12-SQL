package ac.za.cput.service.MPService.Impl;


import ac.za.cput.domain.MP.MPDelivery;
import ac.za.cput.repository.MPRepo.Impl.MPDeliveryRepositoryImpl;
import ac.za.cput.repository.MPRepo.MPDeliveryRepository;
import ac.za.cput.service.MPService.MPDeliveryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("MPDeliveryServiceImpl")
public class MPDeliveryServiceImpl implements MPDeliveryService {
    private  MPDeliveryServiceImpl service = null;
    private MPDeliveryRepository repository;

    private MPDeliveryServiceImpl(){
        this.repository = MPDeliveryRepositoryImpl.getRepository();
    }
    public MPDeliveryServiceImpl getService(){
        if (service == null){
            service = new MPDeliveryServiceImpl();
        }
        return service;
    }



    @Override
    public Set<MPDelivery> getAll() {
        return this.repository.getAll();
    }

    @Override
    public MPDelivery create(MPDelivery delivery) {
        return this.repository.create(delivery);
    }

    @Override
    public MPDelivery read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public MPDelivery update(MPDelivery delivery) {
        return this.repository.update(delivery);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
