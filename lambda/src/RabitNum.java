public class RabitNum {
    public static void main(String[] args) {
        System.out.println(getnum(12));
    }

    private static int getnum(int month) {
        if(month==1||month==2){
            return 1;
        }
        return getnum(month-1)+getnum(month-2);
    }
}
