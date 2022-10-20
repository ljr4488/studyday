package com.www.studyday.service;

import com.www.studyday.controller.ifs.CrudInterface;
import com.www.studyday.model.entity.User;
import com.www.studyday.network.Header;
import com.www.studyday.network.request.UserApiRequest;
import com.www.studyday.network.response.UserApiResponse;
import com.www.studyday.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    //1 .reuqest date
    //2 .user 생성
    //3 .생성된 데이터 -> UserApiResponse return
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        System.out.println("UserApiLogicServices " + request);
        //1. request data
        UserApiRequest userApiRequest = request.getData();
        //2. User 생성
        User user = new User();
        user.setLoginId(userApiRequest.getLoginId());
        user.setPassword(userApiRequest.getPassword());
        user.setName(userApiRequest.getName());
        user.setUserType(1);
        user.setIsLock(1);
        user.setBirth(LocalDateTime.now());
        user.setAddress(userApiRequest.getAddress());
        user.setCreated_at(LocalDateTime.now());
        user.setUpdated_at(LocalDateTime.now());

        User newUser = userRepository.save(user);

        // 3.생성된 데이터 -> userApiResponse return

        return response(newUser);
    }

    @Override
    public Header read(String LoginId) {
        System.out.println("LoginId : " + LoginId);
        return userRepository.findByLoginId(LoginId)
            .map(user -> response(user))
            .orElseGet(
                    () -> Header.ERROR("데이터 없음")
            );
    }

    @Override
    public Header read(Long roomId, LocalDate reserveDate) {
        return null;
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        System.out.println("UserApiLogicServices " + request);
        //1. request data
        UserApiRequest userApiRequest = request.getData();
        //2. User 생성
        User user = new User();
        user.setUserId(userApiRequest.getUserId());
        user.setLoginId(userApiRequest.getLoginId());
        user.setPassword(userApiRequest.getPassword());
        user.setName(userApiRequest.getName());
        user.setAddress(userApiRequest.getAddress());
        user.setUpdated_at(LocalDateTime.now());

        User newUser = userRepository.save(user);
        return response(newUser);
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    private Header<UserApiResponse> response(User user) {
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .userId(user.getUserId())
                .loginId(user.getLoginId())
                .password(user.getPassword())
                .name(user.getName())
                .userType(user.getUserType())
                .isLock(user.getIsLock())
                .birth(user.getBirth())
                .address(user.getAddress())
                .createdAt(user.getCreated_at())
                .updatedAt(user.getUpdated_at())
                .build();

        //return Header.OK(userApiResponse);
        return Header.OK(userApiResponse);
    }
}
