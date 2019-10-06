package ac.za.cput.repository.LedgerRepo.Impl;

import ac.za.cput.domain.Ledger.CreditorsLedger;
import ac.za.cput.repository.LedgerRepo.CreditorsLedgerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("CreditorsLedgerInMemory")
public class CreditorsLedgerRepositoryImpl implements CreditorsLedgerRepository {
    private static CreditorsLedgerRepositoryImpl repository = null;
    private Set<CreditorsLedger> credLedger;

    private CreditorsLedgerRepositoryImpl(){
        this.credLedger = new HashSet<>();
    }

    public static CreditorsLedgerRepositoryImpl getRepository(){
        if (repository == null) repository = new CreditorsLedgerRepositoryImpl();
        return repository;
    }

    @Override
    public CreditorsLedger create(CreditorsLedger ledger){
        this.credLedger.add(ledger);
        return ledger;
    }
    @Override
    public CreditorsLedger read(String ledgerId){
        return credLedger.stream().filter(ledger -> ledger.getCreditorsLId().equals(ledgerId)).findAny().orElse(null);
    }
    @Override
    public void delete(String ledgerId) {
        CreditorsLedger toDelete = read(ledgerId);
        credLedger.remove(toDelete);
    }
    @Override
    public CreditorsLedger update(CreditorsLedger ledger){
        CreditorsLedger inDelete = read(ledger.getCreditorsLId());

        if(inDelete != null){
            credLedger.remove(inDelete);
            credLedger.add(ledger);
            return ledger;
        }

        return null;
    }

    @Override
    public Set<CreditorsLedger> getAll(){
        return this.credLedger;
    }
}
