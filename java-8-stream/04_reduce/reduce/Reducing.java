package reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {

	private static void calculateTotalSalary(List<Employee> employees) {
		Optional<Double> totalsal = employees.stream().map(Employee::getSalary).reduce((e1, e2) -> e1 + e2);
		System.out.println("total salary : " + totalsal.get());
	}

	private static void findHighestSalary(List<Employee> employees) {
		Optional<Double> highestSal = employees.stream().map(Employee::getSalary).reduce((e1, e2) -> e1 > e2 ? e1 : e2);
		System.out.println("highest salary : " + highestSal.get());
	}

	private static void concatenateAllNamesToSingleString(List<Student> students) {
		Optional<String> names = students.stream().map(Student::getFirstName).reduce((a, b) -> a + "," + b);
		System.out.println("concatenate all names into a single string : " + names.get());
	}

	private static void findMaxNumberFromList(List<Integer> numbers) {
		Optional<Integer> max = numbers.stream().reduce((a, b) -> a > b ? a : b);
		System.out.println("max number : " + max.get());
	}

	private static void findMinNumberFromList(List<Integer> numbers) {
		Optional<Integer> minNumber = numbers.stream().reduce((a, b) -> a < b ? a : b);
		System.out.println("min number : " + minNumber.get());
	}

	private static void sumOfNumberFromList(List<Integer> numbers) {
		Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
		System.out.println("sum : " + sum.get());
	}

	private static void productOfNumberFromList(List<Integer> numbers) {
		Optional<Integer> product = numbers.stream().reduce((a, b) -> a * b);
		System.out.println("product : " + product.get());
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

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		// Calculate total salary using reduce()
		calculateTotalSalary(employees);
		System.out.println(
				"==============================================================================================");

		// Find highest salary using reduce()
		findHighestSalary(employees);
		System.out.println(
				"==============================================================================================");

		// Concatenate all names into a single string
		concatenateAllNamesToSingleString(students);
		System.out.println(
				"==============================================================================================");

		// Find max number from list
		findMaxNumberFromList(numbers);
		System.out.println(
				"==============================================================================================");

		// Find min number from list
		findMinNumberFromList(numbers);
		System.out.println(
				"==============================================================================================");

		// Find sum of numbers from list
		sumOfNumberFromList(numbers);
		System.out.println(
				"==============================================================================================");

		// Find product of numbers from list
		productOfNumberFromList(numbers);
		System.out.println(
				"==============================================================================================");
	}

}
