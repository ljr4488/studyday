package com.www.studyday.repository;

import com.www.studyday.StudydayApplicationTests;
import com.www.studyday.model.entity.Reserve;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class ReserveRepositoryTest extends StudydayApplicationTests {

    @Autowired
    ReserveRepository reserveRespository;

    @Test
    public void create() {
        Reserve reserve = new Reserve();
        reserve.setRoomId(1L);
        reserve.setUserId(1L);
        reserve.setReserveDate(LocalDate.now());
        reserve.setStartTime(9);
        reserve.setEndTime(10);
        reserve.setStatus("A");

        Reserve newReserve = reserveRespository.save(reserve);

        System.out.println("newReserve : " + newReserve);
    }
}
