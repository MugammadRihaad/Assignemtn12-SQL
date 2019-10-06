package ac.za.cput.repository.TownRepo.Impl;

import ac.za.cput.domain.MP.MPBranch;

import ac.za.cput.domain.Town.TownBaker;
import ac.za.cput.domain.Town.TownBranch;
import ac.za.cput.repository.TownRepo.TownBranchRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("TownBranchInMemory")
public class TownBranchRepositoryImpl implements TownBranchRepository {
    private static TownBranchRepositoryImpl repository = null;
    private Set<TownBranch> tnBranch;

    private TownBranchRepositoryImpl(){
        this.tnBranch = new HashSet<>();
    }

    public static TownBranchRepositoryImpl getRepository(){
        if (repository == null) repository = new TownBranchRepositoryImpl();
        return repository;
    }

    @Override
    public TownBranch create(TownBranch branch){
        this.tnBranch.add(branch);
        return branch;
    }
    @Override
    public TownBranch read(String branchId){
        return tnBranch.stream().filter(branch -> branch.getTnBrId().equals(branchId)).findAny().orElse(null);
    }
    @Override
    public void delete(String branchId) {
        TownBranch toDelete = read(branchId);
        tnBranch.remove(toDelete);
    }
    @Override
    public TownBranch update(TownBranch branch){
        TownBranch toDelete = read(branch.getTnBrId());
        if(toDelete != null) {
            tnBranch.remove(toDelete);
            tnBranch.add(branch);
            return branch;
        }
        return null;
    }

    @Override
    public Set<TownBranch> getAll(){
        return this.tnBranch;
    }
}
