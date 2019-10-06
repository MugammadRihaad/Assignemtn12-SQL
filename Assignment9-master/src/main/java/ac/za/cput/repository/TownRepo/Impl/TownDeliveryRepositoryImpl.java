package ac.za.cput.repository.TownRepo.Impl;

import ac.za.cput.domain.Town.TownDelivery;
import ac.za.cput.repository.TownRepo.TownBakerRepository;
import ac.za.cput.repository.TownRepo.TownDeliveryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("TownDeliveryInMemory")
public class TownDeliveryRepositoryImpl implements TownDeliveryRepository {
    private static TownDeliveryRepositoryImpl repository = null;
    private Set<TownDelivery> tnDelivery;

    private TownDeliveryRepositoryImpl(){
        this.tnDelivery = new HashSet<>();
    }

    public static TownDeliveryRepositoryImpl getRepository(){
        if (repository == null) repository = new TownDeliveryRepositoryImpl();
        return repository;
    }

    @Override
    public TownDelivery create(TownDelivery delivery){
        this.tnDelivery.add(delivery);
        return delivery;
    }
    @Override
    public TownDelivery read(String deliveryId){
        return tnDelivery.stream().filter(delivery -> delivery.getTnDeliveId().equals(deliveryId)).findAny().orElse(null);
    }
    @Override
    public void delete(String deliveryId) {
        TownDelivery toDelete = read(deliveryId);
        tnDelivery.remove(toDelete);
    }
    @Override
    public TownDelivery update(TownDelivery delivery){
        TownDelivery toDelete = read(delivery.getTnDeliveId());
        if(toDelete != null) {
            tnDelivery.remove(toDelete);
            tnDelivery.add(delivery);
            return delivery;
        }
        return null;
    }

    @Override
    public Set<TownDelivery> getAll(){
        return this.tnDelivery;
    }
}
