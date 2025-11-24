package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {

	private static void sortStudentsByRankApproach1(List<Student> students) {
		System.out.println("students sorted by rank in ascending order : ");
		students.stream().sorted((s1, s2) -> {
			if (s1.getRank() < s2.getRank()) {
				return -1;
			} else if (s1.getRank() > s2.getRank()) {
				return 1;
			}
			return 0;
		}).forEach(System.out::println);
	}

	private static void sortStudentsByRankApproach2(List<Student> students) {
		System.out.println("students sorted by rank in descending order : ");
		students.stream().sorted(Comparator.comparingInt(Student::getRank)).forEach(System.out::println);
	}

	private static void sortStudentsByAge(List<Student> students) {
		System.out.println("students sorted by age in ascending order : ");
		students.stream().sorted((s1, s2) -> {
			if (s1.getAge() < s2.getAge()) {
				return -1;
			} else if (s1.getAge() > s2.getAge()) {
				return 1;
			}
			return 0;
		}).forEach(System.out::println);

	}

	private static void sortEmployeesByHighestSalaryApproach1(List<Employee> employees) {
		System.out.println("employees sorted by highest salary : ");
		employees.stream().sorted((e1, e2) -> {
			if (e1.getSalary() < e2.getSalary()) {
				return 1;
			} else if (e1.getSalary() > e2.getSalary()) {
				return -1;
			}
			return 0;
		}).forEach(System.out::println);
	}

	private static void sortEmployeesByHighestSalaryApproach2(List<Employee> employees) {
		System.out.println("employees sorted by highest salary : ");
		employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				.forEach(System.out::println);
	}

	private static void sortFruitsAlphabetically(List<String> fruits) {
		System.out.println("fruits sorted alphabetically : ");
		fruits.stream().sorted().forEach(System.out::println);
	}

	private static void findSecondHighestRankStudent(List<Student> students) {
		System.out.println("second highest rank student : ");
		Student student = students.stream().sorted(Comparator.comparing(Student::getRank).reversed()).skip(1)
				.findFirst().get();
		System.out.println(student);
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

		// Sort students by rank
		sortStudentsByRankApproach1(students);
		System.out.println(
				"==============================================================================================");

		sortStudentsByRankApproach2(students);
		System.out.println(
				"==============================================================================================");

		// Sort students by age
		sortStudentsByAge(students);
		System.out.println(
				"==============================================================================================");

		// Sort employees by highest salary
		sortEmployeesByHighestSalaryApproach1(employees);
		System.out.println(
				"==============================================================================================");

		sortEmployeesByHighestSalaryApproach2(employees);
		System.out.println(
				"==============================================================================================");

		// Sort fruits alphabetically
		List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date");
		sortFruitsAlphabetically(fruits);
		System.out.println(
				"==============================================================================================");

		// Find second highest rank student (sorted + skip)
		findSecondHighestRankStudent(students);
		System.out.println(
				"==============================================================================================");
	}

}
