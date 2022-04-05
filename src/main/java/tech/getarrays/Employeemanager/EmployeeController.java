package tech.getarrays.Employeemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.Employeemanager.Service.EmployeeService;
import tech.getarrays.Employeemanager.model.Employee;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

private final EmployeeService empService;

     @Autowired
    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
         List<Employee> emps = empService.getAllEmployees();
         return  new ResponseEntity<>(emps, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable long id){
         Optional<Employee> emp = empService.findEmployeeById(id);
         return new ResponseEntity<Optional<Employee>>(emp,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee (@RequestBody Employee emp ){
         Employee newEmp = empService.addEmployee(emp);
         return new ResponseEntity<>(emp,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee (@RequestBody Employee emp ){
        Employee newEmp = empService.updateEmployee(emp);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee (@PathVariable long id){
        empService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
