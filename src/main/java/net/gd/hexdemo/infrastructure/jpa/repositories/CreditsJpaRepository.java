package net.gd.hexdemo.infrastructure.jpa.repositories;

import net.gd.hexdemo.infrastructure.jpa.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CreditsJpaRepository extends JpaRepository<Credit, UUID> {
    List<Credit> findByAccountId(UUID accountId);
}
