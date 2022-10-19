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
    @Column(updatable=false)
    private int userType;
    @Column(updatable=false)
    private LocalDateTime birth;
    @Column(updatable=false)
    private int isLock;
    private String address;
    @Column(updatable=false)
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
