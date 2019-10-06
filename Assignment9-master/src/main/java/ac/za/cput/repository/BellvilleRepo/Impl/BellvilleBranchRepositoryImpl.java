package ac.za.cput.repository.BellvilleRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleBranch;
import ac.za.cput.repository.BellvilleRepo.BellvilleBranchRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("BellvilleBranchInMemory")
public class BellvilleBranchRepositoryImpl implements BellvilleBranchRepository {
    private static BellvilleBranchRepositoryImpl repository = null;
    private Set<BellvilleBranch> bellBranch;

    private BellvilleBranchRepositoryImpl(){
        this.bellBranch = new HashSet<>();
    }

    public static BellvilleBranchRepositoryImpl getRepository(){
        if (repository == null) repository = new BellvilleBranchRepositoryImpl();
        return repository;
    }


    public BellvilleBranch create(BellvilleBranch branch){
        this.bellBranch.add(branch);
        return branch;
    }

    public BellvilleBranch read(String branchId){
        return bellBranch.stream().filter(branch -> branch.getBellBrId().equals(branchId)).findAny().orElse(null);
    }

    public void delete(String branchId) {
        BellvilleBranch inDelete=read(branchId);
        bellBranch.remove(inDelete);
    }

    public BellvilleBranch update(BellvilleBranch branch){
        BellvilleBranch inDelete = read(branch.getBellBrId());

        if(inDelete != null){
            bellBranch.remove(inDelete);
            bellBranch.add(branch);
            return branch;
        }

        return null;
    }

    @Override
    public Set<BellvilleBranch> getAll(){
        return this.bellBranch;
    }
}
