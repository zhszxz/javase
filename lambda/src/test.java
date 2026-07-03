import java.util.Arrays;
import java.util.Comparator;

public class test {
    public static void main(String[] args) {
        GirlFriend g1=new GirlFriend("xiaoshishi",19,1.70);
        GirlFriend g2=new GirlFriend("xiaohuihui",19,1.72);
        GirlFriend g3=new GirlFriend("abc",18,1.66);
        GirlFriend[] girls={g1,g2,g3};
        System.out.println(Arrays.toString(girls));
        Arrays.sort(girls, (GirlFriend o1, GirlFriend o2)->{
                double temp=o1.getAge()-o2.getAge();
                temp=temp==0?(o1.getHeight()-o2.getHeight()):temp;
                temp=temp==0?(o1.getName().compareTo(o2.getName())):temp;
                if(temp>0){
                    return 1;
                }
                else if(temp<0){
                    return -1;
                }
                else return 0;
            }
        );
        System.out.println(Arrays.toString(girls));
    }
}
