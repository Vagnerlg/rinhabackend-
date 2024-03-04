package vagnerlg.com.github.rinhabackend.transaction;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vagnerlg.com.github.rinhabackend.controller.exception.NotFoundException;
import vagnerlg.com.github.rinhabackend.balance.Balance;
import vagnerlg.com.github.rinhabackend.balance.BalanceRepository;

@AllArgsConstructor
@Service
public class TransactionService {

    private TransactionRepository repository;

    private BalanceRepository balanceRepository;

    @Transactional
    public Balance transaction(TransactionRequest request, int id) {
        var balance = balanceRepository.findById(id).orElseThrow(NotFoundException::new);
        var balanceValue = request.getValue();

        if (request.getType().equals("d")) {
            balanceValue = balance.getTotal() - request.getValue();
            if (balanceValue < (balance.getLimit() * -1)) {
                throw new IllegalArgumentException();
            }
        }

        if (request.getType().equals("c")) {
            balanceValue = balance.getTotal() + request.getValue();
        }

        balance.setTotal(balanceValue);
        balanceRepository.save(balance);

        var transaction = new Transaction();
        transaction.setValue(request.getValue());
        transaction.setType(TransactionTypeEnum.valueOf(request.getType()));
        transaction.setDescription(request.getDescription());
        transaction.setUserId(balance.getId());
        repository.save(transaction);

        return balance;
    }
}
