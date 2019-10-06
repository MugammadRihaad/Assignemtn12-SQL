package ac.za.cput.service.BellvilleService.Impl;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.repository.BellvilleRepo.BellvilleAccountantRepository;
import ac.za.cput.repository.BellvilleRepo.Impl.BellvilleAccountantRepoImpl;
import ac.za.cput.service.BellvilleService.BellvilleAccountantService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("BellvilleAccountantServiceImpl")
public class BellvilleAccountantServiceImpl implements BellvilleAccountantService {
    private  BellvilleAccountantServiceImpl service = null;
    private BellvilleAccountantRepository repository;

    private BellvilleAccountantServiceImpl(){
        this.repository = BellvilleAccountantRepoImpl.getRepository();
    }
    public BellvilleAccountantServiceImpl getService(){
        if (service == null){
            service = new BellvilleAccountantServiceImpl();
        }
        return service;
    }



    @Override
    public Set<BellvilleAccountant> getAll() {
        return this.repository.getAll();
    }

    @Override
    public BellvilleAccountant create(BellvilleAccountant accountant) {
        return this.repository.create(accountant);
    }

    @Override
    public BellvilleAccountant read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public BellvilleAccountant update(BellvilleAccountant accountant) {
        return this.repository.update(accountant);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
