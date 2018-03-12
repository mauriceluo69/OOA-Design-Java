package homework5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Graphic extends JFrame implements ActionListener
{
    private JMenuBar bar = new JMenuBar();

    private JPanel panel = new JPanel();

    private JMenu employeeInfoInput = new JMenu("EmployeeInfoInput");
    private JMenu search = new JMenu("Search");

    private JMenuItem commissionEmployee = new JMenuItem("CommissionEmployee");
    private JMenuItem basePlusCommissionEmployee = new JMenuItem("BasePlusCommissionEmployee");
    private JMenuItem averageEarningSearch = new JMenuItem("AverageEarningSearch");

    public static ArrayList<Employee> employees = new ArrayList<Employee>();

    public Graphic()
    {
        setTitle("Record and Search");
        employeeInfoInput.add(commissionEmployee);
        employeeInfoInput.add(basePlusCommissionEmployee);
        search.add(averageEarningSearch);
        bar.add(employeeInfoInput);
        bar.add(search);
        setJMenuBar(bar);
        panel.setBackground(Color.cyan);
        add(panel);

        commissionEmployee.addActionListener(this);
        basePlusCommissionEmployee.addActionListener(this);
        averageEarningSearch.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,600);
        setVisible(true);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == commissionEmployee)
        {
            getInfo a = new getInfo(0);
        }

        if(e.getSource() == basePlusCommissionEmployee)
        {
            getInfo a = new getInfo(1);
        }

        if(e.getSource() == averageEarningSearch)
        {
            AverageReturn a = new AverageReturn(getSum()/employees.size());
        }
    }

    public double getSum()
    {
        double sum = 0;
        for(int i=0 ; i<employees.size() ; i++)
            sum += employees.get(i).earning();
        return sum;
    }

    public static void main(String[] args)
    {
        Graphic a = new Graphic();
        while(true)
        {
            for(int i = 0; i<a.getEmployees().size(); i++)
                System.out.println("num:" + a.getEmployees().size() + "\tsum:" + a.getSum());
        }
    }

}
