package vagnerlg.com.github.rinhabackend.balance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BalanceResponse {
    private int total;

    @JsonProperty("limite")
    private int limit;

    @JsonProperty("data_extrato")
    private LocalDateTime now = LocalDateTime.now();
}
