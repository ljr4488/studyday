package com.www.studyday.controller.ifs;

import com.www.studyday.network.Header;
import com.www.studyday.network.request.UserApiRequest;
import com.www.studyday.network.request.UserApiResponse;

public interface CrudInterface<Req, Res> {
    Header<Res> create(Header<Req> request);
    Header read(String LoginId);
    Header<Res> update(Header<Req> request);
    Header delete(Long id);
}
