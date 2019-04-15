package hellogcp.repository;

import hellogcp.domain.Person;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends DatastoreRepository<Person, String> {

}
