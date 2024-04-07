package com.example.demo.repository;

import com.example.demo.model.Bid;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BidRepositoryTest {

    @Autowired
    BidRepository bidRepository;

    @Test
    @DisplayName("""
            GIVEN a BID has a parent ITEM
            AND has a @ManyToOne unidirectional relationship
            WHEN BID is retrieved
            THEN PARENT is also retrieved
            """)
    @Sql("/test-data/insert_item.sql")
    void test_unidirectional_manyToOne() {
        Optional<Bid> optBid = bidRepository.findById(UUID.fromString("3662cd35-4a63-4e6b-b9d5-7ef347e4e7af"));
        assertTrue(optBid.isPresent());
        // Verify parent is present with correct values
        assertNotNull(optBid.get().getItem());
        assertEquals("86923c55-5e33-40e8-82a1-aa70a8661245", optBid.get().getItem().getId().toString());
        assertEquals("Item01", optBid.get().getItem().getName());
    }

}