package com.github.demo.controller

import com.github.demo.controller.exceptions.EmployeeNotFoundException
import com.github.demo.model.Employee
import com.github.demo.repository.EmployeeRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/employee")
class EmployeeController(val repository: EmployeeRepository) {
    @PostMapping("/create")
    fun createEmployee(@Valid @RequestBody employee: Employee) =
        ResponseEntity.status(HttpStatus.CREATED).body(repository.save(employee))

    @PutMapping("/{id}")
    fun updateEmployee(@PathVariable id: Long, @Valid @RequestBody employee: Employee): ResponseEntity<Employee> {
        val emp = repository.findById(id).map {
            it.name = employee.name
            it.age = employee.age
            it.salary = employee.salary
            it
        }.orElseThrow { EmployeeNotFoundException(id) }

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(emp))
    }

    @GetMapping("/")
    fun getEmployees() = ResponseEntity.status(HttpStatus.OK).body(repository.findAll())

    @GetMapping("/{id}")
    fun getEmployee(@PathVariable id: Long): ResponseEntity<Employee> {
        val emp = repository.findById(id).orElseThrow { EmployeeNotFoundException(id) }
        return ResponseEntity.status(HttpStatus.OK).body(emp)
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: Long) = repository.deleteById(id)

}