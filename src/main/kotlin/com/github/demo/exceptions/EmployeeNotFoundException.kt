package com.github.demo.controller.exceptions

import java.lang.RuntimeException

class EmployeeNotFoundException(id: Long) : RuntimeException("Could not find employee with id $id")