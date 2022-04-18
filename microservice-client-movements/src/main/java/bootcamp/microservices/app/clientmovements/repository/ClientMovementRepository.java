package bootcamp.microservices.app.clientmovements.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservices.app.clientmovements.documents.ClientMovement;
import bootcamp.microservices.app.clientmovements.documents.OperationType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientMovementRepository extends ReactiveMongoRepository<ClientMovement, String> {

	public Flux<ClientMovement> findByMovementTypeAndIdOriginMovement(Integer movementType, String idOriginMovement);

	public Flux<ClientMovement> findByMovementTypeAndIdDestinyMovement(Integer movementType, String idDestinyMovement);

	public Mono<ClientMovement> FindByOperationType(OperationType operationType);

}
