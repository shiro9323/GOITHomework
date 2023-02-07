package module10;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONConverter {
    public static void main(String[] args) throws IOException {
        List<Person> persons = new ArrayList<>();
        try (InputStream fis = new FileInputStream("NameAge.txt");
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if(Objects.equals(line.toLowerCase(), "name age")){
                    continue;
                }
                System.out.println(line);
                String[] arrLine = line.split("\\s+");
                String name = arrLine[0];
                int age = Integer.parseInt(arrLine[1]);
                Person person = new Person(name, age);

                persons.add(person);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter fileWriter = new FileWriter("user.json");
        gson.toJson(persons, fileWriter);
        fileWriter.close();


    }
}
