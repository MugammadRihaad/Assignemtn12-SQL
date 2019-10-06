package ac.za.cput.repository.BellvilleRepo;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.domain.Bellville.bellvilleBaker;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface BellvilleBakerRepository extends IRepository<bellvilleBaker, String> {
    Set<bellvilleBaker> getAll();
}