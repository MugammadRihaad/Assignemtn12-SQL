package ac.za.cput.repository.LedgerRepo.Impl;

import ac.za.cput.domain.Ledger.GeneralLedger;
import ac.za.cput.repository.LedgerRepo.GeneralLedgerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("GeneralLedgerInMemory")
public class GeneralLedgerRepositoryImpl implements GeneralLedgerRepository {
    private static GeneralLedgerRepositoryImpl repository = null;
    private Set<GeneralLedger> genLedger;

    private GeneralLedgerRepositoryImpl(){
        this.genLedger = new HashSet<>();
    }

    public static GeneralLedgerRepositoryImpl getRepository(){
        if (repository == null) repository = new GeneralLedgerRepositoryImpl();
        return repository;
    }

    @Override
    public GeneralLedger create(GeneralLedger ledger){
        this.genLedger.add(ledger);
        return ledger;
    }
    @Override
    public GeneralLedger read(String ledgerId){
        return genLedger.stream().filter(ledger -> ledger.getGeneralLId().equals(ledgerId)).findAny().orElse(null);
    }
    @Override
    public void delete(String ledgerId) {
        GeneralLedger toDelete = read(ledgerId);
        genLedger.remove(toDelete);
    }
    @Override
    public GeneralLedger update(GeneralLedger ledger){
        GeneralLedger inDelete = read(ledger.getGeneralLId());

        if(inDelete != null){
            genLedger.remove(inDelete);
            genLedger.add(ledger);
            return ledger;
        }

        return null;
    }

    @Override
    public Set<GeneralLedger> getAll(){
        return this.genLedger;
    }
}
