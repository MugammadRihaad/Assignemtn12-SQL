package ac.za.cput.service.TownService.Impl;


import ac.za.cput.domain.Town.ProductBiscuits;
import ac.za.cput.repository.TownRepo.Impl.ProductBiscuitsRepositoryImpl;
import ac.za.cput.repository.TownRepo.ProductBiscuitsRepository;
import ac.za.cput.service.TownService.ProductBiscuitsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("ProductBiscuitsServiceImpl")
public class ProductBiscuitsServiceImpl implements ProductBiscuitsService {
    private  ProductBiscuitsServiceImpl service = null;
    private ProductBiscuitsRepository repository;

    private ProductBiscuitsServiceImpl(){
        this.repository = ProductBiscuitsRepositoryImpl.getRepository();
    }
    public ProductBiscuitsServiceImpl getService(){
        if (service == null){
            service = new ProductBiscuitsServiceImpl();
        }
        return service;
    }



    @Override
    public Set<ProductBiscuits> getAll() {
        return this.repository.getAll();
    }

    @Override
    public ProductBiscuits create(ProductBiscuits biscuits) {
        return this.repository.create(biscuits);
    }

    @Override
    public ProductBiscuits read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public ProductBiscuits update(ProductBiscuits biscuits) {
        return this.repository.update(biscuits);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
