package vagnerlg.com.github.rinhabackend.balance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import vagnerlg.com.github.rinhabackend.transaction.Transaction;

import java.util.List;

@Data
public class BankStatement {
    @JsonProperty("saldo")
    private BalanceResponse balance;

    @JsonProperty("ultimas_transacoes")
    private List<Transaction> transactions;
}
