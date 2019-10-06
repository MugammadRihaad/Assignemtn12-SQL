package ac.za.cput.repository.MPRepo.Impl;

import ac.za.cput.domain.MP.MPDelivery;
import ac.za.cput.repository.MPRepo.MPDeliveryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("MPDeliveryInMemory")
public class MPDeliveryRepositoryImpl implements MPDeliveryRepository {
    private static MPDeliveryRepositoryImpl repository = null;
    private Set<MPDelivery> mpDelivery;

    private MPDeliveryRepositoryImpl(){
        this.mpDelivery = new HashSet<>();
    }

    public static MPDeliveryRepositoryImpl getRepository(){
        if (repository == null) repository = new MPDeliveryRepositoryImpl();
        return repository;
    }

    @Override
    public MPDelivery create(MPDelivery delivery){
        this.mpDelivery.add(delivery);
        return delivery;
    }
    @Override
    public MPDelivery read(String deliveryId){
        return mpDelivery.stream().filter(delivery -> delivery.getMpDeliveId().equals(deliveryId)).findAny().orElse(null);
    }
    @Override
    public void delete(String deliveryId) {
        MPDelivery toDelete = read(deliveryId);
        mpDelivery.remove(toDelete);
    }
    @Override
    public MPDelivery update(MPDelivery delivery){
        MPDelivery toDelete = read(delivery.getMpDeliveId());
        if(toDelete != null) {
            mpDelivery.remove(toDelete);
            mpDelivery.add(delivery);
            return delivery;
        }
        return null;
    }

    @Override
    public Set<MPDelivery> getAll(){
        return this.mpDelivery;
    }
}
