package com.metropolitan.booking.manager;

import com.metropolitan.booking.apartment.Apartment;
import com.metropolitan.booking.apartment.ApartmentService;
import com.metropolitan.booking.configuration.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping(value = "/showAll")
    public List<Manager> getAllMenadzeri() {
        return managerService.getManagerList();
    }

    @PostMapping(value = "/add")
    public void createMenadzer(@RequestBody Manager manager) {
        managerService.registerManager(new Manager(Id.generate(), manager.getPpUsername(), manager.getPpPassword(),
                manager.getUsername(), manager.getPassword(), manager.getFirstName(), manager.getLastName(), manager.getPhoneNumber()));
    }

    @GetMapping("/info")
    public ResponseEntity currentManager(@AuthenticationPrincipal UserDetails userDetails) {
        Map<Object, Object> model = new HashMap<>();
        try {
            Manager manager = managerService.getManagerByCredentials(userDetails.getUsername(), userDetails.getPassword());
            manager.setPassword(passwordEncoder.encode(manager.getPassword()));
            model.put("manager", manager);
            return ok(model);
        } catch (Exception e){
            e.printStackTrace();
        }
        model.put("error", "znaci errorka");
        return ok(model);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteManager(@PathVariable String id) {
        List<Apartment> lista = apartmentService.getApartmentsByMnaager(managerService.findByManagerId(id));
        managerService.deleteManager(managerService.findByManagerId(id));
        for(Apartment a : lista){
            apartmentService.removeApapartment(a);
        }
    }
}
