package vagnerlg.com.github.rinhabackend.balance;

import jakarta.persistence.LockModeType;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BalanceRepository extends JpaRepository<Balance, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @NonNull
    @Transactional
    Optional<Balance> findById(@NonNull Integer id);
}
