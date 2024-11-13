package es.dsw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.dsw.models.Booking;

@Controller
@SessionAttributes("booking")
public class MainController {

	@GetMapping({"/", "/index"})
	public String index(Model model) {
		
		if(!model.containsAttribute("booking")) {
			model.addAttribute("booking", new Booking());
		} 
		
		return "index";
	}
	
	@PostMapping("/confirmacion")
	public String confirmacion(@RequestParam(defaultValue= "0") int numAdults,
							   @RequestParam(defaultValue= "0") int numChildren,
							   @RequestParam String type,
							   @RequestParam String fentrada,
							   @RequestParam String fsalida,
							   Model model) {
		
		Booking booking = new Booking();
		
		// Validación
		if(numAdults == 0) {
			booking.getErrors().add("No ha indicado el número de adultos en la reserva.");
		}
		
		if(fentrada.equals("")) {
			booking.getErrors().add("No ha indicado la fecha de entrada.");
		}
		
		if(fsalida.equals("")) {
			booking.getErrors().add("No ha indicado la fecha de salida.");
		}
		
		if(!booking.getErrors().isEmpty()) {
			booking.setNumAdults(numAdults);
			booking.setNumChildren(numChildren);
			booking.setType(type);
			booking.setfEntrada(fentrada);
			booking.setfSalida(fsalida);
			model.addAttribute("booking", booking);
			return "redirect:/index";
		}
		
		
		booking.setNumAdults(numAdults);
		booking.setNumChildren(numChildren);
		booking.setType(type);
		booking.setfEntrada(fentrada);
		booking.setfSalida(fsalida);
		model.addAttribute("booking", booking);
		
		return "confirmacion";
	}
	
	@GetMapping("end")
	public String end(Model model) {
		
		Booking booking = (Booking) model.getAttribute("booking");
		
		if (booking == null || booking.getfEntrada() == null || booking.getfSalida() == null || booking.getNumAdults() == 0 || booking.getType() == null) {
	        
			if(booking.getErrors().isEmpty()) {
				booking.setErrors("Acceso no autorizado");
			}
			model.addAttribute("booking", booking);
	        return "redirect:/index";
	    }
		
		return "end";
	}
	
}
