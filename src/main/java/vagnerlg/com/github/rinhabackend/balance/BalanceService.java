package vagnerlg.com.github.rinhabackend.balance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vagnerlg.com.github.rinhabackend.controller.exception.NotFoundException;
import vagnerlg.com.github.rinhabackend.transaction.TransactionRepository;

@Service
@AllArgsConstructor
public class BalanceService {

    private BalanceRepository balanceRepository;

    private TransactionRepository repository;

    public BankStatement bankStatement(int id) {
        var balance = balanceRepository.findById(id).orElseThrow(NotFoundException::new);

        var transactions = repository.findFirst10ByUserIdOrderByCreatedAtDesc(id);

        var responseBalance = new BalanceResponse();
        responseBalance.setTotal(balance.getTotal());
        responseBalance.setLimit(balance.getLimit());

        var bankStatement = new BankStatement();
        bankStatement.setBalance(responseBalance);
        bankStatement.setTransactions(transactions);

        return bankStatement;
    }

}
