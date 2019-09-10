package com.metropolitan.booking.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {

    private String apartmentId;
    private String customerId;
    private Date datumPocetka;
    private Date datumIsteka;
}
