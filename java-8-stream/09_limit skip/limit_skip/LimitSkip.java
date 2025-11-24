package limit_skip;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LimitSkip {

	private static void findTop3HighestPaidEmployees(List<Employee> employees) {
		System.out.println("top3 3 highest paid employees : ");
		List<Employee> top3HighestPaidEmployees = employees.stream().sorted((e1, e2) -> {
			if (e1.getSalary() > e2.getSalary()) {
				return -1;
			} else if (e1.getSalary() < e2.getSalary()) {
				return 1;
			}
			return 0;
		}).limit(3).collect(Collectors.toList());
		top3HighestPaidEmployees.stream().forEach(e -> {
			System.out.println(e.getName() + " " + e.getSalary());
		});
	}

	private static void find2ndHighestRankStudent(List<Student> students) {
		students.stream().sorted((s1, s2) -> {
			if (s1.getRank() < s2.getRank()) {
				return 1;
			} else if (s1.getRank() > s2.getRank()) {
				return -1;
			}
			return 0;
		}).skip(1).findFirst().ifPresent(
				s -> System.out.println("student " + s.getFirstName() + " with 2nd highest rank : " + s.getRank()));
	}

	private static void getFirst5EmployeesBySalary(List<Employee> employees) {
		System.out.println("first 5 employees sorted by salary are : ");
		List<Employee> first5EmployeesBySalary = employees.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(5)
				.collect(Collectors.toList());
		first5EmployeesBySalary.stream().forEach(e -> {
			System.out.println(e.getName() + " " + e.getSalary());
		});
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

		// Find top 3 highest-paid employees
		findTop3HighestPaidEmployees(employees);
		System.out.println(
				"==============================================================================================");

		// Find 2nd highest rank student
		find2ndHighestRankStudent(students);
		System.out.println(
				"==============================================================================================");

		// Get first 5 employees sorted by salary
		getFirst5EmployeesBySalary(employees);
		System.out.println(
				"==============================================================================================");
	}

}
