public class Monkey {
    public static void main(String[] args) {
        System.out.println(getTaoziNum(1));
    }

    private static int getTaoziNum(int day) {
        if(day==10){
            return 1;
        }
        return (getTaoziNum(day+1)+1)*2;
    }
}
