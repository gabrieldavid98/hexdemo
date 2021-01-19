package net.gd.hexdemo.infrastructure.jpa.repositories;

import net.gd.hexdemo.infrastructure.jpa.entities.Debit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DebitsJpaRepository extends JpaRepository<Debit, UUID> {
    List<Debit> findByAccountId(UUID accountId);
}
