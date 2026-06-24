package se.lexicon;
import java.io.IOException;
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
    private void Populate()  {
        /* Trying to read the database. If the file does not exist, populate with demodata and flush */
        try {
            loadStorage();
        } catch(IOException e) {
            IO.println("Failed loading storage. Populating with demodata");
            this.addPerson("Christoffer 1", "christoffer1@gmail.com", "047212345");
            this.addPerson("Christoffer 2", "ffff@gmail.com", "+4647212345");
            this.addPerson("atestperson1", "test@test.com", "047012345");
            IO.println("Flushing demodata to file");
            this.toCsv();
        }

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
            Person person = new Person(name, email, phonenumber,this.contacts.size()+1); // this.contacts.size()+1 is an incremental ID for each update to be able to identify object to modify/delete.
            this.contacts.add(person);
            toCsv(); // As the person was successfully added, flush to file.
            //return person;
        } catch (IllegalArgumentException e) {
            IO.println(e.getMessage());
        }

    }
    public void updateData()
    {
        Integer contactId=0;
        IO.print("Enter Contact#:");

        try {
            contactId = Integer.parseInt(IO.readln());
        } catch (NumberFormatException e) {
            IO.println("That is not an valid number. Aborting.");
        }
        if(contactId < this.contacts.size()){
            IO.println("You are about to update contact: \"" +this.contacts.get(contactId-1).name);
        }
        String name,email,phoneNumber;
        IO.println("New name (Old="+this.contacts.get(contactId-1).name +"):");
        name = IO.readln();
        IO.println("New email (Old="+this.contacts.get(contactId-1).email +"): ");
        email = IO.readln();
        IO.println("New phonenumber (Old="+this.contacts.get(contactId-1).phonenumber);
        phoneNumber=IO.readln();
        this.update(name,email,phoneNumber,contactId);
        this.toCsv(); // We want to save our changes!

    }
    public void deleteData()
    {
        Integer contactId=0;
        IO.println("Enter contact ID to remove: ");
        try {
            contactId=Integer.parseInt(IO.readln());

        } catch (NumberFormatException e)
        {
            IO.println("You did not enter a number!");

        }
        Person person = this.contacts.get(contactId-1);
        person.printCard();
        String confirm="";
        IO.println("Confirm deletion by writing YES:");
        confirm=IO.readln();
        if(confirm.toLowerCase().equals("yes")){
                this.contacts.remove(contactId-1);
                this.toCsv(); // Flush new contactlist to file
                this.contacts.clear(); // Remove all items we have in contacts
                this.Populate(); // Populate contacts again
        }
    }
    private void update(String name, String email, String phonenumber,Integer objectId)
    {
        Person object = this.contacts.get(objectId-1);
        if(!name.isEmpty()) { object.name=name; }
        if(!email.isEmpty()) {object.email=name; }
        if(!phonenumber.isEmpty()) { object.phonenumber=phonenumber; }
        this.contacts.set(objectId-1,object);
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
            Person person = new Person(name, email, phonenumber,this.contacts.size()+1);
            this.contacts.add(person);
            this.toCsv();
        } catch(IllegalArgumentException e) {
            IO.println("Invalid formatting was passed for either emailaddress or phonenumber");
        }
    }
    private void loadStorage() throws IOException {
        Storage storage  = new Storage("e:\\contacts.csv");
        storage.readFile();// This will throw an exception, as such
        fromCsv(storage);
    }
    private void fromCsv(Storage storage){
        for(String line : storage.lines){
            this.contacts.add(parseCsvLine(line));
        }
    }
    private Person parseCsvLine(String line)
    {
        Person person = new Person();
        String[] tmp = line.split(",");
        person.name=tmp[0];
        person.email=tmp[1];
        person.phonenumber=tmp[2];
        person.contactId=this.contacts.size()+1; // Counter to keep track of each object.
        return person;

    }
    private void toCsv() {
        Storage storage = new Storage("e:\\contacts.csv");
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
