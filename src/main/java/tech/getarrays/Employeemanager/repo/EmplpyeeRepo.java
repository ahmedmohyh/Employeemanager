package tech.getarrays.Employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.Employeemanager.model.Employee;

public interface EmplpyeeRepo extends JpaRepository<Employee,Long> {
}
