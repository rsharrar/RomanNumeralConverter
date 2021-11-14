package Main;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Roman {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number in roman numeral or arabic numeral to convert: ");

        String userInput = scanner.nextLine();
        while(!userInput.toUpperCase().equals("Q")){
            RomanNumeralConverter converter = new RomanNumeralConverter(userInput);
            if(converter.isRomanToArabic()){
                System.out.println(converter.fromRoman());
            }else{
                System.out.println(converter.toRoman());
            }
            System.out.println("You may continue to convert numbers or type Q to quit");
            userInput = scanner.nextLine();
        }

    }
}
