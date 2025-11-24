package none_match;

import java.util.Arrays;
import java.util.List;

public class NoneMatch {

	private static void checkNoStudentIsBelow18(List<Student> students) {
		boolean isNoStudentIsBelow18 = students.stream().noneMatch(s -> s.getAge() < 18);
		if (isNoStudentIsBelow18) {
			System.out.println("no student below age 18");
		} else {
			System.out.println("yes, at least one student is below 18");
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

		// Check no student is below 18
		checkNoStudentIsBelow18(students);
		System.out.println(
				"==============================================================================================");
	}

}
