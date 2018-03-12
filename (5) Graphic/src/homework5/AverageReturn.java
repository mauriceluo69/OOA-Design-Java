package homework5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AverageReturn extends JFrame implements ActionListener
{
    private JLabel aver = new JLabel("平均工资:");
    private JLabel averearn = new JLabel();
    private JButton close = new JButton("Close");

    public AverageReturn(double m)
    {
        JPanel a = new JPanel();
        a.add(aver);
        averearn.setText(Double.toString(m));
        a.add(averearn);
        add(a);


        JPanel button = new JPanel();
        button.add(close);
        add(button);

        close.addActionListener(this);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2,1));
        setSize(300,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == close)
            dispose();
    }
}
