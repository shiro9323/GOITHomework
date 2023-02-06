package module10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class IsCorrectPhoneNumber {
    public static void main(String[] args) {
        String pattern = "(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\) \\d{3}-?\\d{4}";
        try (InputStream fis = new FileInputStream("PhoneNumber.txt");
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if(line.matches(pattern)) {
                    System.out.println(line);
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
