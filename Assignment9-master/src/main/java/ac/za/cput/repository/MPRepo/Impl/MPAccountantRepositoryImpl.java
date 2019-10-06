package ac.za.cput.repository.MPRepo.Impl;

import ac.za.cput.domain.MP.MPAccountant;
import ac.za.cput.repository.MPRepo.MPAccountantRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("MPAccountantInMemory")
public class MPAccountantRepositoryImpl implements MPAccountantRepository {
    private static MPAccountantRepositoryImpl repository = null;
    private Set<MPAccountant> mpAccount;

    private MPAccountantRepositoryImpl(){
        this.mpAccount = new HashSet<>();
    }

    public static MPAccountantRepositoryImpl getRepository(){
        if (repository == null) repository = new MPAccountantRepositoryImpl();
        return repository;
    }

    @Override
    public MPAccountant create(MPAccountant accountant){
        this.mpAccount.add(accountant);
        return accountant;
    }
    @Override
    public MPAccountant read(String accountantId){
        return mpAccount.stream().filter(accountant -> accountant.getMpAccountId().equals(accountantId)).findAny().orElse(null);
    }
    @Override
    public void delete(String accountantId) {
        MPAccountant toDelete = read(accountantId);
        mpAccount.remove(toDelete);
    }
    @Override
    public MPAccountant update(MPAccountant accountant){
        MPAccountant toDelete = read(accountant.getMpAccountId());
        if(toDelete != null) {
            mpAccount.remove(toDelete);
            mpAccount.add(accountant);
            return accountant;
        }
        return null;
    }

    @Override
    public Set<MPAccountant> getAll(){
        return this.mpAccount;
    }
}
