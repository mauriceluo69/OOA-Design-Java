package homework7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Shoppingcart extends JFrame implements Observer {

	private ArrayList < SaleLineItem > shopbook;
	private JLabel nameLable = new JLabel("书名:", JLabel.CENTER);
	private JLabel copiesLable = new JLabel("数量:", JLabel.CENTER);
	private JLabel plain1Lable = new JLabel("", JLabel.CENTER);
	private JLabel plain2Lable = new JLabel("", JLabel.CENTER);
	private JLabel plain3Lable = new JLabel("", JLabel.CENTER);
	private JLabel totalpriceLable = new JLabel("数量:", JLabel.CENTER);
	private JPanel panel = new JPanel();
	private ArrayList < JLabel > labels=new ArrayList < JLabel >();

	private Sale subject;
	private DecimalFormat df = new DecimalFormat("0.00");

	public Shoppingcart(Sale _subject)
	{
		subject= _subject;
		setTitle("Shoppingcart");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		shopbook = _subject.getitems();
		setSize(230,31*(shopbook.size() + 3));
		setResizable(false);
		setLayout(new GridLayout(shopbook.size() + 3, 2));
		add(nameLable);
		add(copiesLable);
		for (SaleLineItem value : shopbook)
		{
			JLabel titlelable = new JLabel(value.gettitle(), JLabel.CENTER);
			add(titlelable);
			labels.add(titlelable);
			JLabel copieslable = new JLabel(value.getcopies()+"", JLabel.CENTER);
			add(copieslable);
			labels.add(copieslable);
		}
		add(plain1Lable);
		add(plain2Lable);
		add(plain3Lable);
		totalpriceLable.setText("总价："+df.format(_subject.getTotal()));
		add(totalpriceLable);

		Toolkit kit = Toolkit.getDefaultToolkit();          			    //定义工具包
		Dimension screenSize = kit.getScreenSize();       			        //获取屏幕的尺寸
		int screenWidth = screenSize.width;                			        //获取屏幕的宽
		int screenHeight = screenSize.height;                 			    //获取屏幕的高
		setLocation(screenWidth / 2 - 300 / 2, screenHeight / 2 - 200 / 2); //设置窗口居中显示

		setVisible(false);
	}

	public void update(Sale _subject)
	{
		subject= _subject;
		shopbook=_subject.getitems();
		for (JLabel value : labels)
		{
			remove(value);
		}
		labels.clear();
		remove(plain1Lable);
		remove(plain2Lable);
		remove(plain3Lable);
		remove(totalpriceLable);
		for (SaleLineItem value : shopbook)
		{
			JLabel titlelable = new JLabel(value.gettitle(), JLabel.CENTER);
			add(titlelable);
			labels.add(titlelable);
			JLabel copieslable = new JLabel(value.getcopies()+"", JLabel.CENTER);
			add(copieslable);
			labels.add(copieslable);
		}
		add(plain1Lable);
		add(plain2Lable);
		add(plain3Lable);
		totalpriceLable.setText("总价："+df.format(_subject.getTotal()));
		add(totalpriceLable);
		setResizable(true);
		setLayout(new GridLayout(shopbook.size() + 3, 2));
		setSize(230,31*(shopbook.size() + 3));
		setResizable(false);
		setVisible(true);
	}
}
