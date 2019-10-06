package ac.za.cput.repository.MPRepo.Impl;

import ac.za.cput.domain.MP.MPBaker;
import ac.za.cput.domain.MP.MPBranch;
import ac.za.cput.repository.MPRepo.MPBakerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("MPBakerInMemory")
public class MPBakerRepositoryImpl implements MPBakerRepository {
    private static MPBakerRepositoryImpl repository = null;
    private Set<MPBaker> mpBaker;

    private MPBakerRepositoryImpl(){
        this.mpBaker = new HashSet<>();
    }

    public static MPBakerRepositoryImpl getRepository(){
        if (repository == null) repository = new MPBakerRepositoryImpl();
        return repository;
    }

    @Override
    public MPBaker create(MPBaker baker){
        this.mpBaker.add(baker);
        return baker;
    }
    @Override
    public MPBaker read(String bakerId){
        return mpBaker.stream().filter(baker -> baker.getMpBakerId().equals(bakerId)).findAny().orElse(null);
    }
    @Override
    public void delete(String bakerId) {
        MPBaker toDelete = read(bakerId);
        mpBaker.remove(toDelete);
    }
    @Override
    public MPBaker update(MPBaker baker){
        MPBaker toDelete = read(baker.getMpBakerId());
        if(toDelete != null) {
            mpBaker.remove(toDelete);
            mpBaker.add(baker);
            return baker;
        }
        return null;
    }

    @Override
    public Set<MPBaker> getAll(){
        return this.mpBaker;
    }
}
