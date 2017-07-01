package com.apress.springrecipes.reactive.court.web;

import com.apress.springrecipes.reactive.court.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservationQuery")
public class ReservationQueryController {

    private final ReservationService reservationService;

    public ReservationQueryController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public void setupForm() {
    }

    @GetMapping(params = "courtName")
    public String sumbitForm(@RequestParam("courtName") String courtName, Model model) {

        model.addAttribute("reservations", reservationService.query(courtName));
        return "reservationQuery";
    }

}
