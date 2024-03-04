package vagnerlg.com.github.rinhabackend.transaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_generator")
    @SequenceGenerator(name = "transaction_generator", sequenceName = "transaction_seq", allocationSize = 1)
    @JsonIgnore
    private int id;

    @JsonProperty("valor")
    private Integer value;

    @JsonProperty("tipo")
    private TransactionTypeEnum type;

    @JsonProperty("descricao")
    private String description;

    @JsonIgnore
    private int userId;

    @CreationTimestamp
    @JsonProperty("realizada_em")
    private LocalDateTime createdAt;
}
