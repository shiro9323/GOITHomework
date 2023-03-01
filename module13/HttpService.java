package module13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HttpService {

    public static Optional<User> postUser(User user) throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI("https://jsonplaceholder.typicode.com/users/");
        String jsonUser = new Gson().toJson(user);
        HttpRequest httpRequest = HttpRequest.newBuilder(uri)
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonUser))
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        User userResponse = new Gson().fromJson(httpResponse.body(), User.class);
        return Optional.of(userResponse);
    }

    public static Optional<User> updateUser(User user) throws URISyntaxException, IOException, InterruptedException {
        String formattedLink = MessageFormat
                .format("https://jsonplaceholder.typicode.com/users/{0}",user.getId());
        URI uri = new URI(formattedLink);
        String jsonUser = new Gson().toJson(user);
        HttpRequest httpRequest = HttpRequest.newBuilder(uri)
                .headers("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonUser))
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        User userResponse = new Gson().fromJson(httpResponse.body(), User.class);
        return Optional.of(userResponse);
    }

    public static boolean deleteUser(int userId) throws URISyntaxException, IOException, InterruptedException {

        String formattedLink = MessageFormat
                .format("https://jsonplaceholder.typicode.com/users/{0}", userId);
        URI uri = new URI(formattedLink);
        HttpRequest httpRequest = HttpRequest.newBuilder(uri)
                .DELETE()
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return httpResponse.statusCode() == 200;
    }

    public static List<User> getAllUsers() throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI("https://jsonplaceholder.typicode.com/users/");
        HttpRequest httpRequest = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        List<User> userList = new ArrayList<>();
        if (httpResponse.statusCode() == 200) {
            userList.addAll(new Gson().fromJson(httpResponse.body(), TypeToken.getParameterized(List.class, User.class).getType()));
        }
        return userList;
    }
    public static Optional<User> getUserById(int userId) throws URISyntaxException, IOException, InterruptedException {
        String formattedLink = MessageFormat
                .format("https://jsonplaceholder.typicode.com/users/{0}", userId);
        URI uri = new URI(formattedLink);
        HttpRequest httpRequest = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        if(httpResponse.statusCode() == 200) {
            User userResponse = new Gson().fromJson(httpResponse.body(), User.class);
            return Optional.of(userResponse);
        }
        return Optional.empty();
    }

    public static List<User> getUserByUsername(String userName) throws URISyntaxException, IOException, InterruptedException {
        String formattedLink = MessageFormat
                .format("https://jsonplaceholder.typicode.com/users?username={0}", userName);
        URI uri = new URI(formattedLink);
        HttpRequest httpRequest = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        List<User> userList = new ArrayList<>();
        if (httpResponse.statusCode() == 200){
            userList.addAll(new Gson().fromJson(httpResponse.body(), TypeToken.getParameterized(List.class, User.class).getType()));
        }
        return userList;
    }

}
