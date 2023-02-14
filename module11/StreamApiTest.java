package module11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamApiTest {
    public static void main(String[] args) {

        List<String> names = List.of(
                "Ivan",
                "Andrii",
                "Maria",
                "Petr",
                "Anna",
                "Kris"
        );

        String[] numbers = {
                "1, 2, 0",
                "4, 5"
        };


        System.out.println("convertedToStringOddNames = " + convertedToStringOddNames(names));
        System.out.println("convertedToListSortedAndUppCase = " + convertedToListSortedAndUppCase(names));
        System.out.println("convertedToStringNumberSort(numbers) = " + convertedToStringNumberSort(numbers));

        long a = 25214903917L;
        int c = 11;
        int m = (int) Math.pow(2, 48);

        Stream<Long> streamLong = random(a, c, m);
        System.out.println("streamLong = " + streamLong);


    }

     //Task 1
     public static String convertedToStringOddNames(List<String> names){

        return names.stream()
                .filter(name-> names.indexOf(name)%2==0)
                .map(name-> names.indexOf(name) + 1 +". "+name)
                .collect(Collectors.joining(", "));

     }

     //Task 2
     public static List<String> convertedToListSortedAndUppCase(List<String> names){

         return names.stream()
                 .map(String::toUpperCase)
                 .sorted(Comparator.reverseOrder())
                 .collect(Collectors.toList());

     }

     //Task 3
     public static String convertedToStringNumberSort(String[] numbers){

         return Arrays.stream(numbers)
                 .flatMap(number -> Arrays.stream(number.split(", ")))
                 .map(Integer::parseInt)
                 .sorted()
                 .map(String::valueOf)
                 .collect(Collectors.joining(", "));

     }

     //Task 4
     public static Stream<Long> random(long a, int c, int m) {

         //stream
         //        .forEach(System.out::println);

        return LongStream.iterate(1, x -> (a * x + c) % m).boxed();


     }
}
