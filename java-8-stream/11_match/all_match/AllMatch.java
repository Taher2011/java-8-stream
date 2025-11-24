package all_match;

import java.util.Arrays;
import java.util.List;

public class AllMatch {

	private static void checkAllEmployeesSalaryGreaterThan30K(List<Employee> employees) {
		boolean isAllEmployeesSalaryGreaterThan30K = employees.stream().allMatch(e -> e.getSalary() > 30000);
		if (isAllEmployeesSalaryGreaterThan30K) {
			System.out.println("yes all employees salary greater than 30K");
		} else {
			System.out.println("no all employees salary greater than 30K");
		}
	}

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee("John", "Male", 30, 70000),
				new Employee("Emma", "Female", 25, 50000), new Employee("Alex", "Male", 45, 90000),
				new Employee("Sophia", "Female", 33, 85000), new Employee("Mark", "Male", 28, 95000));

		// Check all employees salary > 30000
		checkAllEmployeesSalaryGreaterThan30K(employees);
		System.out.println(
				"==============================================================================================");
	}

}
