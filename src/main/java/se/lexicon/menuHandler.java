package se.lexicon;
public class menuHandler {

    static void menuHandler()
    {
        switch(printMenu){
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
    private int printMenu() {
        int menuSelection=0;

        IO.println("========================");
        IO.println("\tLexicon contactcard");
        IO.println("========================");
        IO.println("1) List all contacts");
        IO.println("2) Add new contact");
        IO.println("3) Delete contact";
        IO.println("4) Exit application");
        IO.println("==========================");
        try {
            menuSelection = Integer.parseInt(IO.readln());
            return menuSelection;
        } catch(NumberFormatException e){
            IO.println("The entered value was not an integer, nothing happened.");
        }
    }

}