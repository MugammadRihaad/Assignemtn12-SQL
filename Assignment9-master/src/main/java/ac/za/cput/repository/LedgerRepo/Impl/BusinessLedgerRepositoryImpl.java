package ac.za.cput.repository.LedgerRepo.Impl;

import ac.za.cput.domain.Ledger.BusinessLedger;
import ac.za.cput.repository.LedgerRepo.BusinessLedgerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("BusinessLedgerInMemory")
public class BusinessLedgerRepositoryImpl implements BusinessLedgerRepository {
    private static BusinessLedgerRepositoryImpl repository = null;
    private Set<BusinessLedger> busLedger;

    private BusinessLedgerRepositoryImpl(){
        this.busLedger = new HashSet<>();
    }

    public static BusinessLedgerRepositoryImpl getRepository(){
        if (repository == null) repository = new BusinessLedgerRepositoryImpl();
        return repository;
    }

    @Override
    public BusinessLedger create(BusinessLedger ledger){
        this.busLedger.add(ledger);
        return ledger;
    }
    @Override
    public BusinessLedger read(String ledgerId){
        return busLedger.stream().filter(ledger -> ledger.getBusniessLId().equals(ledgerId)).findAny().orElse(null);
    }
    @Override
    public void delete(String ledgerId) {
        BusinessLedger toDelete = read(ledgerId);
        busLedger.remove(toDelete);
    }
    @Override
    public BusinessLedger update(BusinessLedger ledger){
        BusinessLedger inDelete = read(ledger.getBusniessLId());

        if(inDelete != null){
            busLedger.remove(inDelete);
            busLedger.add(ledger);
            return ledger;
        }

        return null;
    }

    @Override
    public Set<BusinessLedger> getAll(){
        return this.busLedger;
    }
}
