package ac.za.cput.repository.LedgerRepo.Impl;

import ac.za.cput.domain.Ledger.Ledger;
import ac.za.cput.repository.LedgerRepo.LedgerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("LedgerInMemory")
public class LedgerRepositoryImpl implements LedgerRepository {
    private static LedgerRepositoryImpl repository = null;
    private Set<Ledger> ledg;

    private LedgerRepositoryImpl(){
        this.ledg = new HashSet<>();
    }

    public static LedgerRepositoryImpl getRepository(){
        if (repository == null) repository = new LedgerRepositoryImpl();
        return repository;
    }

    @Override
    public Ledger create(Ledger ledger){
        this.ledg.add(ledger);
        return ledger;
    }
    @Override
    public Ledger read(String ledgerId){
        return ledg.stream().filter(ledger -> ledger.getLedgerId().equals(ledgerId)).findAny().orElse(null);
    }
    @Override
    public void delete(String ledgerId) {
        Ledger toDelete = read(ledgerId);
        ledg.remove(toDelete);
    }
    @Override
    public Ledger update(Ledger ledger){
        Ledger inDelete = read(ledger.getLedgerId());

        if(inDelete != null){
            ledg.remove(inDelete);
            ledg.add(ledger);
            return ledger;
        }

        return null;
    }

    @Override
    public Set<Ledger> getAll(){
        return this.ledg;
    }
}
