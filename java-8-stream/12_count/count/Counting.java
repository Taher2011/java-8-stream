package count;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Counting {

	private static void findTotalNumberOfStudents(List<Student> students) {
		long count = students.stream().count();
		System.out.println("total number of students : " + count);
	}

	private static void findCountOfMaleAndFemaleEmployees(List<Employee> employees) {
		Map<String, Long> map = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting()));
		map.forEach((k, v) -> {
			System.out.println("count of " + k + " employees : " + v);
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

		// Find total number of students.
		findTotalNumberOfStudents(students);
		System.out.println(
				"==============================================================================================");

		// Find count of male and female employees.
		findCountOfMaleAndFemaleEmployees(employees);
		System.out.println(
				"==============================================================================================");

	}

}
