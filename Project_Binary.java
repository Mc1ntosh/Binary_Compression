
import java.util.Scanner;

public class Project_Binary {

    public static String rleDecimal(String str){
        // n is the length of parameter string 
        // initialize final decimal code string as empty string
        int n = str.length();
        String decimalString = "";
        
        // loop through whole uncompressed string
        for(int i = 0; i<n; i++){
            int count = 1;
            
            // count each consecutive similar character
            while(i<n-1 && str.charAt(i)==str.charAt(i+1)){
                count ++;
                i++;                
            }  
            
            // append count to decimal string accordingly
            if(str.charAt(i)=='1'){
               if(count>1) decimalString = decimalString+"0 ";
            }else{
               decimalString = decimalString+String.valueOf(count)+" "; 
            }            
        }
        
        // return space separated decimal code
        return decimalString;
    }
    
    public static String rleDecode(String str){
        // n is the length of parameter string 
        // initialize final string as empty string
        int n = str.length();
        String decompressedString="", binary = "";
        int count = 0, iterations = 0;
        
        // loop through input binary string
        for(int i = 0; i<n; i++){
            count ++;            
            binary = binary+str.charAt(i);
            
            // deal with every four characters
            if(count%4==0){                
                int decimal=0, weight=1;
                
                for (int j = binary.length() - 1; j >= 0; j--) {
                    if (binary.charAt(j) == '1') {
                        decimal += weight;
                    }
                    weight *= 2;
                }
                
                if (decimal==0){
                    decompressedString = decompressedString+"1";
                }else{
                    if (iterations>0){
                        decompressedString = decompressedString+"1";
                        for(int k=0; k<decimal;k++){
                            decompressedString = decompressedString+"0";
                        }
                    }else{
                        for(int k=0; k<decimal;k++){
                            decompressedString = decompressedString+"0";
                        }
                    }
                }
                
                iterations++;
                binary="";
            }
        }        
        return decompressedString;
    }
    
    public static String rleBinary(String str){
        // n is the length of parameter string 
        // initialize final binary code as empty string
        int n = str.length();
        String binaryCode = "";
        
        // loop through each character of the parameter string
        for(int i = 0; i<n; i++){
            // initialize decimal string
            String dec = "";
            
            // while string still has characters and character at index is not space
            // decimal string is incremented as character
            while(i<n-1 && str.charAt(i)!=' '){
                dec = dec+str.charAt(i);
                i++;
            }
            
            // change decimal string to binary string
            String binary = Integer.toBinaryString(Integer.parseInt(dec));
            
            // make binary string 4 bit
            while (binary.length() < 4) {
                binary = "0" + binary;
            }
            
            // add 4 bit binary to binary code
            binaryCode = binaryCode+binary;
        }

        return binaryCode;
    }
    
    public static boolean encodeValidation(String str){
        // validate leading 0's
        if (str.charAt(0)!='0'){
            System.out.println("The string needs to begin with a 0");
            return false;
        }
        
        // validate no more than 15 0's or 1's
        for(int i = 0; i<str.length(); i++){
            int count = 1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count ++;
                i++;
                
            }            
            if(count>15){
                System.out.println("There should not be an instance of more than 15"
                        + " consecutive 0's");
                return false;
            }           
        }
        
        // validate no more than two consecutive 1's
        for(int i = 0; i<str.length(); i++){
            int count = 1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count ++;
                i++;                
            }            
            if(str.charAt(i)=='1'){
               if(count>2){
                   System.out.println("There should not be an instance of more than 2"
                        + " consecutive 1's");
                   return false;
               }
            }           
        }
        
        return true;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        String inputString = "";
        int choice;
        
        // Display the menu
        System.out.println("*********************************");
        System.out.println("1. Compress Binary String       *");
        System.out.println("2. Decompress Binary String     *");
        System.out.println("3. Exit.                        *");
        System.out.println("*********************************");
        
        
        // prompt user to enter their choice number and store integer in variable
        System.out.print("Enter the number of selection: ");
        choice = input.nextInt();
        System.out.println();
        
        
        
        switch (choice) {
            case 1:
                // Prompt the user to enter a radius of a circle (radius can be any value)
                System.out.println("Enter line of text: ");        
                inputString = input.next();
                
                // proceed if input string is valid
                if(encodeValidation(inputString)){                   
                    
                    System.out.println("The entered line is: ");
                    System.out.println(inputString);

                    // call method to produce decimal run length code
                    String decimalCode = rleDecimal(inputString);
                    
                    // convert decimal run length code to binary
                    String binaryCode = rleBinary(decimalCode);

                    // display results
                    System.out.println("Compressed line: ");
                    System.out.println(binaryCode);                               

                }
                break;
            case 2:
                // Prompt the user to enter a line of text to be compressed
                System.out.println("Enter line of text: ");        
                inputString = input.next();
                
                System.out.println("Compressed string: ");
                System.out.println(inputString);

                // call method to decompress the string
                System.out.println("\nDecompressed initial string: ");
                System.out.println(rleDecode(inputString));                
                break;
            case 3:
                System.out.println("Thank You for using this program!!");
                break;
            default:
                System.out.println("Wrong choice");
                break;
        }
    }
    
}
