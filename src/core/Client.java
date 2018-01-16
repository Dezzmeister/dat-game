package core;

import java.util.List;

public class Client {

	public static void main(String[] args) {
		var a = 5;
		System.out.println(a);
		var immutable = List.of("a", "b", "c");
		immutable.forEach(s -> System.out.println(s));
	}
}
