

public class Palindrome {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//       System.out.println("до какого?");
//       String m = scanner.nextLine();
       
       if (Equals(args[0], reverseString(args[0]))){
           System.out.println(reverseString(args[0]));
       }
    }
    public static String reverseString(String m){
        String word = "";

        for (int k=m.length(); k>=1; k--){
          word = word + m.charAt(k-1);
        }
        
        return word;
    }
    public static boolean Equals (String word, String m){
       return word.equals(m);
    }

}
