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

        this.addPerson("Christoffer 1","christoffer1@gmail.com","12312434234234");


        this.addPerson("Christoffer 2","ffff@gmail.com","12312434234234");


        this.addPerson("testperson1","test@test.com","asdasdasdaasd");


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
        String name,email,phonenumber;
        IO.print("Enter name:");
        name = IO.readln();
        IO.print("Enter email:");
        email = IO.readln();
        IO.print("Enter phonenumber:");
        phonenumber=IO.readln();

        Person person = new Person(name,email,phonenumber);
        this.contacts.add(person);
        return person;
    }

    public void filter()
    {
        String searchstring ="";
        ArrayList<Person> results;
        searchstring=IO.readln("Enter your searchstring: ");
        results=this.searchContact(searchstring);
        if(results.isEmpty()){
            IO.println("Your query did not return any contacts");
        } else {
            IO.println("==============SEARCH RESULTS===============");
            for(Person person : results){
                person.printCard();
            }
            IO.println("==============END OF LIST================");
            // Since we are done, we set our arraylist to null;
            results=null;
        }

    }
    public ArrayList<Person> searchContact(String searchString)
    {
        ArrayList<Person> searchResult = new ArrayList<>();
        for(Person person : this.contacts){
            if(person.name.toLowerCase().contains(searchString.toLowerCase()) || person.email.toLowerCase().contains(searchString.toLowerCase()) ||person.phonenumber.toLowerCase().contains(searchString.toLowerCase()))
            {
                searchResult.add(person);
            }
        }

        return searchResult;


    }

    private void addPerson(String name, String email, String phonenumber)
    {
        Person person = new Person(name,email,phonenumber);
        this.contacts.add(person);
    }
}
