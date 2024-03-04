package vagnerlg.com.github.rinhabackend.transaction;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
public class TransactionRequest {

    @JsonAlias("valor")
    @NotNull
    @Min(0)
    private Integer value;

    @JsonAlias("tipo")
    @NotNull
    @Pattern(regexp = "^(c|d)$")
    private String type;

    @JsonAlias("descricao")
    @NotNull
    @Length(max=10, min=1)
    private String description;
}
