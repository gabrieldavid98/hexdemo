package net.gd.hexdemo.infrastructure.jpa.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "credits")
public class Credit {
    @Id
    @Column(columnDefinition = "BINARY(16)", length = 16)
    private UUID id;

    @Column(
        columnDefinition = "BINARY(16)",
        length = 16,
        name = "account_id"
    )
    private UUID accountId;

    private double amount;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

}
