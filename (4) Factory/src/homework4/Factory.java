package homework4;

import java.util.*;

public class Factory
{
    private HashMap<String,Employee> employees = new HashMap<String,Employee>();

    private static String[] getEssential()
    {
        boolean available = false;
        String[] res = new String[3];
        while(!available)
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                System.out.print("请输入名字(Firstname Lastname):");
                res[0] = sc.next();
                res[1] = sc.next();
                System.out.print("请输入社会保障号:");
                res[2] = sc.next();
                available = true;
            }
            catch(Exception e)
            {
                System.err.println("输入错误,请重试!");
            }
        }
        return res;
    }

    public void initEmployees() throws InterruptedException
    {
        final int max = 5;
        final int min = 1;
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        for (int i = 0; i < 10; i++)
        {
            System.out.println("录入第" + String.valueOf(i+1) + "条信息:");
            String[] essential = getEssential();
            if(essential[2].equals("0000"))
                break;
            switch(r.nextInt(max - min ) + min)
            {
                case 1:
                    SalaridEmployee e1 = new SalaridEmployee(essential[0],essential[1],essential[2]);
                    double weekly = 0;
                    boolean available = false;
                    while(!available)
                    {
                        try
                        {
                            System.out.print("请输入周薪:");
                            weekly = sc.nextDouble();
                            available = true;
                        }
                        catch (Exception e)
                        {
                            System.err.println("输入错误,请重试!");
                            sc.nextLine();
                        }
                    }
                    e1.setWeeklySalary(weekly);
                    while(addEmployee(e1) == null)
                    {
                        System.err.println("此员工已存在");
                        Thread.sleep(5);
                        System.out.print("请重新输入社会保障号:");
                        e1 = new SalaridEmployee(essential[0],essential[1],sc.next());
                        e1.setWeeklySalary(weekly);
                    }
                    break;

                case 2:
                    HourlyEmployee e2 = new HourlyEmployee(essential[0],essential[1],essential[2]);
                    double wage = 0;
                    int hours = 0;
                    available = false;
                    while(!available)
                    {
                        try
                        {
                            System.out.print("请输入时薪和工作时长(时薪 工作时长):");
                            wage = sc.nextDouble();
                            hours = sc.nextInt();
                            available = true;
                        }
                        catch (Exception e)
                        {
                            System.err.println("输入错误,请重试!");
                            sc.nextLine();
                        }
                    }
                    e2.setWage(wage);
                    e2.setHours(hours);
                    while(addEmployee(e2) == null)
                    {
                        System.err.println("此员工已存在");
                        Thread.sleep(5);
                        System.out.print("请重新输入社会保障号:");
                        e2 = new HourlyEmployee(essential[0],essential[1],sc.next());
                        e2.setWage(wage);
                        e2.setHours(hours);
                    }

                    break;

                case 3:
                    CommissionEmployee e3 = new CommissionEmployee(essential[0],essential[1],essential[2]);
                    double grossSales = 0;
                    double commissionRate = 0;
                    available = false;
                    while(!available)
                    {
                        try
                        {
                            System.out.print("请输入销售额和提成比率(销售额 提成比率):");
                            grossSales = sc.nextDouble();
                            commissionRate = sc.nextDouble();
                            available = true;
                        }
                        catch (Exception e)
                        {
                            System.err.println("输入错误,请重试!");
                            sc.nextLine();
                        }
                    }
                    e3.setGrossSales(grossSales);
                    e3.setCommissionRate(commissionRate);
                    while(addEmployee(e3) == null)
                    {
                        System.err.println("此员工已存在");
                        Thread.sleep(5);
                        System.out.print("请重新输入社会保障号:");
                        e3 = new CommissionEmployee(essential[0],essential[1],sc.next());
                        e3.setGrossSales(grossSales);
                        e3.setCommissionRate(commissionRate);
                    }
                    break;

                case 4:
                    BasePlusCommissionEmployee e4 = new BasePlusCommissionEmployee(essential[0],essential[1],essential[2]);
                    grossSales = 0;
                    commissionRate = 0;
                    double base = 0;
                    available = false;
                    while(!available)
                    {
                        try
                        {
                            System.out.print("请输入销售额、提成比率和基本工资(销售额 提成比率 基本工资):");
                            grossSales = sc.nextDouble();
                            commissionRate = sc.nextDouble();
                            base = sc.nextDouble();
                            available = true;
                        }
                        catch (Exception e)
                        {
                            System.err.println("输入错误,请重试!");
                            sc.nextLine();
                        }
                    }
                    e4.setGrossSales(grossSales);
                    e4.setCommissionRate(commissionRate);
                    e4.setBaseSalary(base);
                    while(addEmployee(e4) == null)
                    {
                        System.err.println("此员工已存在");
                        Thread.sleep(5);
                        System.out.print("请重新输入社会保障号:");
                        e4 = new BasePlusCommissionEmployee(essential[0],essential[1],sc.next());
                        e4.setGrossSales(grossSales);
                        e4.setCommissionRate(commissionRate);
                        e4.setBaseSalary(base);
                    }
                    break;
            }
            System.out.println("");
        }
    }

    public Employee getEmployee(String empSecNum)
    {
        return this.employees.get(empSecNum);
    }

    public Employee deleteEmployee(String empSecNum)
    {
        return this.employees.remove(empSecNum);
    }

    private Employee addEmployee(Employee stu)
    {
        if (getEmployee(stu.getSocialSecurityNumber()) != null)
            return null;
        this.employees.put(stu.getSocialSecurityNumber(), stu);
        return stu;
    }

    public Employee updateEmployee(String empSecNum ,Employee emp)
    {
        return this.employees.put(empSecNum,emp);
    }

    public void printEmployees()
    {
        Iterator iter = this.employees.entrySet().iterator();
        int i=1;
        while (iter.hasNext())
        {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(String.valueOf(i++) + " " + entry.getValue().toString());
        }
    }
}
