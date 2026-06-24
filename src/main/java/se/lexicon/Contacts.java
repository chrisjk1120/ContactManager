package se.lexicon;
import java.util.ArrayList;

public class Contacts {
    ArrayList<Person> contacts = new ArrayList<>();


    private void Populate()
    {
        /* Function used for demopurposes so I don't have to enter the data for each test-run */
        Person person = new Person();
        person.addPerson("Christoffer 1","christoffer1@gmail.com","12312434234234");
        this.contacts.add(person);
    }

    public void listContacts(boolean sorted)
    {
        if(sorted == false)
        {
            for(Person person : this.contacts)
            {
                person.printCard();
            }
        } else {

        }
    }
}
