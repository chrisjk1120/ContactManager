package se.lexicon;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PersonTests {
    @Test void addPerson()
    {
        Person person = new Person("Kalle kula","test+test.com","047270581"); // Should throw an error on email
        //Person person = new Person("Kalle kula","test@test.com","047270581"); // Should pass;

    }
}
