package filter;

import java.util.Arrays;
import java.util.List;

public class Filtering {

	private static void firstNameStartsWithA(List<Student> students) {
		System.out.println("students name start with 'A' :");
		students.stream().filter(s -> s.getFirstName().startsWith("A")).forEach(System.out::println);
	}

	private static void findStudentsAgeLessThan22(List<Student> students) {
		System.out.println("students age less than 22 :");
		students.stream().filter(s -> s.getAge() < 22).forEach(System.out::println);
	}

	private static void findStudentsRankBetween60and100(List<Student> students) {
		System.out.println("students rank between 60 and 100 :");
		students.stream().filter(s -> s.getRank() > 60 && s.getRank() < 100).forEach(System.out::println);
	}

	private static void findStudentsStayinginNewYorkandSortbyName(List<Student> students) {
		System.out.println("students staying in NewYork :");
		students.stream().filter(s -> s.getCity().equalsIgnoreCase("new york")).forEach(System.out::println);
	}

	private static void findEmployeesHavingSalaryGreaterThan70K(List<Employee> employees) {
		System.out.println("employees having salary greater than 70K :");
		employees.stream().filter(e -> e.getSalary() > 70000).forEach(System.out::println);
	}

	private static void filterOutNullValuesFromList() {
		System.out.println("non-null values are : ");
		List<String> fruits = Arrays.asList("apple", null, "banana", "cherry", null, "date");
		fruits.stream().filter(f -> f != null).forEach(System.out::println);
	}

	private static void filterFruitsWhoseLengthGreaterThan5() {
		System.out.println("fruits whose length > 5 : ");
		List<String> fruits = Arrays.asList("apple", null, "banana", "cherry", null, "date");
		fruits.stream().filter(f -> f != null).filter(f -> f.length() > 5).forEach(System.out::println);
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

		// Find students whose first name starts with A
		firstNameStartsWithA(students);
		System.out.println(
				"==============================================================================================");

		// Find students age < 22
		findStudentsAgeLessThan22(students);
		System.out.println(
				"==============================================================================================");

		// Find students whose rank is between 60 and 100
		findStudentsRankBetween60and100(students);
		System.out.println(
				"==============================================================================================");

		// Find students living in New York
		findStudentsStayinginNewYorkandSortbyName(students);
		System.out.println(
				"==============================================================================================");

		// Filter employees having salary > 70000
		findEmployeesHavingSalaryGreaterThan70K(employees);
		System.out.println(
				"==============================================================================================");

		// Filter out null values from a list
		filterOutNullValuesFromList();
		System.out.println(
				"==============================================================================================");

		// Filter fruits whose length > 5
		filterFruitsWhoseLengthGreaterThan5();
		System.out.println(
				"==============================================================================================");
	}

}
