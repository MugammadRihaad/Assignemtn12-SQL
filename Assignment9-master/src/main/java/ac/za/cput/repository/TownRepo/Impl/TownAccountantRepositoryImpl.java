package ac.za.cput.repository.TownRepo.Impl;

import ac.za.cput.domain.Town.TownAccountant;
import ac.za.cput.repository.TownRepo.TownAccountantRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("TownAccountantInMemory")
public class TownAccountantRepositoryImpl implements TownAccountantRepository {
    private static TownAccountantRepositoryImpl repository = null;
    private Set<TownAccountant> tnAccount;

    private TownAccountantRepositoryImpl(){
        this.tnAccount = new HashSet<>();
    }

    public static TownAccountantRepositoryImpl getRepository(){
        if (repository == null) repository = new TownAccountantRepositoryImpl();
        return repository;
    }

    @Override
    public TownAccountant create(TownAccountant accountant){
        this.tnAccount.add(accountant);
        return accountant;
    }
    @Override
    public TownAccountant read(String accountantId){
        return tnAccount.stream().filter(accountant -> accountant.getTnAccountId().equals(accountantId)).findAny().orElse(null);
    }
    @Override
    public void delete(String accountantId) {
        TownAccountant toDelete = read(accountantId);
        tnAccount.remove(toDelete);
    }
    @Override
    public TownAccountant update(TownAccountant accountant){
        TownAccountant toDelete = read(accountant.getTnAccountId());
        if(toDelete != null) {
            tnAccount.remove(toDelete);
            tnAccount.add(accountant);
            return accountant;
        }
        return null;
    }

    @Override
    public Set<TownAccountant> getAll(){
        return this.tnAccount;
    }
}
