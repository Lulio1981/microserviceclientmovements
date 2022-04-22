package bootcamp.microservices.app.clientmovements.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bootcamp.microservices.app.clientmovements.clientaccounts.ClientMovementFeignClientAccount;
import bootcamp.microservices.app.clientmovements.documents.ClientMovement;
import bootcamp.microservices.app.clientmovements.repository.ClientMovementRepository;
import bootcamp.microservices.app.clientmovements.services.ClientMovementService;

@Component
public class BalanceCalculate {

	@Autowired
	private ClientMovementService service;
	
	@Autowired
	private ClientMovementRepository clientMovementRepository;
	
	@Autowired
	private ClientMovementFeignClientAccount clientMovementFeignClientAccount;

	public Double balanceAmount(String idAccount) {

		Double totallyBalance = 0d;

		Double addIncome = service.findByMovementTypeOrigin(idAccount).toStream()
				.filter(cm -> cm.getMovementType() == 1).mapToDouble(ClientMovement::getAmount).sum();

		Double addIncomeTransferAndCreditPayment = service.findByMovementTypeDestiny(idAccount).toStream()
				.filter(cm -> cm.getMovementType() == 1).mapToDouble(ClientMovement::getAmount).sum();

		Double addExpenses = service.findByMovementTypeOrigin(idAccount).toStream()
				.filter(cm -> cm.getMovementType() == 0).mapToDouble(ClientMovement::getAmount).sum();

		totallyBalance = addIncome + addIncomeTransferAndCreditPayment - addExpenses;

		return totallyBalance;
	}

	public int numberOfClientAccountOperations(String idOriginMovement) {
		return Integer.parseInt(clientMovementRepository.findByIdOriginMovement(idOriginMovement)
				.filter(cm -> cm.getOperationType().getShortName() == "DEPOS")
				.filter(cm -> cm.getOperationType().getShortName() == "WITHD").count().block().toString());
	}

	public int numberOperationsMonth(String idOriginMovement) {
		return clientMovementFeignClientAccount.searchById(idOriginMovement).block().getOperationsNumber();
	}

}
