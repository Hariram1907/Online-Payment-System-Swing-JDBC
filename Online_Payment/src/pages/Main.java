package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class Main extends JFrame implements ActionListener
{
	Connection c;
	String user="";
	int otpp=0;
	int fpotp=0;
	String fpemail="";
	int amount=5000;
	Font font1=new Font("Calibri",Font.BOLD,22);
    Font font2=new Font("Calibri",Font.PLAIN,18);
    Font font3=new Font("Calibri",Font.BOLD,12);
	
	//Registration
	JPanel p_reg;
    JLabel lbl1_reg,lbl2_reg,lbl3_reg,lbl4_reg,lbl5_reg,lbl6_reg,lbl7_reg,lbl8_reg,lbl9_reg;
    JTextField tf1_reg,tf2_reg,tf4_reg;
    JPasswordField tf3_reg;
    JButton b1_reg,b2_reg,b3_reg,b4_reg;
    
    //Login
    JPanel p_log;
    JLabel lbl1_log,lbl2_log,lbl3_log,lbl4_log,lbl5_log,lbl6_log,lbl7_log;
    JTextField tf1_log;
    JPasswordField tf2_log;
    JButton b1_log,b2_log,b3_log;
    
    //forgot password
    JPanel p_fp;
    JLabel l1_fp,l2_fp,l3_fp,l4_fp,l5_fp;
    JPasswordField tf1_fp;
    JTextField tf2_fp;
    JButton b1_fp;
    
    //choose
    JLabel lbl1_pay,lbl2_pay,lbl3_pay,lbl4_pay;
    JButton b1_pay,b2_pay,b3_pay;
    JPanel p_pay;
    
    //payment
    JPanel p1_cd;
    JLabel l1_cd,l2_cd,l3_cd,l4_cd,l5_cd,l6_cd,l7_cd,l8_cd; 
    JTextField t1_cd,t3_cd;
    JPasswordField t2_cd;
    JComboBox j1_cd,j2_cd; 
    JButton b1_cd;
    String Y[]={"2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032"};
    String M[]={"Jan","FEB","MAR","APR","MAY","JUNE","JULY","AUG","OCT","NOV","DEC"};
    
    //payment1
    JPanel p1_ib;
    JLabel l1_ib,l2_ib,l3_ib,l4_ib,l5_ib,l6_ib;
    JTextField t1_ib,t3_ib;
    JPasswordField t2_ib;
    JComboBox j1_ib; 
    JButton b1_ib;
    String B[]={"State Bank of India","Indian Overseas Bank","Canara Bank","Indian Bank","Central Bank of India",
    "	Bank of Baroda","Union Bank of India","Axis Bank Ltd","ICICI Bank Ltd","City Union Bank Ltd"};
    
    //payment2
    JPanel p1_upi;
    JLabel l1_upi,l2_upi,l3_upi,l4_upi,l5_upi;
    JTextField t1_upi,t3_upi;
    JPasswordField t2_upi;
    JButton b1_upi;
    
    //Success
    JPanel p1_s;
    JLabel l1_s,l2_s;
    JButton b1_s,b2_s;
    ImageIcon icon_s;
    
    //Unsuccess
    JPanel p1_us;
    JLabel l1_us,l2_us;
    JButton b1_us,b2_us;
    ImageIcon icon_us;
    
    public Main()
    {
    	
    	String durl="jdbc:postgresql://localhost:5432/payment";
		try {	
			c = DriverManager.getConnection(durl,"Admin","1234");
			if(c!=null)
			{
				System.out.println("ok");
				Statement s= c.createStatement();
				String Sql="select*from login_details";
				ResultSet rs=s.executeQuery(Sql);
				while(rs.next())
						{
							String a=rs.getString("uname");
							String b=rs.getString("email");
							String p=rs.getString("password");
							int amt=rs.getInt("amount");
							System.out.println(a+" "+b+" "+p+" "+amt);
							
						}
			}
			}
			catch(Exception e)
			{
				System.out.println("not ok"+e);
			}
    	//Registration
    	p_reg=new JPanel();
        p_reg.setLayout(null);
        

        lbl1_reg=new JLabel("Online Payment Application");
        lbl1_reg.setFont(new Font("Calibri",Font.BOLD,24));
		lbl1_reg.setBounds(10,10,370,28);
        p_reg.add(lbl1_reg);

        lbl2_reg=new JLabel("Registration");
        lbl2_reg.setFont(font1);
		lbl2_reg.setBounds(100,50,370,28);
        p_reg.add(lbl2_reg);

        lbl3_reg=new JLabel("For a new user");
        lbl3_reg.setFont(font1);
		lbl3_reg.setBounds(20,90,370,28);
        p_reg.add(lbl3_reg);

        lbl4_reg=new JLabel("Enter username");
        lbl4_reg.setFont(font2);
		lbl4_reg.setBounds(20,130,370,28);
        p_reg.add(lbl4_reg);


        tf1_reg=new JTextField();
        tf1_reg.setFont(font2);
		tf1_reg.setBounds(20,160,260,28);
        p_reg.add(tf1_reg);


        lbl5_reg=new JLabel("Enter email id");
        lbl5_reg.setFont(font2);
		lbl5_reg.setBounds(20,190,370,28);
        p_reg.add(lbl5_reg);

        tf2_reg=new JTextField();
        tf2_reg.setFont(font2);
		tf2_reg.setBounds(20,220,260,28);
        p_reg.add(tf2_reg);

        lbl7_reg=new JLabel("Enter Password");
        lbl7_reg.setFont(font2);
		lbl7_reg.setBounds(20,250,370,28);
        p_reg.add(lbl7_reg);

        tf3_reg=new JPasswordField();
//        tf3_reg.setFont(font2);
		tf3_reg.setBounds(20,280,260,28);
        p_reg.add(tf3_reg);

        b2_reg=new JButton("Get OTP");
        b2_reg.setBounds(20,320,120,35);
		b2_reg.addActionListener(this);
		b2_reg.setBackground(new Color(255,255,255));
		p_reg.add(b2_reg);

        lbl8_reg=new JLabel("Enter the OTP");
        lbl8_reg.setFont(font2);
		lbl8_reg.setBounds(20,370,150,28);
        p_reg.add(lbl8_reg);
        
        tf4_reg=new JTextField();
        tf4_reg.setFont(font2);
		tf4_reg.setBounds(160,370,100,28);
        p_reg.add(tf4_reg);
        
        lbl9_reg=new JLabel("");
        lbl9_reg.setFont(font3);
		lbl9_reg.setBounds(100,405,150,28);
        p_reg.add(lbl9_reg);
        
        b3_reg=new JButton("Register");
        b3_reg.setBounds(80,440,160,40);
		b3_reg.addActionListener(this);
		b3_reg.setBackground(new Color(255,255,255));
		p_reg.add(b3_reg);

        lbl6_reg=new JLabel("Already a user ?");
        lbl6_reg.setFont(font1);
		lbl6_reg.setBounds(20,520,170,28);
        p_reg.add(lbl6_reg);

        b3_reg=new JButton("Sign in");
        b3_reg.setBounds(180,520,100,30);
		b3_reg.addActionListener(this);
		b3_reg.setBackground(new Color(255,255,255));
		p_reg.add(b3_reg);

        add(p_reg,BorderLayout.CENTER);
		setTitle("REGISTRATION");
        setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p_reg.setVisible(true);
		p_reg.setBackground(new Color(100,185,255));
		
		//login
		p_log=new JPanel();
        p_log.setLayout(null);
        

        lbl1_log=new JLabel("Online Payment Application");
        lbl1_log.setFont(new Font("Calibri",Font.BOLD,26));
		lbl1_log.setBounds(10,20,370,28);
        p_log.add(lbl1_log);

        lbl2_log=new JLabel("Login");
        lbl2_log.setFont(font1);
		lbl2_log.setBounds(120,80,370,28);
        p_log.add(lbl2_log);

        lbl4_log=new JLabel("Email Id");
        lbl4_log.setFont(font2);
		lbl4_log.setBounds(20,130,370,28);
        p_log.add(lbl4_log);


        tf1_log=new JTextField();
        tf1_log.setFont(font2);
		tf1_log.setBounds(20,170,270,28);
        p_log.add(tf1_log);

        lbl5_log=new JLabel("Password");
        lbl5_log.setFont(font2);
		lbl5_log.setBounds(20,210,370,28);
        p_log.add(lbl5_log);

        tf2_log=new JPasswordField();
        tf2_log.setFont(font2);
		tf2_log.setBounds(20,250,250,28);
        p_log.add(tf2_log);
        
        b2_log=new JButton("Login");
        b2_log.setBounds(80,290,140,40);
		b2_log.addActionListener(this);
		b2_log.setBackground(new Color(255,255,255));
		p_log.add(b2_log);
		
		lbl6_log=new JLabel("");
        lbl6_log.setFont(font3);
		lbl6_log.setBounds(20,340,370,28);
        p_log.add(lbl6_log);
        

        lbl7_log=new JLabel("Forgot Password ?");
        lbl7_log.setFont(font2);
		lbl7_log.setBounds(20,385,370,28);
        p_log.add(lbl7_log);

        b3_log=new JButton("Click here");
        b3_log.setBounds(160,380,120,40);
		b3_log.addActionListener(this);
		b3_log.setBackground(new Color(255,255,255));
		p_log.add(b3_log);
		
		p_log.setBackground(new Color(100,185,255));
		
		
		//Forgot password
		p_fp=new JPanel();
		p_fp.setLayout(null);
		
		l1_fp=new JLabel(" Change Password ");
		l1_fp.setFont(font1);
		l1_fp.setBounds(80,30,270,28);
        p_fp.add(l1_fp);
        
        l2_fp=new JLabel(" Enter the new Password");
        l2_fp.setFont(font2);
		l2_fp.setBounds(20,100,270,28);
        p_fp.add(l2_fp);
        
        tf1_fp=new JPasswordField();
        tf1_fp.setFont(font2);
      	tf1_fp.setBounds(20,140,260,28);
        p_fp.add(tf1_fp);
        
        l3_fp=new JLabel("Enter otp sent to your mail");
        l3_fp.setFont(font2);
		l3_fp.setBounds(20,180,300,28);
        p_fp.add(l3_fp);
        
        tf2_fp=new JTextField();
        tf2_fp.setFont(font2);
      	tf2_fp.setBounds(20,220,260,28);
        p_fp.add(tf2_fp);
        
        l4_fp=new JLabel("");
        l4_fp.setFont(font3);
		l4_fp.setBounds(20,260,270,28);
        p_fp.add(l4_fp);
        
        b1_fp=new JButton("Change password");
        b1_fp.setBounds(50,290,200,40);
        b1_fp.addActionListener(this);
        b1_fp.setBackground(new Color(255,255,255));
		p_fp.add(b1_fp);
		
		p_fp.setBackground(new Color(100,185,255));
		
		//choose
		 p_pay=new JPanel();
	        p_pay.setLayout(null);

	        lbl1_pay=new JLabel("Online Payment Application");
	        lbl1_pay.setFont(new Font("Calibri",Font.BOLD,26));
			lbl1_pay.setBounds(10,20,370,28);
	        p_pay.add(lbl1_pay);

	        lbl2_pay=new JLabel("Successfully logged in...");
	        lbl2_pay.setFont(font1);
			lbl2_pay.setBounds(5,100,370,28);
	        p_pay.add(lbl2_pay);

	        lbl3_pay=new JLabel(user);
	        lbl3_pay.setFont(font2);
			lbl3_pay.setBounds(5,140,370,28);
	        p_pay.add(lbl3_pay);

	        lbl4_pay=new JLabel("Choose Payment Method");
	        lbl4_pay.setFont(font1);
			lbl4_pay.setBounds(40,200,370,28);
	        p_pay.add(lbl4_pay);

	        b1_pay=new JButton("Credit / Debit card");
	        b1_pay.setFont(font3);
	        b1_pay.setBounds(50,250,200,40);
			b1_pay.addActionListener(this);
			b1_pay.setBackground(new Color(255,255,255));
			p_pay.add(b1_pay);

	        b2_pay=new JButton("Internet Banking");
	        b2_pay.setFont(font3);
	        b2_pay.setBounds(50,310,200,40);
			b2_pay.addActionListener(this);
			b2_pay.setBackground(new Color(255,255,255));
			p_pay.add(b2_pay);

	        b3_pay=new JButton("UPI Payment");
	        b3_pay.setFont(font3);
	        b3_pay.setBounds(50,370,200,40);
			b3_pay.addActionListener(this);
			b3_pay.setBackground(new Color(255,255,255));
			p_pay.add(b3_pay);
			p_pay.setBackground(new Color(100,185,255));


	        //payment
			p1_cd=new JPanel();
		      //p1_cd.setBackground(Color.RED);
		      l1_cd=new JLabel("CREDIT / DEBIT CARD");
		      l1_cd.setFont(new Font("Calibri",Font.BOLD,26));
		      l2_cd=new JLabel("Card No:");
		      l2_cd.setFont(new Font("Calibri",Font.PLAIN,22));
		      l3_cd=new JLabel("Expiry Month");
		      l3_cd.setFont(new Font("Calibri",Font.PLAIN,22));
		      l4_cd=new JLabel("Expiry Year");
		      l4_cd.setFont(new Font("Calibri",Font.PLAIN,22));
		      l5_cd=new JLabel("CVV Number");
		      l5_cd.setFont(new Font("Calibri",Font.PLAIN,22));
		      l6_cd=new JLabel("Amount");
		      l6_cd.setFont(new Font("Calibri",Font.PLAIN,22));
		      l7_cd=new JLabel("");
		      l7_cd.setFont(font3);
		      l8_cd=new JLabel("");
		      l8_cd.setFont(font3);
		      
		      t1_cd=new JTextField();
		      t2_cd=new JPasswordField();
		      t3_cd=new JTextField();
		      
		      j1_cd=new JComboBox(M);
		      j2_cd=new JComboBox(Y);
		      b1_cd=new JButton("Card Pay");
		      b1_cd.addActionListener(this);
		      p1_cd.add(l1_cd);p1_cd.add(l2_cd);p1_cd.add(t1_cd);p1_cd.add(l3_cd);p1_cd.add(j1_cd);p1_cd.add(l4_cd);
		      p1_cd.add(j2_cd);p1_cd.add(l5_cd);p1_cd.add(t2_cd);p1_cd.add(l6_cd);p1_cd.add(t3_cd);p1_cd.add(b1_cd);
		      p1_cd.add(l7_cd);p1_cd.add(l8_cd);
		      
		      p1_cd.setLayout(null);
		      l1_cd.setBounds(60,40,400,30);
		      l2_cd.setBounds(60,90,150,30);
		      t1_cd.setBounds(60,120,200,30);
		      l7_cd.setBounds(60,150,400,30);
		      l3_cd.setBounds(60,190,150,30);
		      j1_cd.setBounds(60,220,80,30);
		      l4_cd.setBounds(60,270,150,30);
		      j2_cd.setBounds(60,320,80,30);
		      l5_cd.setBounds(60,360,150,30);
		      t2_cd.setBounds(60,400,80,30);
		      
		      l8_cd.setBounds(60,430,400,30);
		      l6_cd.setBounds(60,460,400,30);
		      t3_cd.setBounds(60,500,200,30);
		      b1_cd.setBounds(70,550,160,40);
		      p1_cd.setBackground(new Color(100,185,255));
		      
		//payment1
		      p1_ib=new JPanel();
		      l1_ib=new JLabel("INTERNET BANKING");
		      l1_ib.setFont(new Font("Calibri",Font.BOLD,26));
		      l2_ib=new JLabel("Bank Name");
		      l2_ib.setFont(new Font("Calibri",Font.PLAIN,22));
		      l3_ib=new JLabel("Username");
		      l3_ib.setFont(new Font("Calibri",Font.PLAIN,22));
		      l4_ib=new JLabel("Password");
		      l4_ib.setFont(new Font("Calibri",Font.PLAIN,22));
		      l5_ib=new JLabel("Amount");
		      l5_ib.setFont(new Font("Calibri",Font.PLAIN,22));
		      l6_ib=new JLabel("");
		      l6_ib.setFont(font3);
		      
		      t1_ib=new JTextField();
		      t2_ib=new JPasswordField();
		      t3_ib=new JTextField();
		      
		      j1_ib=new JComboBox(B);
		      b1_ib=new JButton("Bank Pay");
		      b1_ib.addActionListener(this);
		      
		      p1_ib.add(l1_ib);p1_ib.add(l2_ib);p1_ib.add(j1_ib);p1_ib.add(l3_ib);p1_ib.add(t1_ib);p1_ib.add(l4_ib);
		      p1_ib.add(t2_ib);p1_ib.add(l5_ib);p1_ib.add(t3_ib);p1_ib.add(b1_ib);p1_ib.add(l6_ib);
		      p1_ib.setLayout(null);
		      
		      l1_ib.setBounds(60,40,400,30);
		      l2_ib.setBounds(60,100,150,30);
		      j1_ib.setBounds(60,130,200,30);
		      l3_ib.setBounds(60,175,150,30);
		      t1_ib.setBounds(60,205,200,30);
		      l4_ib.setBounds(60,250,150,30);
		      t2_ib.setBounds(60,280,200,30);
		      l6_ib.setBounds(60,310,150,30);
		      l5_ib.setBounds(60,340,150,30);
		      t3_ib.setBounds(60,370,200,30);
		      b1_ib.setBounds(70,500,160,40);
		      p1_ib.setBackground(new Color(100,185,255));
		
		 //payment2
		      p1_upi=new JPanel();
		      l1_upi=new JLabel("UPI TRANSACTION");
		      l1_upi.setFont(new Font("Calibri",Font.BOLD,26));
		      l2_upi=new JLabel("UPI ID");
		      l2_upi.setFont(new Font("Calibri",Font.PLAIN,22));
		      l3_upi=new JLabel("UPI PIN");
		      l3_upi.setFont(new Font("Calibri",Font.PLAIN,22));
		      l4_upi=new JLabel("AMOUNT");
		      l4_upi.setFont(new Font("Calibri",Font.PLAIN,22));
		      l5_upi=new JLabel("");
		      l5_upi.setFont(font3);
		      
		      t1_upi=new JTextField();
		      t2_upi=new JPasswordField();
		      t3_upi=new JTextField();
		      
		      b1_upi=new JButton("UPI Pay");
		      b1_upi.addActionListener(this);
		      
		      p1_upi.add(l1_upi);p1_upi.add(l2_upi);p1_upi.add(t1_upi);p1_upi.add(l3_upi);
		      p1_upi.add(t2_upi);p1_upi.add(l4_upi);p1_upi.add(t3_upi);p1_upi.add(b1_upi);p1_upi.add(l5_upi);
		      
		      p1_upi.setLayout(null);
		      
		      l1_upi.setBounds(70,90,400,30);
		      l2_upi.setBounds(60,150,150,30);
		      t1_upi.setBounds(60,180,200,30);
		      l3_upi.setBounds(60,230,150,30);
		      t2_upi.setBounds(60,260,200,30);
		      l5_upi.setBounds(60,300,150,30);
		      l4_upi.setBounds(60,350,150,30);
		      t3_upi.setBounds(60,380,200,30);
		      b1_upi.setBounds(70,500,160,40);
		      p1_upi.setBackground(new Color(100,185,255));
		      
		//Success
		      p1_s=new JPanel();
		      p1_s.setBackground(Color.WHITE);
		      icon_s=new ImageIcon("C:\\Users\\siva\\eclipse-workspace\\Online_Payment\\src\\pages\\crct.png");
		      l1_s=new JLabel("",icon_s,JLabel.CENTER);
		      
		      b1_s=new JButton("Home");
		      b1_s.addActionListener(this);
		      b2_s=new JButton("Logout");
		      b2_s.addActionListener(this);		      
		      
		      
		      p1_s.add(l1_s);p1_s.add(b1_s);p1_s.add(b2_s);
		      
		      p1_s.setLayout(null);
		      l1_s.setBounds(60,70,200,300);
		      b1_s.setBounds(60,370,80,30);
		      b2_s.setBounds(180,370,80,30);
		      
		 //Unsuccess
		      p1_us=new JPanel();
		      p1_us.setBackground(Color.WHITE);
		      icon_us=new ImageIcon("C:\\\\Users\\\\siva\\\\eclipse-workspace\\\\Online_Payment\\\\src\\\\pages\\fal.png");
		      l1_us=new JLabel("",icon_us,JLabel.CENTER);
		      l2_us=new JLabel("Payment Unsuccessful");
		      l2_us.setFont(new Font("Arial",Font.BOLD,16));
		      
		      b1_us=new JButton("Home");
		      b1_us.addActionListener(this);
		      b2_us=new JButton("Logout");
		      b2_us.addActionListener(this);		      
		      
		      
		      p1_us.add(l1_us);p1_us.add(l2_us);p1_us.add(b1_us);p1_us.add(b2_us);
//		      add(p1_us,BorderLayout.CENTER); 
		      p1_us.setLayout(null);
		      l1_us.setBounds(70,130,200,150);
		      l2_us.setBounds(83,280,200,30);
		      b1_us.setBounds(70,370,80,30);
		      b2_us.setBounds(180,370,80,30);
		      
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getActionCommand().equals("Get OTP"))
    	{
    		
    		String numbers = "0123456789";
            Random rndm_method = new Random();
      
            for (int i = 0; i < 6; i++)
            {
                char x=numbers.charAt(rndm_method.nextInt(numbers.length()));
                otpp=(otpp*10)+(x-'0');
            }
            System.out.println(otpp);
    		String ToEmail = tf2_reg.getText();
    	       String FromEmail = "2012079@nec.edu.in";//studyviral2@gmail.com
    	       String FromEmailPassword = "Ammaappa@1009";//You email Password from you want to send email
    	       String Subjects = "OTP for Registration";
    	       
    	       Properties properties = new Properties();
    	       properties.put("mail.smtp.auth","true");
    	       properties.put("mail.smtp.starttls.enable","true");
    	       properties.put("mail.smtp.host","smtp.gmail.com");
    	       properties.put("mail.smtp.port","587");
    	       properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
    	       
    	       Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
    	           protected PasswordAuthentication getPasswordAuthentication(){
    	               return new PasswordAuthentication(FromEmail, FromEmailPassword);
    	           }
    	       });
    	       
    	       try{
    	           MimeMessage message = new MimeMessage(session);
    	           message.setFrom(new InternetAddress(FromEmail));
    	           message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));
    	           message.setSubject(Subjects);
    	           message.setText("Here is your OTP for the online payment applicaion registration procedure : "+" "+otpp);
    	           Transport.send(message);
    	       }catch(Exception ex){
    	           System.out.println(""+ex);
    	           lbl9_reg.setText("Enter the valid email id");
    	       }
    	}
    	
    	else if(e.getActionCommand().equals("Register"))
    	{
    		String n=tf1_reg.getText();
    		String em=tf2_reg.getText();
    		char[] pw=tf3_reg.getPassword();
    		String ot=tf4_reg.getText();
    		int ott=Integer.parseInt(ot);
    		
    		String pww="";
    		user="";
    		user+=n;
    		lbl3_pay.setText(user);
    		for(int i=0;i<pw.length;i++)
    		{
    			pww+=pw[i];
    		}
    		int am=5000;
    		if(ott!=otpp)
    		{
    			lbl9_reg.setText("OTP is Incorrect");
    		}
    		else if(pww.length()<8)
    		{
    			lbl9_reg.setText("password length must greater than 8");
    		}
    		else
    		{
    		lbl9_reg.setText("");
    		try
    		{
    		String Sql1="insert into login_details(uname,email,password,amount) values(?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(Sql1);
			pst.setString(1, n);
			pst.setString(2,em);
			pst.setString(3,pww);
			pst.setInt(4, am);
			
			int r=pst.executeUpdate();
			if(r>0)
			{
				System.out.println("Inserted");
			}
    		}
    		catch(Exception e1)
    		{
    			System.out.println(e1);
    		}
    		
    		p_reg.setVisible(false);
    		add(p_pay,BorderLayout.CENTER);
			setTitle("Choose Payment");
    		}
    		
    	}
    	else if(e.getActionCommand().equals("Sign in"))
    	{
    		p_reg.setVisible(false);
    		add(p_log,BorderLayout.CENTER);
    		setTitle("LOGIN");
    	}
    	else if(e.getActionCommand().equals("Login"))
    	{
    		boolean b=false;
    		String s1=tf1_log.getText();
    		char[] s2=tf2_log.getPassword();
    		String s3="";
    		int cc=0;
    		for(int i=0;i<s2.length;i++)
    			s3+=s2[i];
//    		System.out.println(s3);
    		String p1="";
    		try
    		{
    		Statement s= c.createStatement();
    		String Sql="select uname,password from login_details where email='"+s1+"'";
			ResultSet rs=s.executeQuery(Sql);
			while(rs.next())
			{
				cc++;
				user="";
				user+=rs.getString("uname");
				p1+=rs.getString("password");
			}
//			System.out.println(s3+" "+p1);
			if(s3.equals(p1) && s1.length()>0 && s3.length()>0 && cc>0)
			{
				b=true;
				lbl3_pay.setText(user);
			}
			else if(cc>0 && s1.length()>0 && s3.length()>=0)
			{
				lbl6_log.setText("Invalid Password");
			}
			else if(s1.length()>0)
			{
				lbl6_log.setText("Invalid Email");
			}
			else
			{
				lbl6_log.setText("Invalid credentials");
			}
    		}
    		catch(Exception e2)
    		{
    			System.out.println(e2+ "\nInvalid Login Credentials");
//    			lbl6_log.setText("Invalid Login Credentials");
    		}
    		
    		
    		if(b)
    		{
    			p_log.setVisible(false);
    		add(p_pay,BorderLayout.CENTER);
			setTitle("Choose Payment");
    		}
    	}
    	else if(e.getActionCommand().equals("Credit / Debit card"))
    	{
    		p_pay.setVisible(false);
    		add(p1_cd,BorderLayout.CENTER); 
			setTitle("Credit/Debit card");
    	}
    	else if(e.getActionCommand().equals("Internet Banking"))
    	{
    		p_pay.setVisible(false);
    		add(p1_ib,BorderLayout.CENTER); 
			setTitle("Internet Banking");
    	}
    	else if(e.getActionCommand().equals("UPI Payment"))
    	{
    		p_pay.setVisible(false);
    		add(p1_upi,BorderLayout.CENTER); 
			setTitle("UPI Payment");
    	}
    	else if(e.getActionCommand().equals("Card Pay"))
    	{
    		boolean b1=false;
    		
    		String cds=t1_cd.getText();
    		char[] cds1=t2_cd.getPassword();
    		String amt1=t3_cd.getText();
    		int a1=Integer.parseInt(amt1);
    		if(cds.length()==16)
    		{
    			if(cds1.length!=3)
    			{
    				l8_cd.setText("cvv must be three digits");
    			}
    			else
    			{
    				p1_cd.setVisible(false);
    				if(a1<=5000)
    				{
    		    	    p1_us.setVisible(true);
    					add(p1_s,BorderLayout.CENTER); 
            			setTitle("Payment Successful");
    				}
    				else
    				{
    		    	    p1_us.setVisible(true);
    					add(p1_us,BorderLayout.CENTER); 
            			setTitle("Payment Unsuccessful");
    				}
    			}
    		}
    		else
    		{
    			
    			l7_cd.setText("Card number must be 16 digits");
    		}
    		
    		
    	}
    	else if(e.getActionCommand().equals("Bank Pay"))
    	{
    		boolean b1=false;
    		
    		String amt1=t3_ib.getText();
    		int a1=Integer.parseInt(amt1);
    		
    		if(a1<=5000)
    			b1=true;
    		
    		p1_ib.setVisible(false);
    		if(b1)
    		{
    			add(p1_s,BorderLayout.CENTER); 
    			setTitle("Payment Successful");
    			p1_s.setVisible(true);
    		}
    		else
    		{
    			add(p1_us,BorderLayout.CENTER); 
    			setTitle("Payment Unsuccessful");
    			p1_us.setVisible(true);
    		}
    	}
    	else if(e.getActionCommand().equals("UPI Pay"))
    	{
    		boolean b1=false;
    		
    		char[] upin=t2_upi.getPassword();
    		String amt1=t3_upi.getText();
    		int a1=Integer.parseInt(amt1);
    		
    		if(upin.length==6)
    		{
    			p1_upi.setVisible(false);
        	    if(a1<=5000)
        	    	b1=true;
        	    else
        	    	b1=false;
        	    
        	    if(b1)
        		{
        			add(p1_s,BorderLayout.CENTER); 
        			setTitle("Payment Successful");
        			p1_s.setVisible(true);
        		}
        		else
        		{
        			add(p1_us,BorderLayout.CENTER); 
        			setTitle("Payment Unsuccessful");
        			p1_us.setVisible(true);
        		}
        	    
    		}
    		else
    		{
    			l5_upi.setText("Valid mpin must be 6 digits");
    		}
    		
    	}
    	else if(e.getActionCommand().equals("Home")) {
    	    System.out.print("Hello");
    	    p1_s.setVisible(false);
    	    p1_us.setVisible(false);
    	    p_pay.setVisible(true);
    	    add(p_pay,BorderLayout.CENTER);
			setTitle("Choose Payment");
    	}
    	else if(e.getActionCommand().equals("Logout")) {
    	        System.out.print("Hello");
    	        p1_s.setVisible(false);
    	        p1_us.setVisible(false);
    	        p_log.setVisible(true);
    	        tf1_log.setText("");
    	        tf2_log.setText("");
    	        add(p_log,BorderLayout.CENTER);
        		setTitle("Online Payment System - LOGIN");
        }
    	else if(e.getActionCommand().equals("Click here"))
    	{
    		fpemail=tf1_log.getText();
    		if(tf1_log.getText().equals(""))
    		{
    			lbl6_log.setText("Enter the mail id");
    		}
    		else
    		{
    			otpp=0;
    			String numbers = "0123456789";
                Random rndm_method = new Random();
          
                for (int i = 0; i < 6; i++)
                {
                    char x=numbers.charAt(rndm_method.nextInt(numbers.length()));
                    otpp=(otpp*10)+(x-'0');
                }
                System.out.println(otpp);
                
    		String ToEmail = tf1_log.getText();
 	       String FromEmail = "2012079@nec.edu.in";//studyviral2@gmail.com
 	       String FromEmailPassword = "Ammaappa@1009";//You email Password from you want to send email
 	       String Subjects = "OTP for Forgot Password";
 	       
 	       Properties properties = new Properties();
 	       properties.put("mail.smtp.auth","true");
 	       properties.put("mail.smtp.starttls.enable","true");
 	       properties.put("mail.smtp.host","smtp.gmail.com");
 	       properties.put("mail.smtp.port","587");
 	       properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
 	       
 	       Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
 	           protected PasswordAuthentication getPasswordAuthentication(){
 	               return new PasswordAuthentication(FromEmail, FromEmailPassword);
 	           }
 	       });
 	       
 	       try{
 	           MimeMessage message = new MimeMessage(session);
 	           message.setFrom(new InternetAddress(FromEmail));
 	           message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));
 	           message.setSubject(Subjects);
 	           message.setText("Here is your OTP for the online payment applicaion new password changing procedure : "+" "+otpp);
 	           Transport.send(message);
 	       }catch(Exception ex){
 	           System.out.println(""+ex);
 	           lbl9_reg.setText("Enter the valid email id");
 	       }
 	       p_log.setVisible(false);
 	      add(p_fp,BorderLayout.CENTER); 
 	      setTitle("Forgot password");
 	       
    		}
    		
    	}
    	else if(e.getActionCommand().equals("Change password"))
    	{
    		int cc=0;
    		fpotp=Integer.parseInt(tf2_fp.getText());
    		if(fpotp==otpp)
    		{
    			char[] ca=tf1_fp.getPassword();
    			String p3="";
    			for(int i=0;i<ca.length;i++)
    			{
    				p3+=ca[i];
    			}
    			try
        		{
        		Statement s= c.createStatement();
        		String Sql="update public.login_details set password='"+p3+"' where email='"+fpemail+"';";
    			ResultSet rs=s.executeQuery(Sql);
        		}
    			catch(Exception e3)
    			{
    				System.out.println(e3);
    			}
    			p_fp.setVisible(false);
        		add(p_pay,BorderLayout.CENTER);
    			setTitle("Choose Payment");
    		}
    		else
    		{
    			l4_fp.setText("Incorrect OTP");
    		}
    	}
//    	else
//    	{
//    		System.out.println(e.getSource());
//    	}
    }
    
    public static void main(String[] args)
    {
    	Main m=new Main();
    	m.setVisible(true);
		m.setSize(350,650);
		m.setLocation(20,20);
		
		

    }
    

}
