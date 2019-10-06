package ac.za.cput.repository.MPRepo.Impl;

import ac.za.cput.domain.MP.MPBranch;
import ac.za.cput.repository.MPRepo.MPBranchRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("MPBranchInMemory")
public class MPBranchRepositoryImpl implements MPBranchRepository {
    private static MPBranchRepositoryImpl repository = null;
    private Set<MPBranch> mpBranch;

    private MPBranchRepositoryImpl(){
        this.mpBranch = new HashSet<>();
    }

    public static MPBranchRepositoryImpl getRepository(){
        if (repository == null) repository = new MPBranchRepositoryImpl();
        return repository;
    }

    @Override
    public MPBranch create(MPBranch branch){
        this.mpBranch.add(branch);
        return branch;
    }
    @Override
    public MPBranch read(String branchId){
        return mpBranch.stream().filter(branch -> branch.getMpBrId().equals(branchId)).findAny().orElse(null);
    }
    @Override
    public void delete(String branchId) {
        MPBranch toDelete = read(branchId);
        mpBranch.remove(toDelete);
    }
    @Override
    public MPBranch update(MPBranch branch){
        MPBranch toDelete = read(branch.getMpBrId());
        if(toDelete != null) {
            mpBranch.remove(toDelete);
            mpBranch.add(branch);
            return branch;
        }
        return null;
    }

    @Override
    public Set<MPBranch> getAll(){
        return this.mpBranch;
    }
}
