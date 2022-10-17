package com.www.studyday.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiResponse {
    private Long userId;
    private String loginId;
    private String password;
    private String name;
    private int userType;
    private LocalDateTime birth;
    private int isLock;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
