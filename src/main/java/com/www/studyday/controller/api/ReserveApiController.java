package com.www.studyday.controller.api;

import com.www.studyday.controller.ifs.CrudInterface;
import com.www.studyday.network.Header;
import com.www.studyday.network.request.ReserveApiRequest;
import com.www.studyday.network.response.ReserveApiResponse;
import com.www.studyday.service.ReserveApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/api/reserve")
public class ReserveApiController implements CrudInterface<ReserveApiRequest, ReserveApiResponse> {

    @Autowired
    private ReserveApiLogicService reserveApiLogicService;
    @Override
    @PostMapping
    public Header<ReserveApiResponse> create(@RequestBody Header<ReserveApiRequest> request) {
        System.out.println("{}" + request);
        return reserveApiLogicService.create(request);
    }

    @Override
    public Header read(String LoginId) {
        return null;
    }

    @Override
    @GetMapping
    public Header read(@RequestParam(name="roomId",required = false) Long roomId, @RequestParam(name="reserveDate",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate reserveDate) {
        System.out.println("int roomId : " + roomId);
        return reserveApiLogicService.read(roomId, reserveDate);
    }

    @Override
    @PutMapping
    public Header<ReserveApiResponse> update(Header<ReserveApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable(name="id") Long id) {
        return reserveApiLogicService.delete(id);
    }
}
