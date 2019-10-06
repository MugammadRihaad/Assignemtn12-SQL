package ac.za.cput.service.TownService.Impl;


import ac.za.cput.domain.Town.TownBranch;
import ac.za.cput.repository.TownRepo.Impl.TownBranchRepositoryImpl;
import ac.za.cput.repository.TownRepo.TownBranchRepository;
import ac.za.cput.service.TownService.TownBranchService;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;
@Service("TownBranchServiceImpl")
public class TownBranchServiceImpl implements TownBranchService {
    private  TownBranchServiceImpl service = null;
    private TownBranchRepository repository;

    private TownBranchServiceImpl(){
        this.repository = TownBranchRepositoryImpl.getRepository();
    }
    public TownBranchServiceImpl getService(){
        if (service == null){
            service = new TownBranchServiceImpl();
        }
        return service;
    }



    @Override
    public Set<TownBranch> getAll() {
        return this.repository.getAll();
    }

    @Override
    public TownBranch create(TownBranch branch) {
        return this.repository.create(branch);
    }

    @Override
    public TownBranch read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public TownBranch update(TownBranch branch) {
        return this.repository.update(branch);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
