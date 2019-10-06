package ac.za.cput.service.MPService.Impl;

import ac.za.cput.domain.MP.MPAccountant;
import ac.za.cput.repository.MPRepo.Impl.MPAccountantRepositoryImpl;
import ac.za.cput.repository.MPRepo.MPAccountantRepository;
import ac.za.cput.service.MPService.MPAccountantService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("MPAccountantServiceImpl")
public class MPAccountantServiceImpl implements MPAccountantService {
    private  MPAccountantServiceImpl service = null;
    private MPAccountantRepository repository;

    private MPAccountantServiceImpl(){
        this.repository = MPAccountantRepositoryImpl.getRepository();
    }
    public MPAccountantServiceImpl getService(){
        if (service == null){
            service = new MPAccountantServiceImpl();
        }
        return service;
    }



    @Override
    public Set<MPAccountant> getAll() {
        return this.repository.getAll();
    }

    @Override
    public MPAccountant create(MPAccountant accountant) {
        return this.repository.create(accountant);
    }

    @Override
    public MPAccountant read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public MPAccountant update(MPAccountant accountant) {
        return this.repository.update(accountant);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
