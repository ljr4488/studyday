package com.www.studyday.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="usermt")
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
    private String loginId;
    private String password;
    private String name;
    private int userType;
    private LocalDateTime birth;
    private int isLock;
    private String address;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
