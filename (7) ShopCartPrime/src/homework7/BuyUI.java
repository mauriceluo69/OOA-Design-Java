package homework7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class BuyUI extends JFrame implements ActionListener
{

	private Controller controller;
	private ArrayList <BookSpecification> books;
	private Shoppingcart shoppingcart;

	private JTextField isbnTextField = new JTextField(15);
	private JTextField numberTextField = new JTextField(15);
	private JButton buy = new JButton("购买");
	private JLabel plainLable = new JLabel("", JLabel.CENTER);
	private JLabel plainLable1 = new JLabel("", JLabel.CENTER);
	private JLabel plainLable2 = new JLabel("", JLabel.CENTER);
	private JLabel plainLable3 = new JLabel("", JLabel.CENTER);
	private JLabel plainLable4 = new JLabel("", JLabel.CENTER);
	private JLabel isbn1Lable = new JLabel("isbn号", JLabel.CENTER);
	private JLabel nameLable = new JLabel("书名", JLabel.CENTER);
	private JLabel priceLable = new JLabel("单价", JLabel.CENTER);
	private JLabel isbn2Lable = new JLabel("isbn号:", JLabel.CENTER);
	private JLabel numberLable = new JLabel("数量:", JLabel.CENTER);
	private JLabel benLable = new JLabel("本	", JLabel.LEFT);

	private MainUI object;

	public BuyUI(MainUI _object,Controller _controller)
	{
		object=_object;
		object.setEnabled(false);
		controller = _controller;
		books = BookCatalog.getlnstance().getbooks();

		setTitle("Buy");
		JPanel panel = new JPanel();
		setLayout(new GridLayout(books.size() + 5, 3));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(465, 31*(5+books.size()));

		Toolkit kit = Toolkit.getDefaultToolkit();          			    //定义工具包
		Dimension screenSize = kit.getScreenSize();       			        //获取屏幕的尺寸
		int screenWidth = screenSize.width;                			        //获取屏幕的宽
		int screenHeight = screenSize.height;                 			    //获取屏幕的高
		setLocation(screenWidth / 2 - 465 / 2, screenHeight / 2 - 31*(5+books.size()) / 2); //设置窗口居中显示

		add(isbn1Lable);
		add(nameLable);
		add(priceLable);
		for (BookSpecification value : books)
		{
			JLabel a = new JLabel(value.getisbn(), JLabel.CENTER);
			add(a);
			JLabel b = new JLabel(value.gettitle(), JLabel.CENTER);
			add(b);
			JLabel c = new JLabel(value.getprice() + "", JLabel.CENTER);
			add(c);
		}

		if(books.isEmpty())
			plainLable1.setText("当前没有图书");

		add(plainLable1);
		add(plainLable2);
		add(plainLable3);
		add(isbn2Lable);
		add(isbnTextField);
		add(plainLable);
		add(numberLable);
		add(numberTextField);
		add(benLable);
		add(plainLable4);
		add(buy);
		buy.addActionListener(this);
		setVisible(true);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				object.setEnabled(true);
			}
		});
	}

	public void actionPerformed(ActionEvent e)
	{
		if(isbnTextField.getText().isEmpty()||numberTextField.getText().isEmpty()||!isNumeric(numberTextField.getText()))
		{
			javax.swing.JOptionPane.showMessageDialog(null, "输入错误! 请注意所有输入不能为空，数量必须为数字。");
			numberTextField.setText("");
		}
		else
		{
			controller.buyBook(isbnTextField.getText(), Integer.parseInt(numberTextField.getText()));
			isbnTextField.setText("");
			numberTextField.setText("");
		}
	}

	public boolean isNumeric(String str) //检测字符串是只含整数
	{
		for (int i = str.length() ; --i >= 0 ; )
			if (!Character.isDigit(str.charAt(i)))
				return false;
		return true;
	}
}
