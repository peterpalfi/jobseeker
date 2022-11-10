package com.pp.jobseeker.services;

import com.pp.jobseeker.models.Position;
import com.pp.jobseeker.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }

    public List<Long> findPosition(String keyword, String location) {
        List<Long> resultIdList = new ArrayList<>();
        positionRepository.findPositionByNameContainingIgnoreCaseAndLocationEqualsIgnoreCase(keyword, location)
                .forEach(position -> resultIdList.add(position.getId()));
        return resultIdList;
    }

    public Optional<Position> getPosition(Long id){
        return positionRepository.findPositionById(id);
    }
}
