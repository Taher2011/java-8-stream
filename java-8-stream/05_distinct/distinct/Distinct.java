package distinct;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Distinct {

	private static void removeDuplicatesFromList(List<Integer> list) {
		List<Integer> removeDuplicates = list.stream().distinct().collect(Collectors.toList());
		System.out.println(removeDuplicates);
	}

	private static void removeDuplicateDepartmentNames(List<Student> students) {
		Optional<String> departmentNames = students.stream().map(Student::getDepartmantName).distinct()
				.reduce((a, b) -> a + "," + b);
		System.out.println("Unique department names : " + departmentNames.get());
	}

	private static void removeDuplicateCharactersFromString(String string) {
		String removeDuplicate = string.chars().mapToObj(c -> (char) c).distinct().map(c -> String.valueOf(c))
				.collect(Collectors.joining(""));
		System.out.println("duplicates removed from '" + string + "' : " + removeDuplicate);
	}

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 2, 4, 5);

		List<Student> students = Arrays.asList(
				new Student(1, "Yalice", "Smith", 20, "Female", "Computer Science", 2022, "New York", 69),
				new Student(2, "Bob", "Johnson", 21, "Male", "Mechanical Engineering", 2021, "Chicago", 75),
				new Student(3, "Annie", "Williams", 22, "Female", "Electrical Engineering", 2020, "San Francisco", 42),
				new Student(4, "George", "Brown", 23, "Male", "Mechanical Engineering", 2019, "New York", 44),
				new Student(5, "Ava", "Davis", 19, "Female", "Computer Science", 2023, "Boston", 53),
				new Student(6, "Tom", "Mathew", 21, "Male", "Mechanical Engineering", 2019, "Washington", 68));

		// Remove duplicate numbers
		removeDuplicatesFromList(list);
		System.out.println(
				"==============================================================================================");

		// Remove duplicate department names
		removeDuplicateDepartmentNames(students);
		System.out.println(
				"==============================================================================================");

		String string = "malayalam";
		// Remove duplicate characters from string
		removeDuplicateCharactersFromString(string);
	}

}
