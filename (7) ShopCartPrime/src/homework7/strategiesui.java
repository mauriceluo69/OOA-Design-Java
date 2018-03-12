package homework7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class strategiesui extends JFrame implements ActionListener{
	private Controller controller;

	private HashMap < String, IPricingStrategy > strategies;
	private HashMap < Integer, String > RecordOps = new HashMap < Integer, String >();

	private JScrollPane scrollPane = new JScrollPane();

	private JButton addPercentateStrategyButton = new JButton("添加百分比折扣策略");
	private JButton addFlatRateStrategyButton = new JButton("添加绝对值优惠策略");
	private JButton addCompositeStrategyButton = new JButton("添加组合策略");
	private JButton delButton = new JButton("删除所选策略");
	private JButton editButton = new JButton("编辑所选策略");
	private JLabel optionLable = new JLabel("选项", JLabel.CENTER);
	private JLabel numberLable = new JLabel("策略编号", JLabel.CENTER);
	private JLabel nameLable = new JLabel("策略名称", JLabel.CENTER);
	private JLabel strategytypeLable = new JLabel("策略类型", JLabel.CENTER);
	private JLabel typeLable = new JLabel("适用图书类型", JLabel.CENTER);
	private JLabel valueLable = new JLabel("折扣百分比/每本优惠额度", JLabel.CENTER);
	private JLabel plainLable1 = new JLabel("", JLabel.CENTER);
	private JLabel plainLable2 = new JLabel("", JLabel.CENTER);
	private JLabel plainLable3 = new JLabel("", JLabel.CENTER);
	private JLabel plainLable4 = new JLabel("", JLabel.CENTER);
	private JLabel plainLable5 = new JLabel("", JLabel.CENTER);
	private JLabel plainLable6 = new JLabel("", JLabel.CENTER);
	private ArrayList <JRadioButton> radiobuttons = new ArrayList <JRadioButton>();;
	private ButtonGroup typegroup = new ButtonGroup();
	private ArrayList < JLabel > labels=new ArrayList < JLabel >();
	
	private MainUI object;
	
	public strategiesui(MainUI _object,Controller _controller) 
	{
		object=_object;
		object.setEnabled(false);
		JPanel panel = new JPanel();
		int opnumber = 1;
		controller = _controller;
		strategies = PricingStrategyFactory.getlnstance().getStrategies();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		add(optionLable);
		add(numberLable);
		add(nameLable);
		add(strategytypeLable);
		add(typeLable);
		add(valueLable);
		paint();
		addPercentateStrategyButton.addActionListener(this);
		addFlatRateStrategyButton.addActionListener(this);
		addCompositeStrategyButton.addActionListener(this);
		delButton.addActionListener(this);
		editButton.addActionListener(this);
		addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent e) 
        	{
        		object.setEnabled(true);
        	}
        	});
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == addPercentateStrategyButton) 
		{
			simpleStrategyui a = new simpleStrategyui(this,controller, 2, 1, "");
		}
		if (e.getSource() == addFlatRateStrategyButton) 
		{
			simpleStrategyui a = new simpleStrategyui(this,controller, 1, 1, "");
		}
		if (e.getSource() == addCompositeStrategyButton) 
		{
			CopositeStrategyui a = new CopositeStrategyui(this,controller, 1, 1, "");
		}
		if (e.getSource() == delButton) 
		{
			int op = 1;
			for ( JRadioButton value : radiobuttons) 
			{
				if (value.isSelected()) 
				{
					controller.deleteStrategy(RecordOps.get(op));
				}
				op++;
			}
			update();
		}
		if (e.getSource() == editButton) 
		{
			int op = 1;
			for ( JRadioButton value : radiobuttons) 
			{
				if (value.isSelected()) 
				{
					switch (PricingStrategyFactory.getlnstance().getStrategy(RecordOps.get(op)).getStrategytype()) 
					{
						case 1:
							simpleStrategyui a = new simpleStrategyui(this,controller, 2, 2, RecordOps.get(op));
							break;
							
						case 2:
							simpleStrategyui b = new simpleStrategyui(this,controller, 1, 2, RecordOps.get(op));
							break;
							
						case 3:
							CopositeStrategyui c = new CopositeStrategyui(this,controller, 1, 2, RecordOps.get(op));
							break;
					}
				}
				op++;
			}
		}
	}
	
	public void update()
	{
		for (JLabel value : labels) 
		{
	    	remove(value);
	    }
	    labels.clear();
	    for (JRadioButton value : radiobuttons) 
	    {
	    	remove(value);
	    }
	    radiobuttons.clear();
	    plainLable1.setText("");
	    remove(plainLable1);
		remove(plainLable2);
		remove(plainLable3);
		remove(plainLable4);
		remove(plainLable5);
		remove(plainLable6);
	    remove(addPercentateStrategyButton);
	    remove(addFlatRateStrategyButton);
	    remove(addCompositeStrategyButton);
	    remove(delButton);
	    remove(editButton);
	    RecordOps.clear();
	    paint();
	}
	
	public void paint()
	{
		int opnumber = 1;
		strategies = PricingStrategyFactory.getlnstance().getStrategies();
		
	    for ( Entry < String, IPricingStrategy > value : strategies.entrySet()) 
	    {
	    	System.out.println("您提前结束了输入。");
	    	JRadioButton button = new JRadioButton("");
			button.setHorizontalAlignment(SwingConstants.CENTER);
			add(button);
			radiobuttons.add(button);
			typegroup.add(button);
			RecordOps.put(opnumber, value.getKey());
			String strategytype;
			switch (value.getValue().getStrategytype()) 
			{
				case 1:
					strategytype = "百分比折扣策略";
					break;
					
				case 2:
					strategytype = "绝对值优惠策略";
					break;
					
				case 3:
					strategytype = "组合策略";
					break;
					
				default:
					strategytype = "无优惠策略";
					break;
			}
			
			JLabel bLable = new JLabel(value.getKey(), JLabel.CENTER);
			JLabel cLable = new JLabel(value.getValue().getname(), JLabel.CENTER);
			JLabel aLable = new JLabel(strategytype, JLabel.CENTER);
			JLabel dLable = new JLabel(value.getValue().gettype() + "", JLabel.CENTER);
			JLabel eLable = new JLabel(value.getValue().getnumber() + "", JLabel.CENTER);
			add(bLable);
			add(cLable);
			add(aLable);
			add(dLable);
			add(eLable);
			labels.add(bLable);
			labels.add(cLable);
			labels.add(aLable);
			labels.add(dLable);
			labels.add(eLable);
			opnumber++;
		}
	    
	    if(strategies.isEmpty())
	    {
			plainLable1.setText("当前没有策略");
		}
		add(plainLable1);		
		add(plainLable2);		
		add(plainLable3);		
		add(plainLable4);		
		add(plainLable5);		
		add(plainLable6);
		add(addPercentateStrategyButton);
		add(addFlatRateStrategyButton);
		add(addCompositeStrategyButton);
		add(delButton);
		add(editButton);

		setTitle("strategies");
		setResizable(true);
		setLayout(new GridLayout(strategies.size() + 3, 6));
		setSize(931, 31*(strategies.size() + 3));
		setResizable(false);
		setVisible(true);

		//附加功能：依屏幕尺寸居中显示窗口：
		Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
		Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
		int screenWidth = screenSize.width;                     //获取屏幕的宽
		int screenHeight = screenSize.height;                   //获取屏幕的高
		setLocation(screenWidth / 2 - 931 / 2, screenHeight / 2 - 31*(strategies.size() + 3) / 2); //设置窗口居中显示
	}
}