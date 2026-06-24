package se.lexicon;

public class CommonValidators
{
    static boolean isValidEmail(String emailAddress)
    {
        return emailAddress.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    static boolean isValidPhoneNumber(String phoneNumber)
    {
        if (phoneNumber == null) return false;

        // 1. Remove spaces, hyphens, parentheses
        String number = phoneNumber.replaceAll("[\\s()-]", "");

        // 2. Convert international format +46 -> 0
        if (phoneNumber.startsWith("+46")) {
            phoneNumber = "0" + phoneNumber.substring(3);
        }

        // 3. Must start with 0 after normalization
        if (!phoneNumber.startsWith("0")) {
            return false;
        }

        // 4. Remove leading 0 for length check
        String digits = phoneNumber.substring(1);

        // 5. Swedish numbers are typically 9–10 digits after leading 0
        if (digits.length() < 8 || digits.length() > 9) {
            return false;
        }

        // 6. Must contain only digits
        return digits.matches("\\d+");
    }

}
