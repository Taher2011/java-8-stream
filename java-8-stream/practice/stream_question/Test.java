package stream_question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

	// Group a list of strings by their length ?
	private static void groupListOFStringByTheirLength(List<String> fruits) {
		System.out.print("grouping a list of fruits by their length : -> ");
		Map<Integer, List<String>> map = fruits.stream().collect(Collectors.groupingBy(f -> f.length()));
		System.out.print(map);
		System.out.println();
	}

	// Filter a list of numbers to only include those greater than 10 and then find
	// their average ?
	private static void filterListGreaterThan10AndAverage(List<Integer> numbers) {
		Double average = numbers.stream().filter(n -> n > 10).mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println("average : " + average);
	}

	// Convert a list of strings to map where key is the string and the value is the
	// length ?
	private static void convertListOfStringToMapKeyAsStringAndValueAsLength(List<String> fruits) {
		Map<String, Integer> map = fruits.stream().collect(Collectors.toMap(f -> f, f -> f.length()));
		System.out.println(map);
	}

	// Flatten a list of lists of integers into a single list of integers ?
	private static void flattenListOfListsIntoSingleList(List<List<Integer>> list) {
		List<Integer> flattenList = list.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
		System.out.println(flattenList);
	}

	// Given a list of transactions, filter out transactions of a specific type and
	// collect them into a set ?
	private static void filterOutTrxAndCollectToSet(List<Transaction> transactions, String trxType) {
		Set<Transaction> trxsWithoutDeposit = transactions.stream().filter(t -> t.getType().equalsIgnoreCase(trxType))
				.collect(Collectors.toSet());
		System.out.println(trxsWithoutDeposit);
	}

	// Find the first name of the oldest student in a list of Student objects ?
	private static void findNameOfOldestStudent(List<Student> students) {
		students.stream().max(Comparator.comparingInt(Student::getAge))
				.ifPresent(s -> System.out.println(s.getFirstName() + " is the oldest student with age " + s.getAge()));
	}

	// 'Skip' first 5 elements in a list and 'print' rest ?
	private static void skipFirst5Element(List<String> elements) {
		elements.stream().skip(5).forEach(System.out::println);
	}

	// Arrays.asList("Java 8 introduced streams", "Streams are powerful", "Use
	// streams to process data")
	// Collect all unique words from a list of sentences ?
//	private static void collectAllUniqueWordsFromList(List<String> sentences) {
//		sentences.stream().flatMap(s -> s.chars());
//	}

	// Filter out 'null values' from a list of strings ?
	private static void filterOutNullValuesFromList(List<String> fruits) {
		List<String> nonNullValues = fruits.stream().filter(f -> f != null).collect(Collectors.toList());
		System.out.println(nonNullValues);
	}

	// 'Partition' a list of integers into 'even' and 'odd' numbers ?
	private static void partitionListIntoEvenAndOdd(List<Integer> numbers) {
		Map<Boolean, List<Integer>> map = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println("list of even numbers : " + map.get(true));
		System.out.println("list of odd  numbers : " + map.get(false));
	}

	// Find the sum of the squares of a list of integers ?
	private static void findSumOfSquares(List<Integer> numbers) {
		int sumOfSquares = numbers.stream().mapToInt(n -> n * n).sum();
		System.out.println(sumOfSquares);
	}

	// Convert a list of strings to a list of their respective length using streams
	private static void convertListOfStringToListOfTheirRespectiveLength(List<String> fruits) {
		List<Integer> lengths = fruits.stream().map(f -> f.length()).collect(Collectors.toList());
		System.out.println(lengths);
	}

	// Find the product of all elements in a list of integers ?
	private static void findProductOfAllElements(List<Integer> numbers) {
		int product = numbers.stream().reduce((a, b) -> a * b).get();
		System.out.println(product);
	}

	// 'Merge' two lists of integers and 'remove duplicates' ?
	private static void mergeTwoListAndRemoveDuplicates(List<Integer> numbers1, List<Integer> numbers2) {
		Stream<Integer> stream1 = numbers1.stream();
		Stream<Integer> stream2 = numbers2.stream();
		Stream<Integer> mergeStream = Stream.concat(stream1, stream2);
		List<Integer> collect = mergeStream.distinct().collect(Collectors.toList());
		System.out.println(collect);
	}

	// Check if any string in a list starts with a specific prefix ?
	private static void checkIfAnyStringStartsWithSpecificPrefic(List<String> fruits, String prefix) {
		Boolean found = fruits.stream().anyMatch(f -> f.startsWith(prefix));
		if (found) {
			System.out.println("yes, at least one string starts with : " + prefix);
		} else {
			System.out.println("no string starts with : " + prefix);
		}
	}

	// List 'top three highest' paid employees ?
	private static void findTop3HighestPaidEmployees(List<Employee> employees) {
		List<Employee> top3HighestPaidEmps = employees.stream().sorted((e1, e2) -> {
			if (e1.getSalary() > e2.getSalary()) {
				return -1;
			} else if (e1.getSalary() < e2.getSalary()) {
				return 1;
			}
			return 0;
		}).limit(3).collect(Collectors.toList());
		System.out.println("top three highest paid employees : ");
		top3HighestPaidEmps.stream().forEach(e -> {
			System.out.println(e.getName() + " receives salary -> " + e.getSalary());
		});
	}

	// Array of numbers, find 'second highest number' from the array ?
	private static void findSecondHighestNumberFromArray(int[] arr) {
		Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst()
				.ifPresent(num -> System.out.println("second highest number is : " + num));
	}

	// How to sort a map by its values in ascending order ?
	private static void sortMapByItsValuesAscending(Map<String, Integer> map) {
		map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()).forEach(System.out::println);
	}

	// How to sort a map by its values in descending order ?
	private static void sortMapByItsValuesDescending(Map<String, Integer> map) {
		map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.forEach(System.out::println);
	}

	// How to find second highest salary ?
	private static void findSecondHighestPaidEmployee(List<Employee> employees) {
		employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst()
				.ifPresent(e -> System.out
						.println("second highest paid employee is : " + e.getName() + " with salary " + e.getSalary()));
	}

	// Remove consecutive duplicate elements from a list
	private static void removeConsecutiveDuplicateElementsFromList(List<Integer> numbers) {
		List<Integer> list = new ArrayList<>();
		for (Integer number : numbers) {
			if (list.isEmpty() || !(list.get(list.size() - 1).equals(number))) {
				list.add(number);
			}
		}
		System.out.println(list);
	}

	// Remove consecutive duplicate elements from a list using stream
	private static void removeConsecutiveDuplicateElementsFromListUsingStream(List<Integer> list) {
		List<Integer> collect = IntStream.range(0, list.size())
				.filter(i -> i == 0 || !list.get(i).equals(list.get(i - 1))).mapToObj(i -> list.get(i))
				.collect(Collectors.toList());
		System.out.println(collect);
	}

	// Merge two arrays, sort them, and find the distinct elements
	private static void mergerTwoArraySortAndFindDistinctElement(Integer[] array1, Integer[] array2) {
		Integer[] array3 = Stream.concat(Arrays.stream(array1), Arrays.stream(array2)).sorted().distinct()
				.toArray(n -> new Integer[n]);
		System.out.println(Arrays.toString(array3));
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

		List<Transaction> transactions = List.of(new Transaction("deposit", 100.0), new Transaction("withdrawal", 50.0),
				new Transaction("deposit", 200.0), new Transaction("transfer", 150.0));

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

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

		findSpecialCharactersInString("Hello, World! 123 #Java$Stream");
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

		groupListOFStringByTheirLength(fruits);
		System.out.println(
				"==============================================================================================");

		filterListGreaterThan10AndAverage(Arrays.asList(5, 10, 15, 20, 25));
		System.out.println(
				"==============================================================================================");

		convertListOfStringToMapKeyAsStringAndValueAsLength(fruits);
		System.out.println(
				"==============================================================================================");

		flattenListOfListsIntoSingleList(
				Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5), Arrays.asList(6, 7, 8, 9)));
		System.out.println(
				"==============================================================================================");

		filterOutTrxAndCollectToSet(transactions, "deposit");
		System.out.println(
				"==============================================================================================");

		findNameOfOldestStudent(students);
		System.out.println(
				"==============================================================================================");

		skipFirst5Element(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"));
		System.out.println(
				"==============================================================================================");

		filterOutNullValuesFromList(Arrays.asList("one", null, "two", null, "three"));
		System.out.println(
				"==============================================================================================");

		partitionListIntoEvenAndOdd(numbers);
		System.out.println(
				"==============================================================================================");

		findSumOfSquares(numbers);
		System.out.println(
				"==============================================================================================");

		convertListOfStringToListOfTheirRespectiveLength(fruits);
		System.out.println(
				"==============================================================================================");

		findProductOfAllElements(numbers);
		System.out.println(
				"==============================================================================================");

		mergeTwoListAndRemoveDuplicates(numbers, Arrays.asList(4, 5, 6, 7, 8));
		System.out.println(
				"==============================================================================================");

		checkIfAnyStringStartsWithSpecificPrefic(fruits, "ba");
		System.out.println(
				"==============================================================================================");

		findTop3HighestPaidEmployees(employees);
		System.out.println(
				"==============================================================================================");

		findSecondHighestNumberFromArray(new int[] { 5, 3, 9, 1, 6, 8 });
		System.out.println(
				"==============================================================================================");

		sortMapByItsValuesAscending(Map.of("Python", 95, "JavaScript", 89, "C++", 92, "TypeScript", 85, "Swift", 80));
		System.out.println(
				"==============================================================================================");

		sortMapByItsValuesDescending(Map.of("Python", 95, "JavaScript", 89, "C++", 92, "TypeScript", 85, "Swift", 80));
		System.out.println(
				"==============================================================================================");

		findSecondHighestPaidEmployee(employees);
		System.out.println(
				"==============================================================================================");

		removeConsecutiveDuplicateElementsFromList(Arrays.asList(1, 1, 2, 2, 2, 1, 1, 2, 3, 3));
		System.out.println(
				"==============================================================================================");

		removeConsecutiveDuplicateElementsFromListUsingStream(Arrays.asList(1, 1, 2, 2, 2, 1, 1, 2, 3, 3));
		System.out.println(
				"==============================================================================================");

		mergerTwoArraySortAndFindDistinctElement(new Integer[] { 5, 3, 9, 1 }, new Integer[] { 3, 7, 1, 8 });
		System.out.println(
				"==============================================================================================");
		System.out.println(
				"==============================================================================================");
	}

}
