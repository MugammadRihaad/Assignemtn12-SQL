package ac.za.cput.repository.BellvilleRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.repository.BellvilleRepo.BellvilleAccountantRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
@Repository("BellvilleAccountantInMemory")
public class BellvilleAccountantRepoImpl implements BellvilleAccountantRepository {
    private static BellvilleAccountantRepoImpl repository = null;
    private Set<BellvilleAccountant> bellAccount;

    private BellvilleAccountantRepoImpl(){
        bellAccount = new HashSet<>();
    }


    public static BellvilleAccountantRepoImpl getRepository(){
        if (repository == null) {
           return new BellvilleAccountantRepoImpl();
        }
        return repository;
    }

    @Override
    public BellvilleAccountant create(BellvilleAccountant accountants){
        bellAccount.add(accountants);
        return accountants;
    }
    @Override
    public BellvilleAccountant read(String account){

        return bellAccount.stream().filter(accountant -> accountant.getBellAccountId().equals(account)).findAny().orElse(null);
    }
    @Override
    public void delete(String account) {
        BellvilleAccountant toDelete = read(account);
        bellAccount.remove(toDelete);
    }
    @Override
    public BellvilleAccountant update(BellvilleAccountant accountant){

        BellvilleAccountant toDelete = read(accountant.getBellAccountId());
        if(toDelete != null) {
            bellAccount.remove(toDelete);
            bellAccount.add(accountant);
            return accountant;
        }
        return null;
    }

    @Override
    public Set<BellvilleAccountant> getAll(){
        return bellAccount;
    }
}
