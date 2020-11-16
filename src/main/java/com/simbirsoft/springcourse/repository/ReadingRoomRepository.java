package com.simbirsoft.springcourse.repository;

import com.simbirsoft.springcourse.model.ReadingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRoomRepository extends JpaRepository<ReadingRoom, Long> {
}
