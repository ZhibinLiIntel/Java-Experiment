package experiment_7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;
 
public class Test{
	static JFrame fr1=new JFrame();
	
	static JFrame instructor=new JFrame();
	static JLabel label1=new JLabel("User");
	static JLabel label2=new JLabel("Password");
	static JLabel label3=new JLabel("Management System");
	static JTextField tf1=new JTextField();
	static JPasswordField tf2=new JPasswordField();
	static JButton bt1=new JButton("Login");
	static String user_name;
	public static void main(String args[]){
		
		fr1.setSize(600, 400);
		fr1.setLayout(null);
		fr1.setTitle("TestWindow");
		fr1.setLocation(500, 100);
		fr1.setVisible(true);
		fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr1.add(bt1);
		bt1.setBounds(400,250,80,25);
		fr1.add(label1);
		label1.setBounds(150,120,40,40);
		fr1.add(label2);
		label2.setBounds(135,150,60,40);
		fr1.add(label3);
		label3.setBounds(235,80,200,40);
		fr1.add(tf1);
		tf1.setBounds(200, 130, 200, 20);
		fr1.add(tf2);
		tf2.setBounds(200, 160, 200, 20);
			tf1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				bt1.doClick();
			}
		});
			tf2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					bt1.doClick();
				}
			});
				bt1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						 try {
						      Class.forName("com.mysql.jdbc.Driver");
						    }
						    catch (Exception exception) {
						      System.out.print("Error loading Mysql Driver!");
						      exception.printStackTrace();
						    }
						 try {
							Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/management?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","lee960704");
							Statement stmt = connect.createStatement();
							ResultSet number=stmt.executeQuery("select number from token where number='"+tf1.getText().trim()+"'");
							if(number.next()){//判断账号是否存在
								ResultSet password=stmt.executeQuery("select password from token where number='"+tf1.getText().trim()+"'");
								if(password.next()){
									if(password.getString("password").equals(String.valueOf(tf2.getPassword()))){//判断对应密码是否正确
										ResultSet token=stmt.executeQuery("select token from token where number='"+tf1.getText().trim()+"'");
										if(token.next()){//根据登录的账号判断用户身份，赋予相应操作权限
											//用户为学生
											if(token.getString("token").equals("student")){
												fr1.dispose();
												JFrame student=new JFrame();
												JButton check1=new JButton("查看课程");
												JButton check2=new JButton("查看成绩");
												JTextArea inf=new JTextArea();
												JButton cpw=new JButton("修改密码");
												student.setSize(600,300);
												student.setLocation(500, 100);
												student.setVisible(true);
												student.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
												student.setLayout(null);
												student.add(check1);
												check1.setBounds(100,200,150,30);
												student.add(check2);
												check2.setBounds(350,200,150,30);
												student.add(inf);										
												inf.setBounds(200,50,200,100);
												student.add(cpw);
												cpw.setBounds(420,20,120,30);
												//修改密码操作
												cpw.addActionListener(new ActionListener(){
													public void actionPerformed(ActionEvent e){
														JFrame change=new JFrame();
														change.setSize(300, 160);
														change.setVisible(true);
														change.setLocation(650, 150);
														change.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
														change.setLayout(null);
														JTextField jtf=new JTextField();
														change.add(jtf);
														jtf.setBounds(100,20,150,25);
														JLabel jl=new JLabel("输入新密码");
														change.add(jl);
														jl.setBounds(20,20,100,25);
														JButton jb=new JButton("确定");
														change.add(jb);
														jb.setBounds(120,70,60,30);
														jb.addActionListener(new ActionListener(){
															public void actionPerformed(ActionEvent e){
																try {
																	stmt.executeUpdate("update token set password ='"+jtf.getText().trim()+"' where number='"+tf1.getText().trim()+"'");
																	JFrame success=new JFrame();
																	success.setLayout(null);
																	success.setSize(250,150);
																	success.setLocation(700,200);
																	success.setVisible(true);
																	JLabel done=new JLabel("修改成功！");
																	success.add(done);
																	done.setBounds(90,30,100,30);
																	JButton bt=new JButton("确定");
																	success.add(bt);
																	bt.setBounds(80,80,80,25);
																	bt.addActionListener(new ActionListener(){
																		public void actionPerformed(ActionEvent e){
																			success.dispose();
																			change.dispose();
																		}
																	});
																} catch (SQLException e1) {
																	// TODO Auto-generated catch block
																	e1.printStackTrace();
																}
															}
														});
													}
												});
												ResultSet information=stmt.executeQuery("select * from student where number='"+tf1.getText().trim()+"'");
												information.next();
												inf.append("姓名："+information.getString("name")+'\n');
												inf.append("性别："+information.getString("gender")+'\n');
												inf.append("生日："+information.getString("birthday")+'\n');
												inf.append("学院："+information.getString("faculty")+'\n');
												inf.append("专业："+information.getString("major")+'\n');
												inf.setEditable(false);
												//学生查看课程
												check1.addActionListener(new ActionListener(){
													public void actionPerformed(ActionEvent e){
														student.setVisible(false);
														JFrame course=new JFrame();
														JButton back=new JButton("返回");
														//JTable score_table=new JTable();
														JTextArea inf=new JTextArea();		
														course.setSize(600, 300);
														course.setLocation(500, 100);
														course.setVisible(true);
														course.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
														course.setLayout(null);
														course.add(back);
														back.setBounds(400,200,100,30);
														try{
															ResultSet information=stmt.executeQuery("select * from course_test where number='"+tf1.getText().trim()+"'");
															course.add(inf);
															inf.setBounds(100,50,400,100);
															inf.setEditable(false);
															inf.append("课程名称\t\t学分\t学时数\t教师\n");
															while(information.next()){
																inf.append(information.getString("课程名称")+'\t'+'\t'+information.getString("学分")+'\t'+information.getString("学时数")+'\t'+information.getString("教师")+'\n');
															}
														}catch(SQLException e1){
															e1.printStackTrace();
														}
														back.addActionListener(new ActionListener(){
															public void actionPerformed(ActionEvent e){
																student.setVisible(true);
																course.setVisible(false);
															}
														});
													}
												});
												//学生查看成绩
												check2.addActionListener(new ActionListener(){
													public void actionPerformed(ActionEvent e){
														student.setVisible(false);
														JFrame score=new JFrame();
														JButton back=new JButton("返回");
														//JTable score_table=new JTable();
														JTextArea inf=new JTextArea();									
														score.setSize(600, 300);
														score.setLocation(500, 100);
														score.setVisible(true);
														score.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
														score.setLayout(null);
														score.add(back);
														back.setBounds(400,200,100,30);
														try {
															ResultSet information=stmt.executeQuery("select * from course_test where number='"+tf1.getText().trim()+"'");
															score.add(inf);
															inf.setBounds(200,50,200,100);
															inf.setEditable(false);
															inf.append("课程名称\t\t成绩\n");
															while(information.next()){
																inf.append(information.getString("课程名称")+'\t'+'\t'+information.getString("成绩")+'\n');
															}
														} catch (SQLException e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}
														back.addActionListener(new ActionListener(){
															public void actionPerformed(ActionEvent e){
																student.setVisible(true);
																score.setVisible(false);
															}
														});
													}
												});
											}
											//用户为教师
											else if(token.getString("token").equals("teacher")){
												fr1.dispose();
												JFrame teacher=new JFrame();
												JButton check1=new JButton("学生课程信息");
												JButton check2=new JButton("修改成绩信息");
												JTextArea inf=new JTextArea();
												JButton cpw=new JButton("修改密码");
												teacher.setSize(600,300);
												teacher.setLocation(500, 100);
												teacher.setVisible(true);
												teacher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
												teacher.setLayout(null);
												teacher.add(check1);
												check1.setBounds(100,200,150,30);
												teacher.add(check2);
												check2.setBounds(350,200,150,30);
												teacher.add(inf);										
												inf.setBounds(200,50,200,100);
												teacher.add(cpw);
												cpw.setBounds(420,20,120,30);
												ResultSet information=stmt.executeQuery("select * from teacher where number='"+tf1.getText().trim()+"'");
												information.next();
												inf.append("姓名："+information.getString("name")+'\n');
												inf.append("学院："+information.getString("faculty")+'\n');
												inf.setEditable(false);
												//修改密码操作
												cpw.addActionListener(new ActionListener(){
													public void actionPerformed(ActionEvent e){
														JFrame change=new JFrame();
														change.setSize(300, 160);
														change.setVisible(true);
														change.setLocation(650, 150);
														change.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
														change.setLayout(null);
														JTextField jtf=new JTextField();
														change.add(jtf);
														jtf.setBounds(100,20,150,25);
														JLabel jl=new JLabel("输入新密码");
														change.add(jl);
														jl.setBounds(20,20,100,25);
														JButton jb=new JButton("确定");
														change.add(jb);
														jb.setBounds(120,70,60,30);
														jb.addActionListener(new ActionListener(){
															public void actionPerformed(ActionEvent e){
																try {
																	stmt.executeUpdate("update token set password ='"+jtf.getText().trim()+"' where number='"+tf1.getText().trim()+"'");
																	JFrame success=new JFrame();
																	success.setLayout(null);
																	success.setSize(250,150);
																	success.setLocation(700,200);
																	success.setVisible(true);
																	JLabel done=new JLabel("修改成功！");
																	success.add(done);
																	done.setBounds(90,30,100,30);
																	JButton bt=new JButton("确定");
																	success.add(bt);
																	bt.setBounds(80,80,80,25);
																	bt.addActionListener(new ActionListener(){
																		public void actionPerformed(ActionEvent e){
																			success.dispose();
																			change.dispose();
																		}
																	});
																} catch (SQLException e1) {
																	// TODO Auto-generated catch block
																	e1.printStackTrace();
																}
															}
														});
													}
												});
												//教师查看学生课程信息
												check1.addActionListener(new ActionListener(){
													public void actionPerformed(ActionEvent e){
														teacher.setVisible(false);
														JFrame course=new JFrame();
														JButton back=new JButton("返回");
														
														//JTable score_table=new JTable();
														JTextArea inf=new JTextArea();
														course.setSize(600, 300);
														course.setLocation(500, 100);
														course.setVisible(true);
														course.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
														course.setLayout(null);
														course.add(back);
														back.setBounds(400,200,100,30);
														try {
															ResultSet information=stmt.executeQuery("select * from course_test where 教师编号='"+tf1.getText().trim()+"'");
															course.add(inf);
															inf.setBounds(50,10,500,180);
															//inf.setEditable(false);	
															inf.append("学生\t课程\t学分\t学时数\n");
															inf.setEditable(false);
															while(information.next()){
																inf.append(information.getString("学生")+'\t'+information.getString("课程名称")+'\t'+information.getString("学分")+'\t'+information.getString("学时数")+'\n');
															}
														} catch (SQLException e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}
														back.addActionListener(new ActionListener(){
															public void actionPerformed(ActionEvent e){
																teacher.setVisible(true);
																course.setVisible(false);
															}
														});
													}
												});
												//教师查看和修改学生成绩
												check2.addActionListener(new ActionListener(){
													public void actionPerformed(ActionEvent e){
														teacher.setVisible(false);
														JFrame score=new JFrame();
														JButton back=new JButton("返回");
														JButton alter=new JButton("修改");
														//JTable score_table=new JTable();
														JTextArea inf=new JTextArea();	
														score.setSize(600, 300);
														score.setLocation(500, 100);
														score.setVisible(true);
														score.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
														score.setLayout(null);
														score.add(back);
														back.setBounds(400,200,100,30);
														score.add(alter);
														alter.setBounds(100,200,100,30);
														try {
															ResultSet information=stmt.executeQuery("select * from course_test where 教师编号='"+tf1.getText().trim()+"'");
															score.add(inf);
															inf.setBounds(50,10,500,180);
															//inf.setEditable(false);	
															inf.append("姓名\t成绩\n");
															while(information.next()){
																inf.append(information.getString("学生")+'\t'+information.getString("成绩")+'\n');
															}
															inf.setEditable(false);
															while(information.next()){
																
															}
														} catch (SQLException e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}
														//修改成绩窗口及相应操作
														alter.addActionListener(new ActionListener(){
															public void actionPerformed(ActionEvent e){
																JFrame alteration=new JFrame();
																alteration.setLayout(null);
																alteration.setSize(300, 200);
																alteration.setLocation(650, 150);
																alteration.setVisible(true);
																JTextField name=new JTextField();
																JTextField grade=new JTextField();
																alteration.add(name);
																name.setBounds(80,20,150,30);
																alteration.add(grade);
																grade.setBounds(80, 75, 150, 30);
																JLabel label1=new JLabel("姓名");
																JLabel label2=new JLabel("成绩");
																alteration.add(label1);
																label1.setBounds(30,20,60,30);
																alteration.add(label2);
																label2.setBounds(30,75,60,30);
																JButton b1=new JButton("确定");
																JButton b2=new JButton("取消");
																alteration.add(b1);
																b1.setBounds(40,120,60,30);
																alteration.add(b2);
																b2.setBounds(190,120,60,30);
																b1.addActionListener(new ActionListener(){
																	public void actionPerformed(ActionEvent e){
																		try {
																			stmt.executeUpdate("update course_test set 成绩 ='"+grade.getText().trim()+"' where 学生='"+name.getText().trim()+"' and 教师编号='"+tf1.getText().trim()+"'");
																			JFrame success=new JFrame();
																			success.setLayout(null);
																			success.setSize(300,200);
																			success.setLocation(700,200);
																			success.setVisible(true);
																			JLabel done=new JLabel("修改成功！");
																			success.add(done);
																			done.setBounds(120,40,100,30);
																			JButton bt=new JButton("确定");
																			success.add(bt);
																			bt.setBounds(100,100,100,30);
																			bt.addActionListener(new ActionListener(){
																				public void actionPerformed(ActionEvent e){
																					success.dispose();
																					name.setText("");
																					grade.setText("");
																				}
																			});
																		} catch (SQLException e1) {
																			// TODO Auto-generated catch block
																			e1.printStackTrace();
																		}
																	}
																});
																b2.addActionListener(new ActionListener(){
																	public void actionPerformed(ActionEvent e){
																		alteration.dispose();
																	}
																});
															}
														});
														back.addActionListener(new ActionListener(){
															public void actionPerformed(ActionEvent e){
																teacher.setVisible(true);
																score.setVisible(false);
															}
														});
													}
												});
											}
											//用户为辅导员
											else if(token.getString("token").equals("instructor")){
												fr1.dispose();
												JFrame instructor=new JFrame();
												JButton check1=new JButton("课程信息");
												JButton check2=new JButton("成绩排名");
												JButton cpw=new JButton("修改密码");
												JTextArea inf=new JTextArea();
												instructor.setSize(600,300);
												instructor.setLocation(500, 100);
												instructor.setVisible(true);
												instructor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
												instructor.setLayout(null);
												instructor.add(check1);
												check1.setBounds(100,200,150,30);
												instructor.add(check2);
												check2.setBounds(350,200,150,30);
												instructor.add(inf);										
												inf.setBounds(200,50,200,100);
												instructor.add(cpw);
												cpw.setBounds(420,20,120,30);
												ResultSet information=stmt.executeQuery("select * from instructor where number='"+tf1.getText().trim()+"'");
												information.next();
												inf.append("姓名："+information.getString("name")+'\n');
												inf.append("学院："+information.getString("faculty")+'\n');
												inf.setEditable(false);
												cpw.addActionListener(new ActionListener(){
													public void actionPerformed(ActionEvent e){
														JFrame change=new JFrame();
														change.setSize(300, 160);
														change.setVisible(true);
														change.setLocation(650, 150);
														change.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
														change.setLayout(null);
														JTextField jtf=new JTextField();
														change.add(jtf);
														jtf.setBounds(100,20,150,25);
														JLabel jl=new JLabel("输入新密码");
														change.add(jl);
														jl.setBounds(20,20,100,25);
														JButton jb=new JButton("确定");
														change.add(jb);
														jb.setBounds(120,70,60,30);
														jb.addActionListener(new ActionListener(){
															public void actionPerformed(ActionEvent e){
																try {
																	stmt.executeUpdate("update token set password ='"+jtf.getText().trim()+"' where number='"+tf1.getText().trim()+"'");
																	JFrame success=new JFrame();
																	success.setLayout(null);
																	success.setSize(250,150);
																	success.setLocation(700,200);
																	success.setVisible(true);
																	JLabel done=new JLabel("修改成功！");
																	success.add(done);
																	done.setBounds(90,30,100,30);
																	JButton bt=new JButton("确定");
																	success.add(bt);
																	bt.setBounds(80,80,80,25);
																	bt.addActionListener(new ActionListener(){
																		public void actionPerformed(ActionEvent e){
																			success.dispose();
																			change.dispose();
																		}
																	});
																} catch (SQLException e1) {
																	// TODO Auto-generated catch block
																	e1.printStackTrace();
																}
															}
														});
													}
												});
												//辅导员查看所有学生课程信息
												check1.addActionListener(new ActionListener(){
													public void actionPerformed(ActionEvent e){
														instructor.setVisible(false);
														JFrame course=new JFrame();
														JButton back=new JButton("返回");
														JTextArea inf=new JTextArea();
														//JTable score_table=new JTable();
														course.setSize(600, 300);
														course.setLocation(500, 100);
														course.setVisible(true);
														course.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
														course.setLayout(null);
														course.add(back);
														back.setBounds(400,200,100,30);
														try {
															ResultSet information=stmt.executeQuery("select * from course_test");
															course.add(inf);
															inf.setBounds(50,10,500,180);
															//inf.setEditable(false);	
															inf.append("学生\t课程\t学分\t学时数\t教师\n");
															inf.setEditable(false);
															while(information.next()){
																inf.append(information.getString("学生")+'\t'+information.getString("课程名称")+'\t'+information.getString("学分")+'\t'+information.getString("学时数")+'\t'+information.getString("教师")+'\n');
															}
														} catch (SQLException e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}
														back.addActionListener(new ActionListener(){
															public void actionPerformed(ActionEvent e){
																instructor.setVisible(true);
																course.setVisible(false);
															}
														});
													}
												});
												//辅导员对各科成绩进行排名
												check2.addActionListener(new ActionListener(){
													public void actionPerformed(ActionEvent e){
														instructor.setVisible(false);
														JFrame score=new JFrame();
														JButton back=new JButton("返回");
														JTextArea inf=new JTextArea();	
														String[] course={" ","计算机组成原理","面向对象程序","编译技术"};
														JComboBox choice=new JComboBox(course);
														//JTable score_table=new JTable();
														score.setSize(600, 300);
														score.setLocation(500, 100);
														score.setVisible(true);
														score.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
														score.setLayout(null);
														score.add(back);
														back.setBounds(400,200,100,30);
														score.add(choice);
														choice.setBounds(50,50,100,40);
														score.add(inf);
														inf.setBounds(200,50,300,100);
														choice.addItemListener(new ItemListener(){
															public void itemStateChanged(ItemEvent e){
																if(e.getStateChange()==ItemEvent.SELECTED){
																	inf.setText("");
																	if(choice.getSelectedItem()=="计算机组成原理"){
																		try{
																				ResultSet information=stmt.executeQuery("select * from course_test where 课程名称='计算机组成原理' order by 成绩  desc");
																				inf.append("姓名\t成绩\n");
																				while(information.next()){
																					inf.append(information.getString("学生")+'\t'+information.getString("成绩")+'\n');
																				}
																		} catch (SQLException e1) {
																			// TODO Auto-generated catch block
																			e1.printStackTrace();
																		}
																	}
																	else if(choice.getSelectedItem()=="面向对象程序"){
																		try {
																			ResultSet information=stmt.executeQuery("select * from course_test where 课程名称='面向对象程序' order by 成绩  desc");
																			inf.append("姓名\t成绩\n");
																			while(information.next()){
																				inf.append(information.getString("学生")+'\t'+information.getString("成绩")+'\n');
																			}
																	} catch (SQLException e1) {
																		// TODO Auto-generated catch block
																		e1.printStackTrace();
																	}
																}
																	else if(choice.getSelectedItem()=="编译技术"){
																		try {
																			ResultSet information=stmt.executeQuery("select * from course_test where 课程名称='编译技术' order by 成绩  desc");
																			inf.append("姓名\t成绩\n");
																			while(information.next()){
																				inf.append(information.getString("学生")+'\t'+information.getString("成绩")+'\n');
																			}
																	} catch (SQLException e1) {
																		// TODO Auto-generated catch block
																		e1.printStackTrace();
																	}
																}
																}
															}
														});
														back.addActionListener(new ActionListener(){
															public void actionPerformed(ActionEvent e){
																instructor.setVisible(true);
																score.setVisible(false);
															}
														});
													}
												});
											}
										}
										
									}
									//所输入密码不正确
									else{
										JFrame tip=new JFrame();
										tip.setLayout(null);
										tip.setSize(300,200);
										tip.setLocation(650,200);
										tip.setVisible(true);
										tip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										JLabel warnings=new JLabel("Invalid account or incorrect password");
										tip.add(warnings);
										warnings.setBounds(35,30,250,40);
										JButton confirm=new JButton("OK");
										tip.add(confirm);
										confirm.setBounds(110,100,80,30);
										confirm.addActionListener(new ActionListener(){
											public void actionPerformed(ActionEvent e){
												tip.dispose();
											}
										});
									}
								}
							}
							//输入了空账号或者账号不存在
							else{
								JFrame tip=new JFrame();
								tip.setLayout(null);
								tip.setSize(300,200);
								tip.setLocation(650,200);
								tip.setVisible(true);
								tip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								JLabel warnings=new JLabel("Invalid account or incorrect password");
								tip.add(warnings);
								warnings.setBounds(35,30,250,40);
								JButton confirm=new JButton("OK");
								tip.add(confirm);
								confirm.setBounds(110,100,80,30);
								confirm.addActionListener(new ActionListener(){
									public void actionPerformed(ActionEvent e){
										tip.dispose();
									}
								});
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
			
				
	}
}
