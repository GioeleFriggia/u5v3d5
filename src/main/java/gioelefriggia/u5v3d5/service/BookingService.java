package gioelefriggia.u5v3d5.service;

import gioelefriggia.u5v3d5.model.Booking;
import gioelefriggia.u5v3d5.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(Booking booking) {

        return bookingRepository.save(booking);
    }

    public Optional<Booking> findBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> findBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = findBookingById(id).orElseThrow(() ->
                new RuntimeException("Booking not found for id :: " + id));


        return bookingRepository.save(booking);
    }

    public void cancelBooking(Long id) {
        Booking booking = findBookingById(id).orElseThrow(() ->
                new RuntimeException("Booking not found for id :: " + id));

        bookingRepository.delete(booking);
    }
}