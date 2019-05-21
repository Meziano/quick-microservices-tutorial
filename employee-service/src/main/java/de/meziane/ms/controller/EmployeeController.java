package de.meziane.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.meziane.ms.model.Employee;
import de.meziane.ms.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	// private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeRepository repository;
	
	@PostMapping("/")
	public Employee add(@RequestBody Employee employee) {
		// LOGGER.info("Employee add: {}", employee);
		return repository.add(employee);
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") Long id) {
		// LOGGER.info("Employee find: id={}", id);
		return repository.findById(id);
	}
	
	@GetMapping("/")
	public List<Employee> findAll() {
		// LOGGER.info("Employee find");
		return repository.findAll();
	}
	
	@GetMapping("/department/{departmentId}")
	public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
		// LOGGER.info("Employee find: departmentId={}", departmentId);
		return repository.findByDepartment(departmentId);
	}
	
	@GetMapping("/organisation/{organisationId}")
	public List<Employee> findByOrganisation(@PathVariable("organisationId") Long organisationId) {
		// LOGGER.info("Employee find: organisationId={}", organisationId);
		return repository.findByOrganization(organisationId);
	}
	

}
