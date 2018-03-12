package homework5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class getInfo extends JFrame implements ActionListener
{
    private int kind;
    private JButton reset = new JButton("重置");
    private JButton submit = new JButton("确定");

    private JLabel firstnameLable = new JLabel("名:", JLabel.CENTER);
    private JLabel lastnameLable = new JLabel("姓:", JLabel.CENTER);
    private JLabel socialSecurityNumberLable = new JLabel("工号:", JLabel.CENTER);
    private JLabel grossSalesLable = new JLabel("总销售额:", JLabel.CENTER);
    private JLabel commissionRateLable = new JLabel("比例:", JLabel.CENTER);
    private JLabel baseSalaryLable = new JLabel("基本工资:", JLabel.CENTER);
    private JLabel warning = new JLabel("");

    private JTextField lastName = new JTextField(15);
    private JTextField firstName = new JTextField(15);
    private JTextField grossSales = new JTextField(15);
    private JTextField commissionRate = new JTextField(15);
    private JTextField socialSecurityNumber = new JTextField(15);
    private JTextField baseSalary = new JTextField(15);

    //private ArrayList<Employee> employees = new ArrayList<Employee>();

    public getInfo(int _kind)
    {//0-Commission 1-BasePlus
        this.kind = _kind;
        setTitle("录入信息");
        setLayout(new FlowLayout());

        JPanel last = new JPanel();
        JPanel first = new JPanel();
        JPanel social = new JPanel();
        JPanel gross = new JPanel();
        JPanel commi = new JPanel();

        last.add(lastnameLable);
        last.add(lastName);
        first.add(firstnameLable);
        first.add(firstName);
        social.add(socialSecurityNumberLable);
        social.add(socialSecurityNumber);
        gross.add(grossSalesLable);
        gross.add(grossSales);
        commi.add(commissionRateLable);
        commi.add(commissionRate);

        add(last,new FlowLayout());
        add(first,new FlowLayout());
        add(social,new FlowLayout());
        add(gross,new FlowLayout());
        add(commi,new FlowLayout());

        if(this.kind == 1)
        {
            JPanel base = new JPanel();
            base.add(baseSalaryLable);
            base.add(baseSalary);
            add(base,new FlowLayout());
        }

        JPanel warn = new JPanel();
        warn.add(warning);
        add(warn,BorderLayout.CENTER);

        JPanel button = new JPanel();
        button.add(submit);
        button.add(reset);
        add(button,BorderLayout.SOUTH);

        submit.addActionListener(this);
        reset.addActionListener(this);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8,1));
        setSize(600,400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == submit)
        {
            if(this.kind == 0)
            {//0-Commission
                try
                {
                    CommissionEmployee a = new CommissionEmployee(
                            this.firstName.getText(),
                            this.lastName.getText(),
                            this.socialSecurityNumber.getText());
                    a.setGrossSales(Double.valueOf(this.grossSales.getText()));
                    a.setCommissionRate(Double.valueOf(this.commissionRate.getText()));
                    Graphic.employees.add(a);
                    setVisible(false);
                    //dispose();
                }
                catch(Exception exc)
                {
                    warning.setText("输入错误,请重新输入");
                    this.firstName.setText("");
                    this.lastName.setText("");
                    this.socialSecurityNumber.setText("");
                    this.grossSales.setText("");
                    this.commissionRate.setText("");
                }
            }
            else
            {//1-BasePlus
                try
                {
                    BasePlusCommissionEmployee a = new BasePlusCommissionEmployee(
                            this.firstName.getText(),
                            this.lastName.getText(),
                            this.socialSecurityNumber.getText());
                    a.setGrossSales(Double.valueOf(this.grossSales.getText()));
                    a.setCommissionRate(Double.valueOf(this.commissionRate.getText()));
                    a.setBaseSalary(Double.valueOf(this.baseSalary.getText()));
                    Graphic.employees.add(a);
                    setVisible(false);
                    //dispose();
                }
                catch(Exception exc)
                {
                    warning.setText("输入错误,请重新输入");
                    this.firstName.setText("");
                    this.lastName.setText("");
                    this.socialSecurityNumber.setText("");
                    this.grossSales.setText("");
                    this.commissionRate.setText("");
                    this.baseSalary.setText("");
                }
            }
        }

        if(e.getSource() == reset)
        {
            this.firstName.setText("");
            this.lastName.setText("");
            this.socialSecurityNumber.setText("");
            this.grossSales.setText("");
            this.commissionRate.setText("");
            if(this.kind == 1)
                this.baseSalary.setText("");
        }
    }
}
