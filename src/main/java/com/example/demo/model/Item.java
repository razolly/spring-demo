package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static com.example.demo.constants.DataSourceConstants.TABLE_ITEM;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TABLE_ITEM)
public class Item {

    @Id
    private UUID id;

    private String name;

}
