package homework3;

import java.util.*;

public class mainTest
{
    public static void getName(Employee a)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入名字(Firstname Lastname):");
        a.setFirstName(sc.next());
        a.setLastName(sc.next());
    }

    public static void main(String args[])
    {
        final int max = 5;
        final int min = 1;

        Random r = new Random();
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            switch(r.nextInt(max - min ) + min)
            {
                case 1:
                    SalaridEmployee e1 = new SalaridEmployee();
                    employees.add(e1);
                    getName(e1);

                    break;
                case 2:
                    HourlyEmployee e2 = new HourlyEmployee();
                    employees.add(e2);
                    getName(e2);
                    break;
                case 3:
                    CommissionEmployee e3 = new CommissionEmployee();
                    employees.add(e3);
                    getName(e3);
                    break;
                case 4:
                    BasePlusCommissionEmployee e4 = new BasePlusCommissionEmployee();
                    employees.add(e4);
                    getName(e4);
                    break;
            }
        }
        for (int i = 0; i < 10; i++)
        {
            System.out.print(String.valueOf(i+1) + ". ");
            System.out.println(employees.get(i).toString());
        }

    }
}
