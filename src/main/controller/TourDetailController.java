package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import main.model.Tour;
import main.model.TourDetail;
import main.service.TourDetailService;
import main.service.TourService;

@Controller
public class TourDetailController {
	
	@Autowired
	private TourService tourService;
	
	@Autowired
	private TourDetailService tourDetailService;
	
	@GetMapping("/showTourDetail/{tourId}")
	public String showTourDetaul(@PathVariable long tourId,Model model) {
		Tour tour = tourService.getById(tourId);
		if (tour != null) {
			tourService.addTourDetailIfNotExists(tour);
			model.addAttribute("tour", tour);
			return "tour-detail";
		}
		return "redirect:/showOffer";
	}
	
	
	@GetMapping("/editTourDetail/{tourId}")
	public String editTourDetail(@PathVariable long tourId, Model model) {
		Tour tour = tourService.getById(tourId);
		if(tour != null) {
			tourService.addTourDetailIfNotExists(tour);
			model.addAttribute("tourDetail", tour.getTourDetail());
			return "form-tour-detail";
		}
		return "redirect:/showOffer";
	}
	
	@PostMapping("/processFormTourDetail")
	public String processTourDetailData(@ModelAttribute TourDetail tourDetail) {
		tourDetailService.saveOrUpdate(tourDetail);
		return "redirect:/showOffer";
	}

}
