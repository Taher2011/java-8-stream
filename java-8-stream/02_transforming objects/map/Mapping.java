package map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Mapping {

	private static void getAllDepartmentsNamesList(List<Student> students) {
		System.out.println("list of all department names :");
		students.stream().map(s -> s.getDepartmantName()).distinct().forEach(System.out::println);
	}

	private static void getAllEmployeesNamesList(List<Employee> employees) {
		System.out.println("list of all employees names :");
		employees.stream().map(e -> e.getName()).forEach(System.out::println);
	}

	private static void getAllEmployeeSalariesList(List<Employee> employees) {
		System.out.println("convert list of employees → list of salaries :");
		employees.stream().map(e -> e.getSalary()).forEach(System.out::println);
	}

	private static void squareEveryNumberInList(List<Integer> numbers) {
		System.out.println("square of every numbers :");
		numbers.stream().map(n -> n * n).forEach(System.out::println);
	}

	private static void getEmployeeNamesListInUppercase(List<Employee> employees) {
		System.out.println("employees name in uppercase :");
		employees.stream().map(e -> e.getName().toUpperCase()).forEach(System.out::println);
	}

	private static void convertEmployeeToEMployeeDTO(List<Employee> employees) {

		@AllArgsConstructor
		@Setter
		@Getter
		@ToString
		class EmployeeDTO {
			private String name;
			private String gender;
			private int age;
			private double salary;
		}
		List<EmployeeDTO> employeeDTOs = employees.stream()
				.map(e -> new EmployeeDTO(e.getName(), e.getGender(), e.getAge(), e.getSalary()))
				.collect(Collectors.toList());
		System.out.println("converting list of employees to list of employees DTO");
		employeeDTOs.forEach(System.out::println);
	}

	public static void main(String[] args) {

		List<Student> students = Arrays.asList(
				new Student(1, "Yalice", "Smith", 20, "Female", "Computer Science", 2022, "New York", 69),
				new Student(2, "Bob", "Johnson", 21, "Male", "Mechanical Engineering", 2021, "Chicago", 75),
				new Student(3, "Annie", "Williams", 22, "Female", "Electrical Engineering", 2020, "San Francisco", 42),
				new Student(4, "George", "Brown", 23, "Male", "Mechanical Engineering", 2019, "New York", 44),
				new Student(5, "Ava", "Davis", 19, "Female", "Computer Science", 2023, "Boston", 53),
				new Student(6, "Tom", "Mathew", 21, "Male", "Mechanical Engineering", 2019, "Washington", 68));

		List<Employee> employees = Arrays.asList(new Employee("John", "Male", 30, 70000),
				new Employee("Emma", "Female", 25, 50000), new Employee("Alex", "Male", 45, 90000),
				new Employee("Sophia", "Female", 33, 85000), new Employee("Mark", "Male", 28, 95000));

		// Get list of all department names
		getAllDepartmentsNamesList(students);
		System.out.println(
				"==============================================================================================");

		// Get list of employee names
		getAllEmployeesNamesList(employees);
		System.out.println(
				"==============================================================================================");

		// Get list of employees salaries
		getAllEmployeeSalariesList(employees);
		System.out.println(
				"==============================================================================================");

		// Square every number in a list
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		squareEveryNumberInList(numbers);
		System.out.println(
				"==============================================================================================");

		// Get list of employees names into uppercase
		getEmployeeNamesListInUppercase(employees);
		System.out.println(
				"==============================================================================================");

		// Convert list of employees to list of employees DTO
		convertEmployeeToEMployeeDTO(employees);
		System.out.println(
				"==============================================================================================");
	}

}
