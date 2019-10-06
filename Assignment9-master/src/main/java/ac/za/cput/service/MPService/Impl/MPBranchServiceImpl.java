package ac.za.cput.service.MPService.Impl;


import ac.za.cput.domain.MP.MPBranch;
import ac.za.cput.repository.MPRepo.Impl.MPBranchRepositoryImpl;
import ac.za.cput.repository.MPRepo.MPBranchRepository;
import ac.za.cput.service.MPService.MPBranchService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("MPBranchServiceImpl")
public class MPBranchServiceImpl implements MPBranchService {
    private  MPBranchServiceImpl service = null;
    private MPBranchRepository repository;

    private MPBranchServiceImpl(){
        this.repository = MPBranchRepositoryImpl.getRepository();
    }
    public MPBranchServiceImpl getService(){
        if (service == null){
            service = new MPBranchServiceImpl();
        }
        return service;
    }



    @Override
    public Set<MPBranch> getAll() {
        return this.repository.getAll();
    }

    @Override
    public MPBranch create(MPBranch branch) {
        return this.repository.create(branch);
    }

    @Override
    public MPBranch read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public MPBranch update(MPBranch branch) {
        return this.repository.update(branch);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
