import java.util.Scanner;
import java.util.SortedMap;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
       if(!str.matches("[^0]\\d{0,9}")){
           System.out.println("格式错误！");
            System.exit(0);
       }
       int sum=0;
       for(int i=0;i<str.length();i++){
           char ch=str.charAt(i);
           int num=ch-'0';
           sum=10*sum+num;
       }
        System.out.println(sum);
    }
}