package com.www.studyday.repository;

import com.www.studyday.model.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {

    Optional<Reserve> findByRoomId(Long roomId);
    Optional<Reserve> findByReserveDate(LocalDate reserveDate);
    Optional<Reserve> findByRoomIdAndReserveDate(Long roomId, LocalDate reserveDate);

}
