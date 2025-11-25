package mapToWrapperClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
class Student {

	private int id;

	private String firstName;

	private String lastName;

	private int age;

	private String gender;

	private String departmantName;

	private int joinedYear;

	private String city;

	private int rank;

}
