package homework4;

import java.util.*;

public class mainTest
{
    private static void printMenu()
    {
        System.out.print("\n功能如下:\n" + "1 按照社会保险号查询\n" + "2 更新信息\n"
        + "3 删除\n" + "4 打印全部员工信息\n" + "5 退出\n" + "请输入功能序号:");
    }

    public static void main(String[] args) throws InterruptedException
    {
        Scanner sc = new Scanner(System.in);
        Factory a = new Factory();
        a.initEmployees();
        System.out.println("初始化完成");
        int choice = 0;
        while(choice != 5)
        {
            printMenu();
            boolean available = false;
            while(!available)
            {
                try
                {
                    choice = sc.nextInt();
                    if(choice <= 0 || choice >5)
                        throw new Exception();
                    else
                        available = true;
                }
                catch(InputMismatchException e)
                {
                    System.err.print("输入错误，请重试:");
                    sc.nextLine();
                }
                catch(Exception e)
                {
                    System.err.print("输入错误，请重试:");
                }
            }
            switch(choice)
            {
                case 1:
                    System.out.print("请输入社会保险号:");
                    Employee temp1 = a.getEmployee(sc.next());
                    if(temp1 != null)
                        System.out.println(temp1.toString());
                    else
                        System.err.println("不存在该社会保险号");
                    break;

                case 2:
                    System.out.print("请输入社会保险号:");
                    Employee temp2 = a.getEmployee(sc.next());
                    if(temp2 != null)
                    {
                        if(temp2.getClass().getSimpleName().equals("SalaridEmployee"))
                        {
                            available = false;
                            while(!available)
                            {
                                try
                                {
                                    System.out.print("请输入名字(Firstname Lastname):");
                                    temp2.setFirstName(sc.next());
                                    temp2.setLastName(sc.next());
                                    System.out.print("请输入周薪:");
                                    ((SalaridEmployee) temp2).setWeeklySalary(sc.nextDouble());
                                    available = true;
                                }
                                catch(Exception e)
                                {
                                    System.err.println("输入错误,请重试:");
                                }
                            }
                        }

                        else if(temp2.getClass().getSimpleName().equals("HourlyEmployee"))
                        {
                            available = false;
                            while(!available)
                            {
                                try
                                {
                                    System.out.print("请输入名字(Firstname Lastname):");
                                    temp2.setFirstName(sc.next());
                                    temp2.setLastName(sc.next());
                                    System.out.print("请输入时薪和工作时长(时薪 工作时长)");
                                    ((HourlyEmployee) temp2).setWage(sc.nextDouble());
                                    ((HourlyEmployee) temp2).setHours(sc.nextInt());
                                    available = true;
                                }
                                catch(Exception e)
                                {
                                    System.err.println("输入错误,请重试:");
                                }
                            }
                        }

                        else if(temp2.getClass().getSimpleName().equals("CommissionEmployee"))
                        {
                            available = false;
                            while(!available)
                            {
                                try
                                {
                                    System.out.print("请输入名字(Firstname Lastname):");
                                    temp2.setFirstName(sc.next());
                                    temp2.setLastName(sc.next());
                                    System.out.print("请输入销售额和提成比率(销售额 提成比率):");
                                    ((CommissionEmployee) temp2).setGrossSales(sc.nextDouble());
                                    ((CommissionEmployee) temp2).setCommissionRate(sc.nextDouble());
                                    available = true;
                                }
                                catch(Exception e)
                                {
                                    System.err.println("输入错误,请重试:");
                                }
                            }
                        }

                        else if(temp2.getClass().getSimpleName().equals("BasePlusCommissionEmployee"))
                        {
                            available = false;
                            while(!available)
                            {
                                try
                                {
                                    System.out.print("请输入名字(Firstname Lastname):");
                                    temp2.setFirstName(sc.next());
                                    temp2.setLastName(sc.next());
                                    System.out.print("请输入销售额、提成比率和基本工资(销售额 提成比率 基本工资):");
                                    ((BasePlusCommissionEmployee) temp2).setGrossSales(sc.nextDouble());
                                    ((BasePlusCommissionEmployee) temp2).setCommissionRate(sc.nextDouble());
                                    ((BasePlusCommissionEmployee) temp2).setBaseSalary(sc.nextDouble());
                                    available = true;
                                }
                                catch(Exception e)
                                {
                                    System.err.println("输入错误,请重试:");
                                }
                            }
                        }

                        else
                            System.err.println("Not Found!");
                        a.updateEmployee(temp2.getSocialSecurityNumber() ,temp2);
                    }
                    else
                        System.err.println("不存在该社会保险号");
                    break;

                case 3:
                    System.out.print("请输入社会保险号:");
                    Employee temp3 = a.getEmployee(sc.next());
                    if(temp3 != null)
                        a.deleteEmployee(temp3.getSocialSecurityNumber());
                    else
                        System.err.println("不存在该社会保险号");
                    break;

                case 4:
                    a.printEmployees();
                    break;
            }
        }
        System.out.println("Goodbye!");
    }
}
