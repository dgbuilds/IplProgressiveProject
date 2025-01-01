package com.wecp.progressive.controller;

import com.wecp.progressive.entity.TicketBooking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketBookingController {

    public ResponseEntity<List<TicketBooking>> getAllBookings() {
        return null;
    }

    public ResponseEntity<Integer> createBooking(TicketBooking ticketBooking) {
        return null;
    }

    public ResponseEntity<Void> cancelBooking(int bookingId) {
        return null;
    }

    public ResponseEntity<List<TicketBooking>> getBookingsByUserEmail(String email) {
        return null;
    }
}
