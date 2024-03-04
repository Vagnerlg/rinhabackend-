package vagnerlg.com.github.rinhabackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vagnerlg.com.github.rinhabackend.balance.Balance;
import vagnerlg.com.github.rinhabackend.balance.BalanceService;
import vagnerlg.com.github.rinhabackend.balance.BankStatement;
import vagnerlg.com.github.rinhabackend.transaction.TransactionRequest;
import vagnerlg.com.github.rinhabackend.transaction.TransactionService;

@RestController
@AllArgsConstructor
public class ApiController {

    private TransactionService service;
    private BalanceService serviceBalance;

    @PostMapping("/clientes/{id}/transacoes")
    Balance transaction(@Valid @RequestBody TransactionRequest transaction, @PathVariable(name = "id") int id) {
        return service.transaction(transaction, id);
    }

    @GetMapping("/clientes/{id}/extrato")
    BankStatement bankStatement(@PathVariable(name = "id") int id){
        return serviceBalance.bankStatement(id);
    }
}
