public class Main {
    public static void main(String[] args) {
        //电话
        String regex1="1[3-9]\\d{9}";
        System.out.println("15376551300".matches(regex1));
        System.out.println("153765513001".matches(regex1));
        System.out.println("05376551300".matches(regex1));
        System.out.println("12376551300".matches(regex1));
        //座机
        String regex2="0\\d{2,3}-?[^0]\\d{4,9}";
        System.out.println("029-232242".matches(regex2) );
        //邮箱
        String regex3="\\w+@[w&&[^_]]{2,6}(\\.[a-zA-Z]{2,3}){1,2}";
        System.out.println("dLei0009@pci.com.cn".matches(regex3));
        System.out.println("3161645706@qq.com".matches(regex3));
        System.out.println("cn2187668163.com".matches(regex3));
        //插件生成时间的正则表达式
        String regex4="([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d";
        System.out.println("22:55:16".matches(regex4));
        String regex5="([01]\\d|2[0-3])[:[0-5]\\d]{2}";
        System.out.println("22:55:16".matches(regex4));
        //校验用户名
        String regex6="\\w{4,16}";
        System.out.println("zhangsan".matches(regex6));
        //身份证
        String regex7="[1-9]\\d{16}(\\d|(?i)x)";
        System.out.println("610424200310186190".matches(regex7));
        System.out.println("61042420031018619x".matches(regex7));
        System.out.println("61042420031018619X".matches(regex7));
        // 身份证进阶
        String regex8="[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])\\d{3}[\\dXx]";
        System.out.println("610424200310186190".matches(regex8));
    }
}