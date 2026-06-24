package se.lexicon;
public class menuHandler {

    public menuHandler()
    {
        Contacts contacts = new Contacts();
        while(true) {
            switch (printMenu()) {
                case 1:
                    contacts.listContacts(true);
                    break;
                case 2:
                    contacts.addContact();
                    break;
                case 3:
                    contacts.filter();
                    break;
                case 4:
                    IO.println("Exiting..");
                    return;


            }
        }
    }
    private int printMenu() {
        int menuSelection=0;

        IO.println("========================");
        IO.println("\tLexicon contactcard");
        IO.println("========================");
        IO.println("1) List all contacts");
        IO.println("2) Add new contact");
        IO.println("3) Search contacts");
        IO.println("4) Exit application");
        IO.println("==========================");
        try {
            IO.print("Your selection:");
            menuSelection = Integer.parseInt(IO.readln());
        } catch(NumberFormatException e){
            IO.println("The entered value was not an integer, nothing happened.");
        }
        return menuSelection;

    }

}