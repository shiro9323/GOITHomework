package module13;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

public class HttpServiceTest {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {


        //Task1
        //POST add user
        System.out.println("-----POST-----");
        Geo geo = new Geo(-30.1,30.1);
        Address address = new Address("testStreet","testSuite", "testCity", "testZipcode", geo);
        Company company = new Company("testNameCompany", "testCatchphrase", "testBs");
        User user = new User(111, "testName", "TestUsername", "test@gmail.com", address, "111-222-333", "testWebsite", company);

        Optional<User> postUser = HttpService.postUser(user);
        postUser.ifPresent(System.out::println);

        //PUT
        System.out.println("-----PUT-----");
        Optional<User> userByIdToUpdate = HttpService.getUserById(10);

        User userToUpdate = userByIdToUpdate.get();
        userToUpdate.setName("testNamePUT");
        userToUpdate.setUsername("testUsernamePUT");
        userToUpdate.setEmail("testEmailPUT");
        Optional<User> updatedUser = HttpService.updateUser(userToUpdate);
        updatedUser.ifPresent(System.out::println);

        //DELETE
        System.out.println("HttpService.deleteUser(userToDelete) = " + HttpService.deleteUser(10));

        //GET All
        System.out.println("HttpService.getAllUsers() = " + HttpService.getAllUsers());

        //GET by id
        System.out.println("HttpService.getUserById(5) = " + HttpService.getUserById(5));

        //GET by username
        System.out.println("HttpService.getUserByUsername(\"Delphine\") = " + HttpService.getUserByUsername("Delphine"));

        //Task2


    }
}
