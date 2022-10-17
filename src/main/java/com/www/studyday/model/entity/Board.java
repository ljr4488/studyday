package com.www.studyday.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="boardmt")
public class Board {
    @Id
    @GeneratedValue
    private Long boardId;
    private String title;
    private String contents;
    private Long userId;
    private int views;
    private int like1;
    private int unlike;
    private LocalDate created_at;
    private LocalDate updated_at;
}
