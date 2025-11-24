package groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingBy {

	private static void groupStudentsByDepartmentName(List<Student> students) {
		Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
		map.forEach((k, v) -> {
			System.out.print("'" + k + "' department with students [");
			String names = v.stream().map(Student::getFirstName).collect(Collectors.joining(","));
			System.out.print(names + "]");
			System.out.println();
		});
	}

	private static void countStudentsInEachDepartment(List<Student> students) {
		Map<String, Long> map = students.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
		map.forEach((k, v) -> {
			System.out.print("'" + k + "' department with student counts : " + v);
			System.out.println();
		});
	}

	private static void averageAgeByGender(List<Employee> employees) {
		Map<String, Double> map = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getGender(), Collectors.averagingDouble(Employee::getAge)));
		map.forEach((k, v) -> {
			System.out.print("average age of " + k + " employee is " + v);
			System.out.println();
		});
	}

	private static void averageRankByDepartment(List<Student> students) {
		Map<String, Double> map = students.stream().collect(
				Collectors.groupingBy(s -> s.getDepartmantName(), Collectors.averagingDouble(Student::getRank)));
		map.forEach((k, v) -> {
			System.out.print("average rank in '" + k + "' department is " + v);
			System.out.println();
		});
	}

	private static void findHighestRankInEachDepartment(List<Student> students) {
		Map<String, Optional<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getDepartmantName,
				Collectors.maxBy(Comparator.comparingInt(Student::getRank))));
		map.forEach((k, v) -> {
			System.out.print("highest rank in '" + k + "' department is " + v.get().getRank());
			System.out.println();
		});
	}

	private static void groupEmployeesByGender(List<Employee> employees) {
		Map<String, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(e -> e.getGender()));
		map.forEach((k, v) -> {
			System.out.print("'" + k + "' employees [");
			String names = v.stream().map(Employee::getName).collect(Collectors.joining(","));
			System.out.print(names + "]");
			System.out.println();
		});
	}

	private static void groupStringsByLength(List<String> fruits) {
		Map<Integer, List<String>> map = fruits.stream().filter(f -> f != null)
				.collect(Collectors.groupingBy(f -> f.length()));
		map.forEach((k, v) -> {
			System.out.print("'" + k + "' [");
			String fruit = v.stream().collect(Collectors.joining(","));
			System.out.print(fruit + "]");
			System.out.println();
		});
	}

	private static void groupNumbersInEvenOdd(List<Integer> numbers) {
		Map<String, List<Integer>> map = numbers.stream()
				.collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd"));
		map.forEach((k, v) -> {
			System.out.println("list of " + k + " numbers : " + v);
		});
	}

	private static void groupStringsByFirstLetter(List<String> fruits) {
		Map<Character, List<String>> map = fruits.stream().collect(Collectors.groupingBy(f -> f.charAt(0)));
		map.forEach((k, v) -> {
			System.out.println(k + " -> " + v);
		});
	}

	private static void filterDuplicateNumbersUsingCountingApproach1(List<Integer> list) {
		Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(l -> l, Collectors.counting()));
		List<Integer> duplicateNumbers = new ArrayList<>();
		map.forEach((k, v) -> {
			if (v.longValue() > 1) {
				duplicateNumbers.add(k);
			}
		});
		System.out.println("duplicate numbers are : " + duplicateNumbers);
	}

	private static void filterDuplicateNumbersUsingCountingApproach2(List<Integer> list) {
		List<Integer> duplicateNumbers = list.stream().collect(Collectors.groupingBy(l -> l, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
		System.out.println("duplicate numbers are : " + duplicateNumbers);
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

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		List<String> fruits = Arrays.asList("apple", "banana", "cherry", "avocado", "blueberry", "apricot");

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 3, 2, 1, 5);

		// Group students by department name
		groupStudentsByDepartmentName(students);
		System.out.println(
				"==============================================================================================");

		// Count students in each department
		countStudentsInEachDepartment(students);
		System.out.println(
				"==============================================================================================");

		// Average age of male/female
		averageAgeByGender(employees);
		System.out.println(
				"==============================================================================================");

		// Average rank per department
		averageRankByDepartment(students);
		System.out.println(
				"==============================================================================================");

		// Find highest rank in each department
		findHighestRankInEachDepartment(students);
		System.out.println(
				"==============================================================================================");

		// Group employees by gender
		groupEmployeesByGender(employees);
		System.out.println(
				"==============================================================================================");

		// Group strings by length
		groupStringsByLength(fruits);
		System.out.println(
				"==============================================================================================");

		// Group numbers into even/odd
		groupNumbersInEvenOdd(numbers);
		System.out.println(
				"==============================================================================================");

		// Group strings by first letter
		groupStringsByFirstLetter(fruits);
		System.out.println(
				"==============================================================================================");

		// Filter duplicate numbers (using counting > 1)
		filterDuplicateNumbersUsingCountingApproach1(list);
		System.out.println(
				"==============================================================================================");

		// Filter duplicate numbers (using counting > 1)
		filterDuplicateNumbersUsingCountingApproach2(list);
		System.out.println(
				"==============================================================================================");
	}

}
