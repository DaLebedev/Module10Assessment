package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Pizza;
import dmacc.beans.Toppings;
import dmacc.repository.PizzaRepository;

@Controller
public class PizzaController {
	@Autowired
	PizzaRepository repo;
	
	@GetMapping({"/", "viewAll"})
	public String viewAllPizzas(Model model) {
	    if (repo.findAll().isEmpty()) {
	        return addNewPizza(model); 
	    } else {
	        model.addAttribute("pizza", repo.findAll());
	        return "results";
	    }
	}
	
	@GetMapping("/inputPizza")
	public String addNewPizza(Model model) {
		Pizza p = new Pizza();
		Toppings t = new Toppings();
		p.setToppings(t);
		model.addAttribute("newPizza", p);
		return "inputpizza";
	}
	
	@PostMapping("/inputPizza")
	public String addNewPizza(@ModelAttribute Pizza p, Model model) {
		repo.save(p);
		return viewAllPizzas(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdatePizza(@PathVariable("id") long id, Model model) {
		Pizza p = repo.findById(id).orElse(null);
		Toppings t = p.getToppings();
		p.setToppings(t);
		model.addAttribute("newPizza", p);
		return "inputpizza";
	}
	
	@PostMapping("/update/{id}")
	public String revisePizza(Pizza p, Model model) {
		repo.save(p);
		return viewAllPizzas(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deletePizza(@PathVariable("id") long id, Model model) {
		Pizza p = repo.findById(id).orElse(null);
		repo.delete(p);
		return viewAllPizzas(model);
		
	}
	
	
}
