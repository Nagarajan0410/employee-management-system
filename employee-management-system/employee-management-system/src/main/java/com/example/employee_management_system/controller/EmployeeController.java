package com.example.employee_management_system.controller;


import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees"; // Return the employee list view
    }

    // Show the create employee form
    @GetMapping("/employees/create")
    public String showCreateEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee()); // Pass an empty Employee object
        return "create-employee"; // Return the create-employee form view
    }

    @GetMapping("/employees/{id}/edit")
    public String showEditEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id); // Fetch the employee by ID
        model.addAttribute("employee", employee); // Pass the employee object to the form
        return "edit-employee"; // Show the edit form
    }

    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
        employee.setId(id); // Ensure the employee ID is set
        employeeService.updateEmployee(employee); // Save the updated employee to the database
        return "redirect:/employees"; // Redirect to the employee list page after update
    }

    @GetMapping("/employees/{id}/delete")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id); // Delete the employee by ID
        return "redirect:/employees"; // Redirect to the employee list page after deletion
    }

    @PostMapping("/employees")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee); // Save the new employee
        return "redirect:/employees"; // Redirect to the employee list page
    }

    @GetMapping("/employees/search")
    public String searchEmployees(@RequestParam("searchQuery") String searchQuery, Model model) {
        List<Employee> employees = employeeService.searchEmployeesByName(searchQuery);
        model.addAttribute("employees", employees);
        return "employees"; // Return the employee list view with search results
    }

}
