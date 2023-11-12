package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.entity.Employee;
import com.employee.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String welcomePage(ModelMap modelMap, @RequestParam String userId, @RequestParam String password) {
		if(userId.equals("test@sunbasedata.com") && password.equals("Test@123")) {
//			modelMap.put("userId", userId);
			return "redirect:/";
		}
		
		modelMap.put("errorMsg","Invalid userId or password");
		return "login";
			}

	@GetMapping("/")
	public String home(Model m) {
	List<Employee> emps= empService.getAll();
	m.addAttribute("emps",emps);
		return "index";		
	}
	
	@GetMapping("/addCustomer")
	public String add_emp() {
		return "Add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee employee, HttpSession session) {
		System.out.println(employee);
		empService.addEmp(employee);
		session.setAttribute("msg","Employee Added Successfully");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e =empService.getEmpId(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		empService.addEmp(e);
		session.setAttribute("msg", "Employee data Update Successfully");
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {	
		empService.deleteEmp(id);
		session.setAttribute("msg", "Employee data deleted Successfully");

		return "redirect:/";
		}
}
