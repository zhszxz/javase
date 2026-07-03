import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
          /*
            需求：
                键盘录入自己心仪的女朋友姓名和年龄。
                姓名的长度在 3 - 10之间，
                年龄的范围为 18 - 40岁,
                超出这个范围是异常数据不能赋值，需要重新录入,一直录到正确为止。
            提示：
                需要考虑用户在键盘录入时的所有情况。
                比如：录入年龄时超出范围，录入年龄时录入了abc等情况
        */
        GirlFriend gf = new GirlFriend();
        while (true) {
            try {
                Scanner sc=new Scanner(System.in);
                System.out.println("请输入姓名：");
                String name = sc.nextLine();
                System.out.println("请输入年龄：");
                String age=sc.nextLine();
                gf.setName(name);
                gf.setAge(Integer.parseInt(age));
                break;
            } catch (AgeFormatException e) {
                e.printStackTrace();
            }catch (NameOutofBoundsException e){
               e.printStackTrace();
            }
        }
        System.out.println(gf);
    }
}
