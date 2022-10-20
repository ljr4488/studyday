package com.www.studyday.service;

import com.www.studyday.controller.ifs.CrudInterface;
import com.www.studyday.model.entity.Reserve;
import com.www.studyday.model.entity.User;
import com.www.studyday.network.Header;
import com.www.studyday.network.request.ReserveApiRequest;
import com.www.studyday.network.response.ReserveApiResponse;
import com.www.studyday.network.response.UserApiResponse;
import com.www.studyday.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReserveApiLogicService implements CrudInterface<ReserveApiRequest, ReserveApiResponse> {

    @Autowired
    private ReserveRepository reserveRepository;
    @Override
    public Header<ReserveApiResponse> create(Header<ReserveApiRequest> request) {
        System.out.println("ReserveApiLogicService " + request);
        // 1.request data
        ReserveApiRequest reserveApiRequest = request.getData();
        // 2.Reserve 생성
        Reserve reserve = new Reserve();
        reserve.setRoomId(reserveApiRequest.getRoomId());
        reserve.setUserId(reserveApiRequest.getUserId());
        reserve.setReserveDate(reserveApiRequest.getReserveDate());
        reserve.setStartTime(reserveApiRequest.getStartTime());
        reserve.setEndTime(reserveApiRequest.getEndTime());
        reserve.setStatus("A");

        Reserve newReserve = reserveRepository.save(reserve);
        return response(newReserve);
    }

    @Override
    public Header read(String LoginId) {
        return null;
    }

    @Override
    public Header read(Long roomId, LocalDate reserveDate) {
        System.out.println("roomId : " + roomId);
        return reserveRepository.findByRoomIdAndReserveDate(roomId, reserveDate)
                .map(reserve -> response(reserve))
                .orElseGet(
                        () -> Header.ERROR("데이터 없음")
                );
    }

    @Override
    public Header<ReserveApiResponse> update(Header<ReserveApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        Optional<Reserve> optional = reserveRepository.findById(id);

        return optional.map(reserve -> {
            reserveRepository.delete(reserve);
            return Header.OK();
        })
        .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    private Header<ReserveApiResponse> response(Reserve reserve) {
        ReserveApiResponse reserveApiResponse = ReserveApiResponse.builder()
                .reserveId(reserve.getReserveId())
                .roomId(reserve.getRoomId())
                .userId(reserve.getUserId())
                .reserveDate(reserve.getReserveDate())
                .startTime(reserve.getStartTime())
                .endTime(reserve.getEndTime())
                .status(reserve.getStatus())
                .build();
        //return Header.OK(userApiResponse);
        return Header.OK(reserveApiResponse);
    }
}
