import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.Optional;


public class Comparators {

    public static class Person {

        private final String name;
        private final int age;
        public Person(final String theName, final int theAge) {
            name = theName;
            age = theAge;
        }
        public String getName() { return name; }
        public int getAge() { return age; }
        public int ageDifference(final Person other) {
            return age - other.age;
        }
        public String toString() {
            return String.format("%s - %d", name, age);
        }

    }

    public static void printAscendingAge(final List<Person> people) {
        List<Person> ascendingAge = 
            people.stream()
                  .sorted((person1, person2) -> person1.ageDifference(person2))
                  .collect(Collectors.toList());

        ascendingAge.forEach(System.out::println);
    }

    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20), new Person("Sara", 21),
                new Person("Jane", 21), new Person("Greg", 35));

        printAscendingAge(people);
    }

}
