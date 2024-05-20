package firstPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Streams {

	// @Test
	public void countWithArray(){
		
		List<String> names = new ArrayList<String>();
		names.add("Ali");
		names.add("Chris");
		names.add("Bill");
		names.add("Alex");
		names.add("Amy");
		names.add("Sarah");
		names.add("John");
		
		int count=0;
		for (int i = 0; i < names.size(); i++) {
			String actual =names.get(i);
			if(actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	@Test
	public void countWithStreams() {
		List<String> people = new ArrayList<String>();
		people.add("Ali");
		people.add("Chris");
		people.add("Bill");
		people.add("Alex");
		people.add("Amy");
		people.add("Sarah");
		people.add("John");
		
		Long c = people.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		people.stream().filter(m->m.length()>4).forEach(s->System.out.println(s));
	}
	
	@Test
	public void streamMap() {
		//print names which have last letter "a" as upper case
		Stream.of("Sara", "Mike", "Ali", "Hanna", "Alex", "Charles").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		List<String> people = new ArrayList<String>();
		people.add("Ravine");
		people.add("Chris");
		people.add("Bill");
		people.add("Rhema");
		//print names which have first letter "A" as all uppercase and sorted
		List<String> names = Arrays.asList("Sara", "Mike", "Ali", "Hanna", "Alex", "Charles");
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		Stream<String> newStream = Stream.concat(people.stream(), names.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Alex"));
		Assert.assertTrue(flag);
		
	}
		
	@Test
	public void streamCollect() {
		List<String> ls = Stream.of("Sara", "Mike", "Ali", "Hanna", "Alex", "Charles").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> numbers = Arrays.asList(1, 3, 5, 4, 5, 8, 2, 9, 4);
		//print unique numbers from the list
		numbers.stream().distinct().forEach(s->System.out.println(s));
		//sort the array
		numbers.stream().sorted().forEach(s->System.out.println(s));
	
	}

}
