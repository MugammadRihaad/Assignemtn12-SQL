package ac.za.cput.repository.LedgerRepo;

import ac.za.cput.domain.Ledger.GeneralLedger;
import ac.za.cput.repository.IRepository;

import java.util.Set;
public interface GeneralLedgerRepository extends IRepository<GeneralLedger, String> {
    Set<GeneralLedger> getAll();
}