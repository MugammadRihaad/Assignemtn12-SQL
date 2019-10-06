package ac.za.cput.repository.BellvilleRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleDelivery;
import ac.za.cput.repository.BellvilleRepo.BellvilleDeliveryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("BellvilleDeliveryInMemory")
public class BellvilleDeliveryRepositoryImpl implements BellvilleDeliveryRepository {
    private static BellvilleDeliveryRepositoryImpl repository = null;
    private Set<BellvilleDelivery> bellDelivery;

    private BellvilleDeliveryRepositoryImpl(){
        this.bellDelivery = new HashSet<>();
    }

    public static BellvilleDeliveryRepositoryImpl getRepository(){
        if (repository == null) repository = new BellvilleDeliveryRepositoryImpl();
        return repository;
    }

    @Override
    public BellvilleDelivery create(BellvilleDelivery delivery){
        this.bellDelivery.add(delivery);
        return delivery;
    }
    @Override
    public BellvilleDelivery read(String deliveryId){
        return bellDelivery.stream().filter(delivery -> delivery.getBellDeliveId().equals(deliveryId)).findAny().orElse(null);
    }
    @Override
    public void delete(String deliveryId) {
        BellvilleDelivery inDelete=read(deliveryId);
        bellDelivery.remove(inDelete);
    }
    @Override
    public BellvilleDelivery update(BellvilleDelivery delivery){
        BellvilleDelivery inDelete = read(delivery.getBellDeliveId());

        if(inDelete != null){
            bellDelivery.remove(inDelete);
            bellDelivery.add(delivery);
            return delivery;
        }

        return null;
    }

    @Override
    public Set<BellvilleDelivery> getAll(){
        return this.bellDelivery;
    }
}
