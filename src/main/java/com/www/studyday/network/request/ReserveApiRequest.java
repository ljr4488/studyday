package com.www.studyday.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReserveApiRequest {
    private Long reserveId;
    private Long roomId;
    private Long userId;
    private LocalDate reserveDate;
    private int startTime;
    private int endTime;
}
