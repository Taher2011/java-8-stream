package stream_question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

	// How many male and female employees are there in the organization ?
	private static void countOfMaleAndFemaleEmployees(List<Employee> employees) {
		Map<Boolean, Long> map = employees.stream()
				.collect(Collectors.partitioningBy(s -> s.getGender().equalsIgnoreCase("male"), Collectors.counting()));
		System.out.println("count of male   employees are : " + map.get(true));
		System.out.println("count of female employees are : " + map.get(false));
	}

	// Find sum of even numbers and sum of odd numbers in a given list ?
	private static void findSumOfEvenAndOddNumbersFromList(List<Integer> numbers) {
		Map<Boolean, Integer> map = numbers.stream()
				.collect(Collectors.partitioningBy(n -> n % 2 == 0, Collectors.summingInt(n -> n)));
		System.out.println("sum of even numbers : " + map.get(true));
		System.out.println("sum of odd  numbers : " + map.get(false));
	}

	// Find duplicate elements in a given integers list ?
	private static void findDuplicateElementsFromList(List<Integer> list) {
		List<Integer> duplicates = list.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("duplicates are : " + duplicates);
	}

	// Remove all the occurrences of a given character ?
	private static void removeAllOccurencesOfChar(String string, char c) {
		String updatedString = string.chars().mapToObj(ch -> (char) ch).filter(ch -> ch != c).map(String::valueOf)
				.collect(Collectors.joining());
		System.out.println("remove occurences of char '" + c + "' from string " + string + "===> " + updatedString);
	}

	// Find Special characters in a string ? Hello, World! 123 #Java$Stream
	private static void findSpecialCharactersInString(String string) {
		List<Character> specialChars = string.chars().mapToObj(c -> (char) c)
				.filter(c -> !Character.isAlphabetic(c) && !Character.isDigit(c) && !Character.isWhitespace(c))
				.collect(Collectors.toList());
		System.out.println(specialChars);
	}

	// Find out all the numbers starting with 1 from a integer list ?
	private static void findOutAllNumbersStartWith1FromList(List<Integer> list) {
		List<Integer> numbersStartWith1 = list.stream().map(String::valueOf).filter(n -> n.startsWith("1"))
				.map(Integer::valueOf).collect(Collectors.toList());
		System.out.println("numbers start with 1 : " + numbersStartWith1);
	}

	// Find the employee with the highest salary from a list of employee objects ?
	private static void findEmployeeWithHighestSalary(List<Employee> employees) {
		employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).ifPresent(
				e -> System.out.println("employee " + e.getName() + " is with highest salary : " + e.getSalary()));
	}

	// Concatenate a list of strings into a single string, separated by commas ?
	private static void concatenateListOfStringsInSingleStringCommaSeprated(List<String> fruits) {
		String fruit = fruits.stream().collect(Collectors.joining(" , "));
		System.out.println(fruit);
	}

	// Find the first non-repeating character in a string ?
	private static void findFirstNonRepeatingChar(String string) {
		string.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().ifPresent(c -> System.out
						.println("first non-repeating character in a string : " + string + " is : " + c));
	}

	// Find frequency of characters of a given string ?
	private static void findFrequencyOfCharInString(String string) {
		Map<Character, Long> map = string.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
		map.forEach((k, v) -> {
			System.out.println("frequency of char '" + k + "' is : " + v);
		});
	}

	public static void main(String[] args) {

		List<Student> students = Arrays.asList(
				new Student(1, "Yalice", "Smith", 20, "Female", "Computer Science", 2022, "New York", 69, 77),
				new Student(2, "Bob", "Johnson", 21, "Male", "Mechanical Engineering", 2021, "Chicago", 75, 86),
				new Student(3, "Annie", "Williams", 22, "Female", "Electrical Engineering", 2020, "San Francisco", 42,
						54),
				new Student(4, "George", "Brown", 23, "Male", "Mechanical Engineering", 2019, "New York", 44, 59),
				new Student(5, "Ava", "Davis", 19, "Female", "Computer Science", 2023, "Boston", 53, 65),
				new Student(6, "Tom", "Mathew", 21, "Male", "Mechanical Engineering", 2019, "Washington", 68, 73));

		List<Employee> employees = Arrays.asList(new Employee("John", "Male", 30, 70000, "Computer Science"),
				new Employee("Emma", "Female", 25, 50000, "Mechanical Engineering"),
				new Employee("Alex", "Male", 45, 90000, "Electrical Engineering"),
				new Employee("Sophia", "Female", 33, 85000, "Computer Science"),
				new Employee("Mark", "Male", 28, 95000, "Mechanical Engineering"));

		List<ProductSale> productSales = Arrays.asList(new ProductSale("Laptop", 3), new ProductSale("Mobile", 5),
				new ProductSale("Laptop", 4), new ProductSale("Tablet", 2), new ProductSale("Mobile", 6));

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		List<String> fruits = Arrays.asList("apple", "banana", "cherry", "avocado", "blueberry", "apricot");

		List<Integer> duplicates = Arrays.asList(1, 2, 3, 4, 5, 6, 3, 2, 1, 5, 11, 13, 19);

		countOfMaleAndFemaleEmployees(employees);
		System.out.println(
				"==============================================================================================");

		findSumOfEvenAndOddNumbersFromList(numbers);
		System.out.println(
				"==============================================================================================");

		findDuplicateElementsFromList(duplicates);
		System.out.println(
				"==============================================================================================");

		removeAllOccurencesOfChar("malayalam", 'a');
		System.out.println(
				"==============================================================================================");

		findOutAllNumbersStartWith1FromList(duplicates);
		System.out.println(
				"==============================================================================================");

		findEmployeeWithHighestSalary(employees);
		System.out.println(
				"==============================================================================================");

		concatenateListOfStringsInSingleStringCommaSeprated(fruits);
		System.out.println(
				"==============================================================================================");

		findFirstNonRepeatingChar("malayalam");
		System.out.println(
				"==============================================================================================");

		findFrequencyOfCharInString("malayalam");
		System.out.println(
				"==============================================================================================");

		findSpecialCharactersInString("Hello, World! 123 #Java$Stream");
		System.out.println(
				"==============================================================================================");
		System.out.println(
				"==============================================================================================");
		System.out.println(
				"==============================================================================================");
		System.out.println(
				"==============================================================================================");
		System.out.println(
				"==============================================================================================");
	}

}
