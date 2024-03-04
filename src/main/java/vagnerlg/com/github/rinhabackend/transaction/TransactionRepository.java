package vagnerlg.com.github.rinhabackend.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findFirst10ByUserIdOrderByCreatedAtDesc(int userId);
}
