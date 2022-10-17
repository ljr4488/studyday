package com.www.studyday.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="reservemt")
public class Reserve {
    @Id
    @GeneratedValue
    private Long reserveId;
    private Long roomId;
    private Long userId;
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;
    private int sixth;
    private int seventh;
    private int eighth;
    private int ninth;
    private int tenth;
    private int eleventh;
    private int twelfth;
    private int hirteenth;

}
