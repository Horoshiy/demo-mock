package com.github.demo

import com.github.demo.repository.EmployeeRepository
import org.springframework.boot.CommandLineRunner
import com.github.demo.model.Employee
import com.github.demo.LoadDB
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Consumer

@Configuration
class LoadDB {
    @Bean
    fun initDatabase(employeeRepository: EmployeeRepository): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            employeeRepository.save(Employee(id = 1, name = "Bilbo", salary = 20000, age = 20))
            employeeRepository.save(Employee(id = 2, name = "Frodo", salary = 30000, age = 30))
            employeeRepository.findAll().forEach(Consumer { employee: Employee ->
                log.info(
                    "Preloaded $employee"
                )
            })
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(LoadDB::class.java)
    }
}