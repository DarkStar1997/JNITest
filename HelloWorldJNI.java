import java.util.Scanner;
public class HelloWorldJNI
{
    static{
        System.loadLibrary("native");
    }
    public static void main(String[] args)
    {
        HelloWorldJNI obj = new HelloWorldJNI();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Sum = " + obj.add(a, b));
    }

    void print()
    {
        System.out.println("Hello from JAVA\n");
    }

    private native int add(int x, int y);
}
