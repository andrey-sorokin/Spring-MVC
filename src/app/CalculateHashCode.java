package app;

public class CalculateHashCode {

	public static void main(String[] args) {
		String first_name = "Надежда";
		String middle_name = "Александровна";
		String second_name = "Горбунова";

		String fio = first_name.concat(middle_name).concat(second_name);
		
		System.out.println(fio.hashCode());
	}

}
