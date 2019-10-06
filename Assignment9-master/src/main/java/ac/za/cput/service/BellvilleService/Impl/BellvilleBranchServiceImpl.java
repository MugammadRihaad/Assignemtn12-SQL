package ac.za.cput.service.BellvilleService.Impl;


import ac.za.cput.domain.Bellville.BellvilleBranch;
import ac.za.cput.repository.BellvilleRepo.BellvilleBranchRepository;
import ac.za.cput.repository.BellvilleRepo.Impl.BellvilleBranchRepositoryImpl;
import ac.za.cput.service.BellvilleService.BellvilleBranchService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("BellvilleBranchServiceImpl")
public class BellvilleBranchServiceImpl implements BellvilleBranchService {
    private  BellvilleBranchServiceImpl service = null;
    private BellvilleBranchRepository repository;

    private BellvilleBranchServiceImpl(){
        this.repository = BellvilleBranchRepositoryImpl.getRepository();
    }
    public BellvilleBranchServiceImpl getService(){
        if (service == null){
            service = new BellvilleBranchServiceImpl();
        }
        return service;
    }



    @Override
    public Set<BellvilleBranch> getAll() {
        return this.repository.getAll();
    }

    @Override
    public BellvilleBranch create(BellvilleBranch branch) {
        return this.repository.create(branch);
    }

    @Override
    public BellvilleBranch read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public BellvilleBranch update(BellvilleBranch branch) {
        return this.repository.update(branch);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
