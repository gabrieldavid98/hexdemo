package net.gd.hexdemo.infrastructure.jpa.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(columnDefinition = "BINARY(16)", length = 16)
    private UUID id;

    @Column(
        columnDefinition = "BINARY(16)",
        length = 16,
        name = "customer_id"
    )
    private UUID customerId;
}
