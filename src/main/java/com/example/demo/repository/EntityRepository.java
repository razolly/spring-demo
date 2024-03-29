package com.example.demo.repository;

import com.example.demo.model.EntityProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntityRepository extends JpaRepository<EntityProfile, UUID> {
}
