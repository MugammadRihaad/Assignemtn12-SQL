package ac.za.cput.service.LedgerService.Impl;

import ac.za.cput.domain.Ledger.GeneralLedger;
import ac.za.cput.repository.LedgerRepo.GeneralLedgerRepository;
import ac.za.cput.repository.LedgerRepo.Impl.GeneralLedgerRepositoryImpl;
import ac.za.cput.service.LedgerService.GeneralLedgerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("GeneralLedgerServiceImpl")
public class GeneralLedgerServiceImpl implements GeneralLedgerService {
    private  GeneralLedgerServiceImpl service = null;
    private GeneralLedgerRepository repository;

    private GeneralLedgerServiceImpl(){
        this.repository = GeneralLedgerRepositoryImpl.getRepository();
    }
    public GeneralLedgerServiceImpl getService(){
        if (service == null){
            service = new GeneralLedgerServiceImpl();
        }
        return service;
    }



    @Override
    public Set<GeneralLedger> getAll() {
        return this.repository.getAll();
    }

    @Override
    public GeneralLedger create(GeneralLedger genLedger) {
        return this.repository.create(genLedger);
    }

    @Override
    public GeneralLedger read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public GeneralLedger update(GeneralLedger genLedger) {
        return this.repository.update(genLedger);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
