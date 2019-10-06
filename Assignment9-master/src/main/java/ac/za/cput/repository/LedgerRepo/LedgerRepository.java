package ac.za.cput.repository.LedgerRepo;

import ac.za.cput.domain.Ledger.Ledger;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface LedgerRepository extends IRepository<Ledger, String> {
    Set<Ledger> getAll();
}
