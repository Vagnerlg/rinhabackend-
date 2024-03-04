package vagnerlg.com.github.rinhabackend.balance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;

    @JsonProperty("saldo")
    private int total;

    @JsonProperty("limite")
    @Column(name = "_limit")
    private int limit;
}
