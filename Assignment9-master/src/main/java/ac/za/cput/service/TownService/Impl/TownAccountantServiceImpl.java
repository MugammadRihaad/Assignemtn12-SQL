package ac.za.cput.service.TownService.Impl;


import ac.za.cput.domain.Town.TownAccountant;
import ac.za.cput.repository.TownRepo.Impl.TownAccountantRepositoryImpl;
import ac.za.cput.repository.TownRepo.TownAccountantRepository;
import ac.za.cput.service.TownService.TownAccountantService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("TownAccountantServiceImpl")
public class TownAccountantServiceImpl implements TownAccountantService {
    private  TownAccountantServiceImpl service = null;
    private TownAccountantRepository repository;

    private TownAccountantServiceImpl(){
        this.repository = TownAccountantRepositoryImpl.getRepository();
    }
    public TownAccountantServiceImpl getService(){
        if (service == null){
            service = new TownAccountantServiceImpl();
        }
        return service;
    }



    @Override
    public Set<TownAccountant> getAll() {
        return this.repository.getAll();
    }

    @Override
    public TownAccountant create(TownAccountant accountant) {
        return this.repository.create(accountant);
    }

    @Override
    public TownAccountant read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public TownAccountant update(TownAccountant accountant) {
        return this.repository.update(accountant);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
