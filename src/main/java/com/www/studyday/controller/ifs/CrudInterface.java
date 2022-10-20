package com.www.studyday.controller.ifs;

import com.www.studyday.network.Header;

import java.time.LocalDate;

public interface CrudInterface<Req, Res> {
    Header<Res> create(Header<Req> request);
    Header read(String LoginId);
    Header read(Long roomId, LocalDate reserveDate);
    Header<Res> update(Header<Req> request);
    Header delete(Long id);
}
