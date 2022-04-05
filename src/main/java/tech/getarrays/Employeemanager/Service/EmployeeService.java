package tech.getarrays.Employeemanager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.Employeemanager.model.Employee;
import tech.getarrays.Employeemanager.repo.EmplpyeeRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
private final EmplpyeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmplpyeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee emp){
        emp.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(emp);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee emp){
        return employeeRepo.save(emp);
    }
    public Optional<Employee> findEmployeeById(long id){
        return employeeRepo.findById(id);
    }
    public void deleteEmployee(long id){
      employeeRepo.deleteById(id);
    }
}
