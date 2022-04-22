package bootcamp.microservices.app.clientmovements.clientaccounts;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import bootcamp.microservices.app.clientmovements.documents.Account;
import reactor.core.publisher.Mono;

@FeignClient(name = "microservice-client-accounts")
public interface ClientMovementFeignClientAccount {

	@GetMapping("/id/{id}")
	public Mono<Account> searchById(@PathVariable String id);
}
