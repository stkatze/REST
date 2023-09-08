package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.exceptions.UnauthorizedUser;
import ru.netology.model.Authorities;

import java.util.*;

@Repository
public class UserRepository {
    public Map<String, String> credentials = new HashMap<>();
    public Map<String, List<Authorities>> authorities = new HashMap<>();

    public List<Authorities> getUserAuthorities(String user, String password) {

        String testUsername = "Oleg";
        String testPassword = "45637";
        List<Authorities> testAuthorities = List.of(Authorities.READ, Authorities.DELETE);
        credentials.put(testUsername, testPassword);
        authorities.put(testUsername, testAuthorities);

        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            return authorities.get(user);
        }
        return Collections.emptyList();
    }
}