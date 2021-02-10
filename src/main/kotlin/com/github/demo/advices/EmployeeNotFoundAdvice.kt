package com.github.demo.advices

import com.github.demo.controller.exceptions.EmployeeNotFoundException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class EmployeeNotFoundAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(
        EmployeeNotFoundException::class
    )
    fun handleEmployeeNotFoundException(exception: EmployeeNotFoundException): String? {
        return exception.message
    }
}