package ac.za.cput.repository.HeadOffice;

import ac.za.cput.domain.HeadOffice;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface HeadOfficeRepository extends IRepository<HeadOffice, String> {
    Set<HeadOffice> getAll();
}
