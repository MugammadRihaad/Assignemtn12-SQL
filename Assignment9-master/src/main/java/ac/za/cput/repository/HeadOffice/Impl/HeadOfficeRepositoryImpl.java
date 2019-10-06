package ac.za.cput.repository.HeadOffice.Impl;

import ac.za.cput.domain.HeadOffice;
import ac.za.cput.repository.HeadOffice.HeadOfficeRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("HeadOfficeInMemory")
public class HeadOfficeRepositoryImpl implements HeadOfficeRepository {
    private static HeadOfficeRepositoryImpl repository = null;
    private Set<HeadOffice> offices;

    private HeadOfficeRepositoryImpl(){
        this.offices = new HashSet<>();
    }

    public static HeadOfficeRepositoryImpl getRepository(){
        if (repository == null) repository = new HeadOfficeRepositoryImpl();
        return repository;
    }

    @Override
    public HeadOffice create(HeadOffice office){
        this.offices.add(office);
        return office;
    }
    @Override
    public HeadOffice read(String officeId){
        return offices.stream().filter(office -> office.getOfficeId().equals(officeId)).findAny().orElse(null);
    }
    @Override
    public void delete(String officeId) {
        HeadOffice toDelete = read(officeId);
        offices.remove(toDelete);
    }
    @Override
    public HeadOffice update(HeadOffice office){
        HeadOffice inDelete = read(office.getOfficeId());

        if(inDelete != null){
            offices.remove(inDelete);
            offices.add(office);
            return office;
        }

        return null;
    }

    @Override
    public Set<HeadOffice> getAll(){
        return this.offices;
    }
}
