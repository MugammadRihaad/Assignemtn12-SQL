package ac.za.cput.repository.BellvilleRepo.Impl;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.domain.Bellville.bellvilleBaker;
import ac.za.cput.repository.BellvilleRepo.BellvilleBakerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("BellvilleBakerInMemory")
public class BellvilleBakerRepositoryImpl implements BellvilleBakerRepository {
    private static BellvilleBakerRepositoryImpl repository = null;
    private Set<bellvilleBaker> bellBaker;

    private BellvilleBakerRepositoryImpl(){
        this.bellBaker = new HashSet<>();
    }

    public static BellvilleBakerRepositoryImpl getRepository(){
        if (repository == null) repository = new BellvilleBakerRepositoryImpl();
        return repository;
    }

    @Override
    public bellvilleBaker create(bellvilleBaker baker){
        this.bellBaker.add(baker);
        return baker;
    }
    @Override
    public bellvilleBaker read(String bakerId){
        return bellBaker.stream().filter(baker -> baker.getBellBakerId().equals(bakerId)).findAny().orElse(null);
    }
    @Override
    public void delete(String bakerId) {
        bellvilleBaker inDelete=read(bakerId);
        bellBaker.remove(inDelete);
    }
    @Override
    public bellvilleBaker update(bellvilleBaker baker){
        bellvilleBaker inDelete = read(baker.getBellBakerId());

        if(inDelete != null){
            bellBaker.remove(inDelete);
            bellBaker.add(baker);
            return baker;
        }

        return null;
    }

    @Override
    public Set<bellvilleBaker> getAll(){
        return this.bellBaker;
    }
}
