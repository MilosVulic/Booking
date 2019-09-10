package com.metropolitan.booking.reservation;

import com.metropolitan.booking.apartment.ApartmentService;
import com.metropolitan.booking.configuration.Id;
import com.metropolitan.booking.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/add")
    public ResponseEntity createReservation(@RequestBody ReservationRequest reservationRequest) {
        Map<Object, Object> model = new HashMap<>();

        List<Reservation> listica = reservationService.findAllReservations();
        System.out.println("Velicina lista " + listica.size());
        if (listica.size() == 0) {
            reservationService.reserveApartment(new Reservation(Id.generate(), apartmentService.getApartmentById(reservationRequest.getApartmentId()),
                    customerService.findCustomerByCustomerId(reservationRequest.getCustomerId()),
                    reservationRequest.getDatumPocetka(), reservationRequest.getDatumIsteka(),
                    reservationService.getDifferenceDays(reservationRequest.getDatumPocetka(), reservationRequest.getDatumIsteka()) * apartmentService.getApartmentById(reservationRequest.getApartmentId()).getPricePerNight()
            ));
            model.put("odgovor", "Dodato sam");
            return ok(model);
        } else {
            for (Reservation r : listica) {
                System.out.println("STA SAD " + r.getDatumPocetka());
                System.out.println("Izgleda je ovo null " +r.getApartment());
                System.out.println(reservationRequest.getApartmentId());
                if (!r.getApartment().getApartmentId().equals(reservationRequest.getApartmentId())) {
                    reservationService.reserveApartment(new Reservation(Id.generate(), apartmentService.getApartmentById(reservationRequest.getApartmentId()),
                            customerService.findCustomerByCustomerId(reservationRequest.getCustomerId()),
                            reservationRequest.getDatumPocetka(), reservationRequest.getDatumIsteka(),
                            reservationService.getDifferenceDays(reservationRequest.getDatumPocetka(), reservationRequest.getDatumIsteka()) * apartmentService.getApartmentById(reservationRequest.getApartmentId()).getPricePerNight()
                    ));
                    model.put("odgovor", "Dodato");
                    return ok(model);
                } else if (r.getApartment().getApartmentId().equals(reservationRequest.getApartmentId())) {
                    if (helperMetodica(r.getDatumPocetka(), r.getDatumIsteka(), reservationRequest.getDatumPocetka(), reservationRequest.getDatumIsteka())) {
                        reservationService.reserveApartment(new Reservation(Id.generate(), apartmentService.getApartmentById(reservationRequest.getApartmentId()),
                                customerService.findCustomerByCustomerId(reservationRequest.getCustomerId()),
                                reservationRequest.getDatumPocetka(), reservationRequest.getDatumIsteka(),
                                reservationService.getDifferenceDays(reservationRequest.getDatumPocetka(), reservationRequest.getDatumIsteka()) * apartmentService.getApartmentById(reservationRequest.getApartmentId()).getPricePerNight()
                        ));
                        break;
                    } else {
                        model.put("odgovor", "Taj apartman je vec rezervisan u tom periodu");
                        return ok(model);
                    }
                }
            }
        }

        model.put("odgovor", "All fine");
        return ok(model);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable String id) {
        reservationService.deleteReservation(reservationService.findByReservationId(id));
    }

    @GetMapping("/showAll/{id}")
    public List<Reservation> getReservations(@PathVariable String id) {
        System.out.println("customer i njegov id" + id);

        return reservationService.findReservationsByCustomer(customerService.findCustomerByCustomerId(id));
    }

    private boolean helperMetodica(Date firstStartDate, Date firstEndDate, Date secondStartDate, Date secondEndDate) {

        System.out.println();
        if ((firstStartDate.before(secondStartDate) && (firstEndDate.before(secondEndDate) && firstEndDate.after(secondStartDate)))
                || (firstStartDate.before(secondStartDate) && (secondEndDate.before(firstEndDate) && secondEndDate.after(secondStartDate)))
                || (secondStartDate.before(firstStartDate) && (secondEndDate.before(firstEndDate) && secondEndDate.after(firstStartDate)))
                || (secondStartDate.before(firstStartDate) && (firstEndDate.before(secondEndDate)) && firstEndDate.after(firstStartDate))) {
            return false;
        }
        return true;
    }
}
