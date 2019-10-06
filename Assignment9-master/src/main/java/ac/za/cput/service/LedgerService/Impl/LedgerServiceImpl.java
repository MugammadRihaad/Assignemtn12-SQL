package ac.za.cput.service.LedgerService.Impl;

import ac.za.cput.domain.Ledger.Ledger;
import ac.za.cput.repository.LedgerRepo.Impl.LedgerRepositoryImpl;
import ac.za.cput.repository.LedgerRepo.LedgerRepository;
import ac.za.cput.service.LedgerService.LedgerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("LedgerServiceImpl")
public class LedgerServiceImpl implements LedgerService {
    private  LedgerServiceImpl service = null;
    private LedgerRepository repository;

    private LedgerServiceImpl(){
        this.repository = LedgerRepositoryImpl.getRepository();
    }
    public LedgerServiceImpl getService(){
        if (service == null){
            service = new LedgerServiceImpl();
        }
        return service;
    }



    @Override
    public Set<Ledger> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Ledger create(Ledger Ledger) {
        return this.repository.create(Ledger);
    }

    @Override
    public Ledger read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public Ledger update(Ledger Ledger) {
        return this.repository.update(Ledger);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}

