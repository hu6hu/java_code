package shiyan.shiyan_06;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    private JPanel pan1,pan2,pan3,pan4;
    private JTextField username,password;
    private JButton login,zhuce;
    static String myid,mypasswd,mymoney;
//    static int mymoney;
//    public static Reader fw;

    public Login() {
        this.setTitle("登录ATM");
        this.setSize(500, 300);
        this.setLocation(500, 200);
        this.setResizable(false);
        //this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pan1 = new JPanel();
        pan1.setBackground(new Color(255,239,213));
        pan1.setBounds(150,30,200,30);
        this.add(pan1);
        pan1.add(new JLabel("储蓄银行"));

        pan2 = new JPanel();
        pan2.setBounds(80, 70, 300, 30);
        this.add(pan2);
        pan2.add(new JLabel("账户："));
        username = new JTextField(20);
        pan2.add(username);

        pan3 = new JPanel();
        pan3.setBounds(80, 100, 300, 30);
        this.add(pan3);
        pan3.add(new JLabel("密码："));
        password = new JPasswordField(20);
        pan3.add(password);

        login = new JButton("登录");
        zhuce = new JButton("注册");
        login.addActionListener(this);

        pan4 = new JPanel();
        pan4.setBounds(100, 140, 300, 36);
        this.add(pan4);
        pan4.add(login);
        //pan4.add(zhuce);

        //setVisible(false);
        setVisible(true);

    }

    public static String getid() {
        return myid;
    }

    public static String getmoney() {
        return mymoney;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object source = e.getSource();
        if(source==login) {
            int size =Test.user.size()-1;
            System.out.println(size);
            for(int i = 0;i<Test.user.size();i++) {
                if(username.getText().toString().equals(Test.user.get(i).id)) {
                    if(password.getText().toString().equals(Test.user.get(i).passwd)) {
                        myid = Test.user.get(i).id;
                        mypasswd = Test.user.get(i).passwd;
                        mymoney = Test.user.get(i).money;
                        System.out.println(mypasswd);
                        this.dispose();
                        new Menu();
                        break;
                    }else if(password.getText().toString().equals("")){
                        JOptionPane.showMessageDialog(this, "密码不能为空");
                        break;
                    }else {
                        JOptionPane.showMessageDialog(this, "密码错误");
                        break;
                    }
                }else if(username.getText().toString().equals("")&&i==size){
                    JOptionPane.showMessageDialog(this, "账号不能为空");
                    break;
                }else if(password.getText().toString().equals("")&&i==size) {
                    JOptionPane.showMessageDialog(this, "密码不能为空");
                    break;
                }else if(i==size) {
                    JOptionPane.showMessageDialog(this, "账号或密码错误");
                    break;
                }
            }
        }
    }


	/*public static void main(String args[]) {
		new Login();
	}*/
}

