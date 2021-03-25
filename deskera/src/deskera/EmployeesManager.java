package deskera;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class EmployeesManager {

  /**
   * Implement EmployeesManager to manage all employees of a company
   *
   */

  /**
   * Adds an Employee
   *
   * @param employee
   * @return
   */
	List<Employee>list=new ArrayList<Employee>();
  String addEmployee(Employee employee) {
    list.add(employee);
    return employee.getEmployeeId();
  }

  /**
   * Finds an Employee
   *
   * @param employeeId
   * @return
   */
  Employee findEmployee(String employeeId) {
    for (Employee employee : list) {
		if(employee.getEmployeeId().equals(employeeId))
			return employee;
			
	}
    return null;
  }

  /**
   * Find all Employee who are older than X years
   * @param years
   * @return
   */
  Collection<Employee> findEmployee(int years) {
    List<Employee>l=new ArrayList<Employee>();
    for (Employee employee : list) {
		if(employee.getAgeInYears()==years)
			l.add(employee);
	}
	  return l;
  }

  /**
   * Removes an employee
   *
   * @param employeeId
   * @return
   */
  boolean removeEmployee(String employeeId) {
    for (Employee employee : list) {
    	if(employee.getEmployeeId().equals(employeeId))
    	{
    		list.remove(employee);
    		return true;
    	}
	}
    return false;
  }

  /**
   * Lists all Employees
   *
   * @return
   */
  Collection<Employee> listEmployees() {
    
    return list;
  }
}

class Employee {

  private int ageInYears;
  private int ageInMonths;
  private String birthDate;
  private String firstName;
  private String lastName;

  private String employeeId="0";

  public Employee(String fullName, String birthDate) {
   String[] str=fullName.split(" ");
   this.firstName=str[0];
   this.lastName=str[1];
   this.birthDate=birthDate;
   this.employeeId=String.valueOf(Integer.valueOf(employeeId)+1);
   SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
   try {
	Date date=formatter.parse(birthDate);
	Instant instant = date.toInstant();
	   ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
	   LocalDate givenDate = zone.toLocalDate();
	   Period period = Period.between(givenDate, LocalDate.now());
	   this.ageInMonths=period.getMonths();
	   this.ageInYears=period.getYears();
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   
  }

  public int getAgeInYears() {
    return ageInYears;
  }

  public int getAgeInMonths() {
    return ageInMonths;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public String getBirthDate() {
    return birthDate;
  }
}