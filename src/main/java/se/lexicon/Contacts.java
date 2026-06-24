package se.lexicon;
import java.util.ArrayList;

public class Contacts {
    ArrayList<Person> contacts = new ArrayList<>();

    public Contacts()
    {
        this.Populate();
    }
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

    public Person addContact()
    {
        Person person = new Person();
        IO.print("Enter name:");
        person.name = IO.readln();
        IO.print("Enter email:");
        person.email = IO.readln();
        IO.print("Enter phonenumber:");
        person.phonenumber=IO.readln();
        if(person.name.isEmpty()||person.email.isEmpty() || person.phonenumber.isEmpty()){
            IO.println("ERROR: You cannot leave a line empty");
        }
        this.contacts.add(person);
        return person;
    }
}
