package homework7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class CopositeStrategyui extends JFrame implements ActionListener {
	private Controller controller;

	private int strategykind;
	private int kind;
	private String strategynumber;
	private HashMap < String, IPricingStrategy > strategies;
	private HashMap < Integer, String > RecordOps = new HashMap < Integer, String >();

	private JButton reset = new JButton("重置");
	private JButton submit = new JButton("确定");
	private JLabel strategyLable = new JLabel("选择策略：", JLabel.CENTER);
	private JTextField nameTextField;
	private JLabel nameLable = new JLabel("策略名称:", JLabel.CENTER);
	private JLabel typeLable = new JLabel("适用类型:", JLabel.CENTER);
	private JLabel plainLable = new JLabel("", JLabel.CENTER);
	private JRadioButton type1 = new JRadioButton("非教材类计算机图书");
	private JRadioButton type2 = new JRadioButton("教材类图书");
	private JRadioButton type3 = new JRadioButton("连环画类图书");
	private JRadioButton type4 = new JRadioButton("养生类图书");

	private ButtonGroup typegroup = new ButtonGroup();
	private ArrayList <JCheckBox> checkboxes = new ArrayList <JCheckBox>();
	private strategiesui object;

	public CopositeStrategyui(strategiesui _object,Controller _controller, int _strategykind, int _kind, String _strategynumber)
	{
		object=_object;
		controller = _controller;
		kind = _kind;
		strategykind = _strategykind;
		strategynumber = _strategynumber;
		strategies = PricingStrategyFactory.getlnstance().getStrategies();

		int opnumber = 1;
		JPanel panel = new JPanel();
		setTitle("添加复合策略");
		setLayout(new GridLayout((1+strategies.size())/2+4, 2));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(305, 33*((1+strategies.size())/2+4));


		//附加功能：依屏幕尺寸居中显示窗口：
		Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
		Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
		int screenWidth = screenSize.width;                     //获取屏幕的宽
		int screenHeight = screenSize.height;                   //获取屏幕的高
		setLocation(screenWidth / 2 - 305, screenHeight / 2 - 33*((1+strategies.size())/2+4) / 2); //设置窗口居中显示

		for (Entry < String, IPricingStrategy > value : strategies.entrySet())
		{
			if (kind == 1)
			{
				JCheckBox checkBox1 = new JCheckBox(value.getValue().getStrategynumber());
				checkBox1.setHorizontalAlignment(SwingConstants.CENTER);
				checkboxes.add(checkBox1);
				add(checkBox1);
			}
			else
			{
				if (PricingStrategyFactory.getlnstance().getStrategy(strategynumber).isin(value.getValue()))
				{
					JCheckBox checkBox1 = new JCheckBox(value.getValue().getStrategynumber(), true);
					checkBox1.setHorizontalAlignment(SwingConstants.CENTER);
					checkboxes.add(checkBox1);
					add(checkBox1);
				}
				else
				{
					JCheckBox checkBox1 = new JCheckBox(value.getValue().getStrategynumber(), false);
					checkBox1.setHorizontalAlignment(SwingConstants.CENTER);
					checkboxes.add(checkBox1);
					add(checkBox1);
				}
			}
			RecordOps.put(opnumber, value.getKey());
			opnumber++;
		}

		if(strategies.size()%2==1)
		{
			add(plainLable);
		}

		if (kind == 2)
		{
			nameTextField = new JTextField(PricingStrategyFactory.getlnstance().getStrategy(strategynumber).getname(),15);
			for ( Entry < String, IPricingStrategy > value : strategies.entrySet())
			{
				switch (PricingStrategyFactory.getlnstance().getStrategy(strategynumber).gettype())
				{
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
		}
		else
		{
			nameTextField = new JTextField(15);
		}

		add(nameLable);
		add(nameTextField);
		typegroup.add(type1);
		typegroup.add(type2);
		typegroup.add(type3);
		typegroup.add(type4);

		add(typeLable);
		type1.setHorizontalAlignment(SwingConstants.CENTER);
		type2.setHorizontalAlignment(SwingConstants.CENTER);
		type3.setHorizontalAlignment(SwingConstants.CENTER);
		type4.setHorizontalAlignment(SwingConstants.CENTER);
		add(type1);
		add(type2);
		add(type3);
		add(type4);
		add(submit);

		submit.addActionListener(this);
		reset.addActionListener(this);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String _name = nameTextField.getText();
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
			int op = 1;
			ArrayList < IPricingStrategy > strategies = new ArrayList < IPricingStrategy > ();

			for ( JCheckBox value : checkboxes)
			{
				if (value.isSelected())
				{
					strategies.add(PricingStrategyFactory.getlnstance().getStrategy(RecordOps.get(op)));
				}
				op++;
			}
			if (kind == 1)
			{
				controller.AddCompositeStrategy(strategies, _name, b);
			}
			else
			{
				controller.updateCompositeStrategy(strategynumber, strategies, _name, b);
			}

			object.update();
			dispose();
		}
	}
}