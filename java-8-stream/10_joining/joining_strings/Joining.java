package joining_strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Joining {

	private static void combineAllFruitsWithComma(List<String> fruits) {
		String fruit = fruits.stream().filter(f -> f != null).collect(Collectors.joining(" , "));
		System.out.println(fruit);
	}

	private static void convertListOfCitiesInCSVFormat(List<Student> students) {
		String csv = students.stream().map(s -> s.getCity()).collect(Collectors.joining(" , "));
		System.out.println(csv);
	}

	public static void main(String[] args) {

		List<Student> students = Arrays.asList(
				new Student(1, "Yalice", "Smith", 20, "Female", "Computer Science", 2022, "New York", 69),
				new Student(2, "Bob", "Johnson", 21, "Male", "Mechanical Engineering", 2021, "Chicago", 75),
				new Student(3, "Annie", "Williams", 22, "Female", "Electrical Engineering", 2020, "San Francisco", 42),
				new Student(4, "George", "Brown", 23, "Male", "Mechanical Engineering", 2019, "New York", 44),
				new Student(5, "Ava", "Davis", 19, "Female", "Computer Science", 2023, "Boston", 53),
				new Student(6, "Tom", "Mathew", 21, "Male", "Mechanical Engineering", 2019, "Washington", 68));

		List<String> fruits = Arrays.asList("apple", "banana", null, "cherry", "avocado", "blueberry", null, "apricot");

		// Join all fruits with comma
		combineAllFruitsWithComma(fruits);
		System.out.println(
				"==============================================================================================");

		// Convert list of cities into CSV format
		convertListOfCitiesInCSVFormat(students);
		System.out.println(
				"==============================================================================================");
	}

}
