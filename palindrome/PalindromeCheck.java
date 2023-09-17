public class Main
{
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        String revStr = "";
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            revStr = ch + revStr;
        }
        if (str.equals(revStr)) {
            return true;
        } else return false;
    }
    
    public static void main(String[] args) {
        
        System.out.println("Is checked number a palindrome: " + isPalindrome(1000));
    }
}
