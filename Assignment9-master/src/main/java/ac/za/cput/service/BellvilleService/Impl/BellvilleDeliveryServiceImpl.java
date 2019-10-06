package ac.za.cput.service.BellvilleService.Impl;

import ac.za.cput.domain.Bellville.BellvilleDelivery;
import ac.za.cput.repository.BellvilleRepo.BellvilleDeliveryRepository;
import ac.za.cput.repository.BellvilleRepo.Impl.BellvilleDeliveryRepositoryImpl;
import ac.za.cput.service.BellvilleService.BellvilleDeliveryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("BellvilleDeliveryServiceImpl")
public class BellvilleDeliveryServiceImpl implements BellvilleDeliveryService {
    private  BellvilleDeliveryServiceImpl service = null;
    private BellvilleDeliveryRepository repository;

    private BellvilleDeliveryServiceImpl(){
        this.repository = BellvilleDeliveryRepositoryImpl.getRepository();
    }
    public BellvilleDeliveryServiceImpl getService(){
        if (service == null){
            service = new BellvilleDeliveryServiceImpl();
        }
        return service;
    }



    @Override
    public Set<BellvilleDelivery> getAll() {
        return this.repository.getAll();
    }

    @Override
    public BellvilleDelivery create(BellvilleDelivery delivery) {
        return this.repository.create(delivery);
    }

    @Override
    public BellvilleDelivery read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public BellvilleDelivery update(BellvilleDelivery delivery) {
        return this.repository.update(delivery);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
