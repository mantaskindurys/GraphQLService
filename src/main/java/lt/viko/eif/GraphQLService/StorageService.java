package lt.viko.eif.GraphQLService;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@GraphQLApi
public class StorageService {
    private final StorageRepository storageRepository;

    public StorageService(StorageRepository storageRepository){
        this.storageRepository = storageRepository;
    }

    @GraphQLQuery(name = "storages")
    public List<Storage> getStorages(){
        return storageRepository.findAll();
    }

    @GraphQLQuery(name = "storage") // READ BY ID
    public Optional<Storage> getStorageById(@GraphQLArgument(name = "id") Long id) {
        return storageRepository.findById(id);
    }

    @GraphQLMutation(name = "saveStorage") // CREATE
    public Storage saveStorage(@GraphQLArgument(name = "storage") Storage storage) {
        return storageRepository.save(storage);
    }

    @GraphQLMutation(name = "deleteStorage") // DELETE
    public void deleteStorage(@GraphQLArgument(name = "id") Long id) {
        storageRepository.deleteById(id);
    }

    @GraphQLQuery(name = "isGood")
    public boolean isGood(@GraphQLContext Storage storage) {
        return storage.getDays()>0;
    }


}
