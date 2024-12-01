package com.hari.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "check in date is required")
    private LocalDateTime checkInDate;

    @Future(message = "check out date be in future")
    private LocalDateTime checkOutDate;

    @Min(value = 1,message = "Number of adults must not be less that 1")
    private int numOfAdults;

    @Min(value = 1,message = "Number of children must not be less that 0")
    private int numOfChildren;


    private int totalNumOfGuest;

    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;


    public void  calculateTotalNumOfGuest() {
        this.totalNumOfGuest=this.numOfAdults+this.numOfChildren;

    }

    public void setNumOfChildren(@Min(value = 1, message = "Number of children must not be less that 0") int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumOfGuest();
    }

    public void setNumOfAdults(@Min(value = 1, message = "Number of adults must not be less that 1") int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumOfGuest();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numOfAdults=" + numOfAdults +
                ", numOfChildren=" + numOfChildren +
                ", totalNumOfGuest=" + totalNumOfGuest +
                ", bookingConfirmationCode='" + bookingConfirmationCode + '\'' +
                '}';
    }

}
