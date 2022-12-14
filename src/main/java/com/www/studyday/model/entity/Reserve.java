package com.www.studyday.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="reservemt")
public class Reserve {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long reserveId;
    private Long roomId;
    private Long userId;
    private LocalDate reserveDate;
    private int startTime;
    private int endTime;
    private String status;
}
