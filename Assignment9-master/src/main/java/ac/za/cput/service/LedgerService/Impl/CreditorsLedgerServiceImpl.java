package ac.za.cput.service.LedgerService.Impl;


import ac.za.cput.domain.Ledger.CreditorsLedger;
import ac.za.cput.repository.LedgerRepo.CreditorsLedgerRepository;
import ac.za.cput.repository.LedgerRepo.Impl.CreditorsLedgerRepositoryImpl;
import ac.za.cput.service.LedgerService.CreditorsLedgerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("CreditorsLedgerServiceImpl")
public class CreditorsLedgerServiceImpl implements CreditorsLedgerService {
    private  CreditorsLedgerServiceImpl service = null;
    private CreditorsLedgerRepository repository;

    private CreditorsLedgerServiceImpl(){
        this.repository = CreditorsLedgerRepositoryImpl.getRepository();
    }
    public CreditorsLedgerServiceImpl getService(){
        if (service == null){
            service = new CreditorsLedgerServiceImpl();
        }
        return service;
    }



    @Override
    public Set<CreditorsLedger> getAll() {
        return this.repository.getAll();
    }

    @Override
    public CreditorsLedger create(CreditorsLedger credLedger) {
        return this.repository.create(credLedger);
    }

    @Override
    public CreditorsLedger read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public CreditorsLedger update(CreditorsLedger credLedger) {
        return this.repository.update(credLedger);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
