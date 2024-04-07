package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.example.demo.constants.DataSourceConstants.TABLE_BID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TABLE_BID)
public class Bid {

    @Id
    private UUID id;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "item_id") // Note: creating a new field called itemId will cause issues
    private Item item;

}
