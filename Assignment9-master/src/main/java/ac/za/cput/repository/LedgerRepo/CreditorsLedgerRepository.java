package ac.za.cput.repository.LedgerRepo;

import ac.za.cput.domain.Ledger.CreditorsLedger;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface CreditorsLedgerRepository extends IRepository<CreditorsLedger, String> {
    Set<CreditorsLedger> getAll();
}
