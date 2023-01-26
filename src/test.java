public class test
{
    public static void main(String[] args)
    {
        Person Drew = new Person("Drew","Spampinato","000001","Mr",2002);

        System.out.println(Drew);
        System.out.println(Drew.getFullName());
        System.out.println(Drew.getFormalName());
        System.out.println(Drew.getAge());
        System.out.println(Drew.getAge(2005));
    }
}

