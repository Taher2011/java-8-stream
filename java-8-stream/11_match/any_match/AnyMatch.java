package any_match;

import java.util.Arrays;
import java.util.List;

public class AnyMatch {

	private static void checkIfAnyStudentIsFromNewYork(List<Student> students) {
		boolean isAnyStudentFromNewYork = students.stream().anyMatch(s -> s.getCity().equalsIgnoreCase("new york"));
		if (isAnyStudentFromNewYork) {
			System.out.println("yes student from new york present");
		} else {
			System.out.println("no student from new york present");
		}
	}

	public static void main(String[] args) {

		List<Student> students = Arrays.asList(
				new Student(1, "Yalice", "Smith", 20, "Female", "Computer Science", 2022, "New York", 69),
				new Student(2, "Bob", "Johnson", 21, "Male", "Mechanical Engineering", 2021, "Chicago", 75),
				new Student(3, "Annie", "Williams", 22, "Female", "Electrical Engineering", 2020, "San Francisco", 42),
				new Student(4, "George", "Brown", 23, "Male", "Mechanical Engineering", 2019, "New York", 44),
				new Student(5, "Ava", "Davis", 19, "Female", "Computer Science", 2023, "Boston", 53),
				new Student(6, "Tom", "Mathew", 21, "Male", "Mechanical Engineering", 2019, "Washington", 68));

		// Check if any student is from New York
		checkIfAnyStudentIsFromNewYork(students);
		System.out.println(
				"==============================================================================================");
	}

}
