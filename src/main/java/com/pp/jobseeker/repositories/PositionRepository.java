package com.pp.jobseeker.repositories;

import com.pp.jobseeker.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

    List<Position> findPositionByNameContainingIgnoreCaseAndLocationEqualsIgnoreCase(String keyword, String location);

    Optional<Position> findPositionById(Long id);
}