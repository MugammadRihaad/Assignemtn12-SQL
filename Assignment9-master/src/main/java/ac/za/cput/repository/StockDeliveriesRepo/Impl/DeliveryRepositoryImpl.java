package ac.za.cput.repository.StockDeliveriesRepo.Impl;

import ac.za.cput.domain.StockDeliveries.Deliveries;
import ac.za.cput.repository.StockDeliveriesRepo.DeliveryRepository;
import org.springframework.stereotype.Repository;


import java.util.HashSet;
import java.util.Set;
@Repository("DeliveryInMemory")
public class DeliveryRepositoryImpl implements DeliveryRepository {
    private static DeliveryRepositoryImpl repository = null;
    private Set<Deliveries> deliveries;

    private DeliveryRepositoryImpl(){
        this.deliveries = new HashSet<>();
    }

    public static DeliveryRepositoryImpl getRepository(){
        if (repository == null) repository = new DeliveryRepositoryImpl();
        return repository;
    }

    @Override
    public Deliveries create(Deliveries deliv){
        this.deliveries.add(deliv);
        return deliv;
    }
    @Override
    public Deliveries read(String delivId){
        return deliveries.stream().filter(deliv -> deliv.getDelivId().equals(delivId)).findAny().orElse(null);
    }
    @Override
    public void delete(String delivId) {
        Deliveries toDelete = read(delivId);
        deliveries.remove(toDelete);
    }
    @Override
    public Deliveries update(Deliveries delivId){
        Deliveries toDelete = read(delivId.getDelivId());
        if(toDelete != null) {
            deliveries.remove(toDelete);
            deliveries.add(delivId);
            return delivId;
        }
        return null;
    }

    @Override
    public Set<Deliveries> getAll(){
        return this.deliveries;
    }
}
