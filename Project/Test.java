import java.io.*;
class Test
{
    public static void main(String args[])throws Exception
    {
        BufferedReader ob=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the target phrase: ");
        String phrase=ob.readLine();
        System.out.println("Enter the population variety: ");
        int p=Integer.parseInt(ob.readLine());
        System.out.println("Enter the rate of mutation: ");
        float m=Float.parseFloat(ob.readLine());
        Shakespearean_monkey SM=new Shakespearean_monkey(phrase, p, m);
        SM.process();
    }
}