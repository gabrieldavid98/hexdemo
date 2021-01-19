package net.gd.hexdemo.infrastructure.jpa.repositories;

import net.gd.hexdemo.infrastructure.jpa.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account, UUID> {
}
