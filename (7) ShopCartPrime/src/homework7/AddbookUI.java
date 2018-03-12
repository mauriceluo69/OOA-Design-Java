package homework7;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class AddbookUI extends JFrame implements ActionListener {
    private Controller controller;

    private JTextField isbnTextField = new JTextField(20);
    private JTextField nameTextField = new JTextField(20);
    private JTextField integerTextField = new JTextField(9);
    private JTextField decimalTextField = new JTextField(9);
    private JTextField typeTextField = new JTextField(20);
    private JButton submit = new JButton("确定");
    private JLabel isbnLable = new JLabel("isbn:", JLabel.CENTER);
    private JLabel nameLable = new JLabel("name:", JLabel.CENTER);
    private JLabel priceLable = new JLabel("price:", JLabel.CENTER);
    private JLabel pointLable = new JLabel(".", JLabel.CENTER);
    private JLabel typeLable = new JLabel("type:", JLabel.CENTER);
    private JLabel yuanLable = new JLabel("元", JLabel.CENTER);

    private MainUI object;

    public AddbookUI(MainUI _object, Controller _controller) {
        object = _object;
        object.setEnabled(false);
        controller = _controller;
        setTitle("Addbook");
        JPanel panel = new JPanel();
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(500, 500);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setLocation(screenWidth / 2 - 500 / 2, screenHeight / 2 - 500 / 2);

        JPanel isbn = new JPanel();
        isbn.add(isbnLable);
        isbn.add(isbnTextField);
        add(isbn);

        JPanel name = new JPanel();
        name.add(nameLable);
        name.add(nameTextField);
        add(name);

        JPanel money = new JPanel();
        money.add(priceLable);
        money.add(integerTextField);
        money.add(pointLable);
        money.add(decimalTextField);
        money.add(yuanLable);
        add(money);

        JPanel type = new JPanel();
        type.add(typeLable);
        type.add(typeTextField);
        add(type);

        JPanel button = new JPanel();
        button.add(submit);
        add(button);


        submit.addActionListener(this);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                object.setEnabled(true);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (!isNumeric(integerTextField.getText()) || !isNumeric(decimalTextField.getText()) || isbnTextField.getText().isEmpty() || nameTextField.getText().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "输入错误！请注意所有输入不能为空，价格的整数和小数输入必须全为数字");
            integerTextField.setText("");
            decimalTextField.setText("");
        } else {
            double a = Integer.parseInt(integerTextField.getText()) + Double.valueOf("0." + decimalTextField.getText()).doubleValue();
            controller.Addbook(isbnTextField.getText(), a, nameTextField.getText(), Integer.parseInt(typeTextField.getText()));
            object.setEnabled(true);
            dispose();
        }
    }

    public boolean isNumeric(String str)  //检测字符串是只含整数
    {
        if (str.isEmpty())
            return false;
        for (int i = str.length(); --i >= 0; )
            if (!Character.isDigit(str.charAt(i)))
                return false;
        return true;
    }
}