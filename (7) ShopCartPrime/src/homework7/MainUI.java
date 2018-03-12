package homework7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame implements ActionListener {

	private JPanel welcome = new JPanel();
	private JMenuBar bar = new JMenuBar();
	private JMenu AddbookMenu = new JMenu("Addbook");
	private JMenu StrategiesMenu = new JMenu("Strategies");
	private JMenu BuyMenu = new JMenu("Buy");
	private JMenuItem AddbookItem = new JMenuItem("Addbook");
	private JMenuItem StrategiesItem = new JMenuItem("Strategies");
	private JMenuItem BuyItem = new JMenuItem("Buy");
	private JLabel Lable1 = new JLabel("Welcome to Shopping Cart Prime");

	private Controller controller;

	public MainUI()
	{
		controller = new Controller();
		setTitle("MainUI");

		AddbookMenu.add(AddbookItem);
		StrategiesMenu.add(StrategiesItem);
		BuyMenu.add(BuyItem);

		bar.add(AddbookMenu);
		bar.add(StrategiesMenu);
		bar.add(BuyMenu);

		setJMenuBar(bar);

		AddbookItem.addActionListener(this);
		StrategiesItem.addActionListener(this);
		BuyItem.addActionListener(this);

		setLayout(new GridLayout(3, 2));

		setLayout(new FlowLayout());
		welcome.add(Lable1);
		add(welcome);
		welcome.setBackground(Color.getHSBColor(232,453,534));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setBackground(Color.blue);
		setVisible(true);

		Toolkit kit = Toolkit.getDefaultToolkit();          			    //定义工具包
		Dimension screenSize = kit.getScreenSize();       			        //获取屏幕的尺寸
		int screenWidth = screenSize.width;                			        //获取屏幕的宽
		int screenHeight = screenSize.height;                 			    //获取屏幕的高
		setLocation(screenWidth / 2 - 600 / 2, screenHeight / 2 - 400 / 2); //设置窗口居中显示
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == AddbookItem)
		{
			AddbookUI addbookui = new AddbookUI(this,controller);
		}
		if (e.getSource() == StrategiesItem)
		{
			strategiesui _strategiesui = new strategiesui(this,controller);
		}
		if (e.getSource() == BuyItem)
		{
			BuyUI buyui = new BuyUI(this,controller);
		}
	}

	public void testbuybook(String _isbn, int _copies)
	{
		controller.buyBook(_isbn, _copies);
	}
}
