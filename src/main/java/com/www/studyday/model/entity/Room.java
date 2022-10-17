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
@Table(name="roommt")
public class Room {
    @Id
    @GeneratedValue
    private Long roomId;
    private String rname;
    private String rlocation;
}
