package entity;

import password_jfx.password_generator.Tech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Password implements passwords_library{

    private final ArrayList<Character> body = new ArrayList<>();
    private final int length;
    private int[] chars;
    private int[] capChars;
    private int[] digits;
    private int[] spaces;

    public Password(int length) {
        this.length = length;
    }

    /*
    Method fills fields of Password with random generated arrays of numbers that is numeric
    implementation of symbols, digits and "_". After that, this method calls method collectPassword()
    to fill body field with symbols according to all generated before numeric arrays.
    Returns password String if checkPassword() method returns false and start recursion if true.
     */
    public String generate() {

        chars = defineSymbols(Tech.getRandom(2, length/2), 97, 122);
        digits = defineSymbols(Tech.getRandom(2, 3), 48, 57);
        capChars = defineSymbols(Tech.getRandom(1, (length - chars.length - digits.length)), 65, 90);
        spaces = defineSymbols(length - chars.length - digits.length-capChars.length, 95, 95);

        collectPassword();

        return checkPassword(this.toString()) ? generate() : this.toString();
    }

    //check if library implemented from passwords_library has generated password and in case of doesn't have then adds it
    private boolean checkPassword(String password) {

        if (!library.contains(password)){
            library.add(password);
            return false;
        }
        return true;
    }

    //Method fills body field collection according to each 'chars', 'capChars', 'digits', 'spaces' arrays numbers
    //converting them into specific symbol (casting to char)
    private void collectPassword() {

        Arrays.stream(chars).forEach(n -> body.add((char) n));
        Arrays.stream(digits).forEach(n -> body.add((char) n));
        Arrays.stream(capChars).forEach(n -> body.add((char) n));
        Arrays.stream(spaces).forEach(n -> body.add((char) n));
        Collections.shuffle(body);

    }

    //Random fill creation and filling out of array with numbers in specific diapason.
    public int[] defineSymbols(int amount, int from, int to) {
        int[] array = new int[amount];

        for(int i=0; i<array.length; i++){
            array[i] = Tech.getRandom(from, to);
        }

        return array;
    }

    @Override
    public String toString(){
        StringBuilder password = new StringBuilder();
        body.forEach(password::append);
        return password.toString();
    }

}
