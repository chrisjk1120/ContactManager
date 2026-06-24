package se.lexicon;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Contacts {
    List<Person> contacts = new ArrayList<>();

    public Contacts()
    {
        this.Populate();
    }
    private void Populate()
    {
        /* Function used for demopurposes so I don't have to enter the data for each test-run */

        this.addPerson("Christoffer 1","christoffer1@gmail.com","047212345");
        this.addPerson("Christoffer 2","ffff@gmail.com","+4647212345");
        this.addPerson("atestperson1","test@test.com","047012345");


    }

    public void listContacts(boolean sorted)
    {
        if(sorted)
        {
            this.contacts.sort(Comparator.comparing(Person::getName,String.CASE_INSENSITIVE_ORDER));

        }
        for(Person person : this.contacts)
        {
            person.printCard();
        }
    }

    public void addContact() {
        String name, email, phonenumber;
        IO.print("Enter name:");
        name = IO.readln();
        IO.print("Enter email:");
        email = IO.readln();
        IO.print("Enter phonenumber:");
        phonenumber = IO.readln();
        try {
            Person person = new Person(name, email, phonenumber);
            this.contacts.add(person);
            //return person;
        } catch (IllegalArgumentException e) {
            IO.println(e.getMessage());
        }

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
        // As this method will be used by the upcoming
        try {
            Person person = new Person(name, email, phonenumber);
            this.contacts.add(person);
        } catch(IllegalArgumentException e) {
            IO.println("Invalid formatting was passed for either emailaddress or phonenumber");
        }
    }
    private void loadStorage() {
        Storage storage  = new Storage("contacts.csv");
        // This will throw an exception, as such

    }
    private void toCsv() {
        Storage storage = new Storage("contacts.csv");
        List<String> csvFile = new ArrayList<>();
        for(Person person : this.contacts)
        {
            csvFile.add(person.csvNotation());
        }
        storage.flush(csvFile);
        csvFile=null;
        storage=null;
    }


}
