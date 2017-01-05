import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class CollectionDemo {


    public static void iteration(final List<String> friends) {
    
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(final String name) {
                System.out.println(name);
            }
        });

        friends.forEach((final String name) -> System.out.println(name));

        friends.forEach((name) -> System.out.println(name));

        friends.forEach(name -> System.out.println(name));
        
        friends.forEach(System.out::println);

    }

    public static void transform(final List<String> friends) {
        final List<String> uppercaseNames = new ArrayList<>();
        friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
        System.out.println(uppercaseNames);


        friends.stream()
               .map(String::toUpperCase)
               .forEach(name -> System.out.print(name+", "));
        System.out.println();
    }

    public static void pickElements(final List<String> friends) {
        final List<String> startsWithN = friends.stream()
            .filter(name -> name.startsWith("N"))
            .collect(Collectors.toList());

        System.out.println(startsWithN);
    }

    public static void reuseLambda() {
    
        final List<String> friends = Arrays.asList("Brain", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
        final List<String> editors = Arrays.asList("Brain", "Jackie", "John", "Mike");

        final Predicate<String> startsWithN = name -> name.startsWith("N");

        System.out.println(friends.stream().filter(startsWithN).count());
        System.out.println(comrades.stream().filter(startsWithN).count());
        System.out.println(editors.stream().filter(startsWithN).count());


    }

    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brain", "Nate", "Neal", "Raju", "Sara", "Scott");

        // iteration(friends);
        // transform(friends);
        // pickElements(friends);
        reuseLambda();

    }
}
