package com.hari.service.interfac;

import com.hari.dto.Response;
import com.hari.entity.Booking;

public interface BookingService {
    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);
}
