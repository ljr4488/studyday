package com.www.studyday.controller.api;

import com.www.studyday.controller.ifs.CrudInterface;
import com.www.studyday.network.Header;
import com.www.studyday.network.request.UserApiRequest;
import com.www.studyday.network.request.UserApiResponse;
import com.www.studyday.service.UserApiLogicService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;
    @Override
    @PostMapping
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        System.out.println("{}" + request);
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header read(@PathVariable(name="id") String LoginId) {
        System.out.println("String LoginId : " + LoginId);
        return userApiLogicService.read(LoginId);
    }

    @Override
    @PutMapping
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping
    public Header delete(Long id) {
        return null;
    }
}
