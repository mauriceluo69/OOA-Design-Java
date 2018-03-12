package homework7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class simpleStrategyui extends JFrame implements ActionListener {
	private Controller controller;

	private int strategykind;
	private int kind;
	private String strategynumber;

	private JTextField nameTextField;
	private JTextField integerTextField;
	private JTextField decimalTextField;
	private JButton reset = new JButton("重置");
	private JButton submit = new JButton("确定");
	private JLabel nameLable = new JLabel("策略名称:", JLabel.CENTER);
	private JLabel valueLable;
	private JLabel pointLable = new JLabel(".", JLabel.CENTER);
	private JLabel typeLable = new JLabel("适用类型:", JLabel.CENTER);
	private JRadioButton type1 = new JRadioButton("非教材类计算机图书");
	private JLabel zeroLable = new JLabel("0.", JLabel.CENTER);
	private JLabel yuanLable = new JLabel("元", JLabel.CENTER);
	private JRadioButton type2 = new JRadioButton("教材类图书");
	private JRadioButton type3 = new JRadioButton("连环画类图书");
	private JRadioButton type4 = new JRadioButton("养生类图书");
	private ButtonGroup typegroup = new ButtonGroup();
	private strategiesui object;

	public simpleStrategyui(strategiesui _object, Controller _controller, int _strategykind, int _kind, String _strategynumber)
	{
		object = _object;
		controller = _controller;
		kind = _kind;
		strategykind = _strategykind;
		strategynumber = _strategynumber;

		JPanel panel = new JPanel();
		setLayout(new FlowLayout());//FlowLayout组件按照加入的先后顺序按照设置的对齐方式从左向右排列，一行排满到下一行开始继续排列
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(290, 202);
		setResizable(false);

		//附加功能：依屏幕尺寸居中显示窗口：
		Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
		Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
		int screenWidth = screenSize.width;                     //获取屏幕的宽
		int screenHeight = screenSize.height;                   //获取屏幕的高
		setLocation(screenWidth / 2 - 297 / 2, screenHeight / 2 - 230 / 2); //设置窗口居中显示

		if (kind == 2)
		{
			nameTextField = new JTextField(PricingStrategyFactory.getlnstance().getStrategy(strategynumber).getname(),15);
			integerTextField = new JTextField((int)PricingStrategyFactory.getlnstance().getStrategy(strategynumber).getnumber() + "",2);
			decimalTextField = new JTextField(getdecimal(PricingStrategyFactory.getlnstance().getStrategy(strategynumber).getnumber()),2);
			switch (PricingStrategyFactory.getlnstance().getStrategy(strategynumber).gettype()) {
				case 1:
					type1.setSelected(true);
					break;

				case 2:
					type2.setSelected(true);
					break;

				case 3:
					type3.setSelected(true);
					break;

				case 4:
					type4.setSelected(true);
					break;
			}
		}
		else
		{
			integerTextField = new JTextField(2);
			decimalTextField = new JTextField(2);
			nameTextField = new JTextField(15);
		}

		typegroup.add(type1);
		typegroup.add(type2);
		typegroup.add(type3);
		typegroup.add(type4);

		add(nameLable);
		add(nameTextField);
		add(typeLable);
		add(type1);
		add(type2);
		add(type3);
		add(type4);
		if (strategykind == 1)
		{
			setTitle("添加绝对值优惠策略");
			valueLable = new JLabel("优惠价格:", JLabel.CENTER);
			add(valueLable);
			add(integerTextField);
			add(pointLable);
			add(decimalTextField);
			add(yuanLable);
		}
		else
		{
			setTitle("添加比例优惠策略");
			valueLable = new JLabel("优惠比例:", JLabel.CENTER);
			add(valueLable);
			add(zeroLable);
			decimalTextField.setColumns(4);
			add(decimalTextField);
		}
		add(submit);

		submit.addActionListener(this);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (!isNumeric(decimalTextField.getText()))
		{
			javax.swing.JOptionPane.showMessageDialog(null, "输入错误！添加失败。");
			decimalTextField.setText("");
		}
		else
		{
			boolean flag = true;
			if (strategykind == 1)
			{
				if (!isNumeric(integerTextField.getText()))
				{
					javax.swing.JOptionPane.showMessageDialog(null, "输入错误！添加失败。");
					integerTextField.setText("");
					flag = false;
				}
			}
			if (flag == true)
			{
				String _name = nameTextField.getText();
				double a =  Double.valueOf("0." + decimalTextField.getText()).doubleValue();
				if (strategykind == 1)
				{
					a +=  Integer.parseInt(integerTextField.getText());
				}

				int b;
				if (type1.isSelected())
				{
					b = 1;
				}
				else if (type2.isSelected())
				{
					b = 2;
				}
				else if (type3.isSelected())
				{
					b = 3;
				}
				else if (type4.isSelected())
				{
					b = 4;
				}
				else
				{
					javax.swing.JOptionPane.showMessageDialog(null, "请选择适用类型。");
					b = -1;
				}

				if (b != -1)
				{
					if (kind == 1)
					{
						if (strategykind == 1)
						{
							controller.AddSimpleStrategy(2, a, b, _name);
						}
						else
						{
							controller.AddSimpleStrategy(1, a, b, _name);
						}
					}
					else
					{
						if (strategykind == 1)
						{
							controller.updateSimpleStrategy(strategynumber, a, b, _name);
						}
						else
						{
							controller.updateSimpleStrategy(strategynumber, a, b, _name);
						}
					}

					object.update();
					dispose();
				}
			}
		}
	}

	public boolean isNumeric(String str) //检测字符串是只含整数
	{
		for (int i = str.length() ; --i >= 0 ; )
		{
			if (!Character.isDigit(str.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}

	public String getdecimal(double b)
	{
		String c = b + "";
		String d = c.substring(c.indexOf(".") + 1, c.length());
		return d;
	}
}
