package partitioningBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningBy {

	private static void partitionNumbersInToEvenOdd(List<Integer> numbers) {
		Map<Boolean, List<Integer>> map = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println("even numbers list : " + map.get(true));
		System.out.println("odd  numbers list : " + map.get(false));
	}

	private static void partitionStudentsByAgeGrtOrLessThan20(List<Student> students) {
		Map<Boolean, List<Student>> map = students.stream().collect(Collectors.partitioningBy(s -> s.getAge() > 20));
		map.forEach((k, v) -> {
			String name = "";
			if (k) {
				System.out.print("students greater than age 20 : ");
			} else {
				System.out.print("students smaller than age 20 : ");

			}
			name = map.get(k).stream().map(s -> s.getFirstName() + " " + s.getAge()).collect(Collectors.joining(", "));
			System.out.print(name);
			System.out.println();
		});
	}

	private static void partitionEmployeesWithSalaryGreaterThan80K(List<Employee> employees) {
		Map<Boolean, List<Employee>> map = employees.stream()
				.collect(Collectors.partitioningBy(e -> e.getSalary() > 80000));
		map.forEach((k, v) -> {
			String name = "";
			if (k) {
				System.out.print("employees with salary greater than 80K : ");
			} else {
				System.out.print("employees with salary lesser  than 80K : ");

			}
			name = map.get(k).stream().map(s -> s.getName() + " " + s.getSalary()).collect(Collectors.joining(", "));
			System.out.print(name);
			System.out.println();
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

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		// Partition numbers into even & odd
		partitionNumbersInToEvenOdd(numbers);
		System.out.println(
				"==============================================================================================");

		// Partition students by age > 20 vs <= 20
		partitionStudentsByAgeGrtOrLessThan20(students);
		System.out.println(
				"==============================================================================================");

		// Partition employees with salary > 80000
		partitionEmployeesWithSalaryGreaterThan80K(employees);
		System.out.println(
				"==============================================================================================");
	}

}
