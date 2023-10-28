package edu.jlu.MyBatis.TestMapper;

import edu.jlu.MyLombok.Employee;

import java.util.List;

public interface TestMapper {
    List<Employee> selectEmployee();
}
