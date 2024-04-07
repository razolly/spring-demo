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

    /*
     * Note: creating a new field called itemId will cause issues
     * For the join column "item_id"
     *      "item" refers to the parent class
     *      "id" refers to the primary key in the parent class
     *
     * This field is non-nullable because a bid shouldn't exist without an item
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

}
