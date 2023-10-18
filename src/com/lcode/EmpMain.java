package com.lcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList<Employee>();
        
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
    
	System.out.println("How many male and female employees are there in the organization?");
	Map<String, Long> result=	employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
	System.out.println(result);
	
	
	System.out.println("Print the name of all departments in the organization?");
	employeeList.stream().map(Employee::getDepartment).distinct().forEach(n->System.out.println(n));
	
	System.out.println("What is the average age of male and female employees?");
	Map<String, Double> averageage=   employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
	System.out.println(averageage);
	
	System.out.println("Get the details of highest paid employee in the organization?");
	Optional<Employee> highestPaidEmployee = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
	Employee employee= highestPaidEmployee.get();
	System.out.println(employee.toString());
	
	System.out.println("Get the names of all employees who have joined after 2015?");
	employeeList.stream().filter(n->n.getYearOfJoining()>2015).forEach(n->System.out.println(n.getName()));
	
	System.out.println("Count the number of employees in each department?");
	Map<String, Long> emp=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
    Set<Entry<String, Long>> entryset=emp.entrySet() ;
    for (Entry<String, Long> entry:entryset) {
	System.out.println(entry.getKey()+"-->"+entry.getValue());
	}
	
	System.out.println("What is the average salary of each department?");
	Map<String,Double> average =  employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
	System.out.println(average);
	
	System.out.println("Get the details of youngest male employee in the product development department?");
	Optional<Employee> youngestEmployee=employeeList.stream().filter(n->n.getDepartment().equalsIgnoreCase("product development")&&n.getGender().equalsIgnoreCase("male")).collect(Collectors.minBy(Comparator.comparing(Employee::getAge)));
	Employee employee2=youngestEmployee.get();
	System.out.println(employee2.getName()+" "+employee2.getDepartment());
	
	System.out.println("Who has the most working experience in the organization?");
	Optional<Employee> experiencedEmployee= employeeList.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getYearOfJoining)));
	Employee employee3=experiencedEmployee.get();
	System.out.println(employee3.getName());
	
	System.out.println("How many male and female employees are there in the sales and marketing team?");
	Map<String, Long > noOfEmployees=employeeList.stream().filter(e -> e.getDepartment()=="Sales And Marketing").collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
	System.out.println(noOfEmployees);
	
	System.out.println("What is the average salary of male and female employees?");
	Map<String, Double>avgsalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
	System.out.println(avgsalary);
	
	System.out.println(" List down the names of all employees in each department?");
	Map<String, Map<String, List<Employee>>> names = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.groupingBy(Employee::getName)));
	System.out.println(names);
	
	System.out.println("What is the average salary and total salary of the whole organization?");
	DoubleSummaryStatistics summary = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
	System.out.println(summary);
	
	System.out.println("Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.");
	employeeList.stream().filter(e-> e.getAge()<=25).forEach(n-> System.out.println(n.getName()));
	
	System.out.println(" Who is the oldest employee in the organization? What is his age and which department he belongs to?");
	
		
	}
	
	
	
	
	
}
