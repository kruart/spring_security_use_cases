package com.oreilly.security.web.controllers;

import com.oreilly.security.domain.entities.Appointment;
import com.oreilly.security.domain.entities.AutoUser;
import com.oreilly.security.domain.repositories.AppointmentRepository;
import com.oreilly.security.domain.repositories.AutoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller()
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private AutoUserRepository autoUserRepository;
	
	@ModelAttribute
	public Appointment getAppointment(){
		return new Appointment();
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getAppointmentPage(){
		return "appointments";
	}

	@ResponseBody
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public List<Appointment> saveAppointment(@ModelAttribute Appointment appointment){
		AutoUser user= (AutoUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		appointment.setUser(user);
		appointment.setStatus("Initial");
		appointmentRepository.save(appointment);
		return this.appointmentRepository.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/all")
	public List<Appointment> getAppointments(){
		return this.appointmentRepository.findAll();
	}

	@RequestMapping("/{appointmentId}")
	public String getAppointment(@PathVariable("appointmentId") Long appointmentId, Model model){
		Appointment appointment = appointmentRepository.findOne(appointmentId);
		model.addAttribute("appointment", appointment);
		return "appointment";
	}
	
}