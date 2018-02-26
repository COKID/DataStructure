import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        long n,m,p,a,b,c,fm,sn,result;
        n=scanner.nextLong();
        m=scanner.nextLong();
        p=scanner.nextLong();
        a=b=1;
        for(int i=3;i<=m;i++)//求fm
        {
            c=a+b;
            a=b;
            b=c;
        }
        fm=b;
        a=b=1;
        for(int i=3;i<=n+2;i++)//求sn
        {
            if(a+b>=fm)
                c=(a+b)%fm;
            else
                c=a+b;
            a=b;
            b=c;
        }
        sn=(b+fm-1)%fm;
        result=sn%p;
        System.out.println(result);
    }
}