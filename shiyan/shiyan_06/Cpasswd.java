package shiyan.shiyan_06;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Cpasswd extends JFrame implements ActionListener{

    private JPanel pan1,pan2,pan3,pan4,pan5;
    private JTextField pwd1,pwd2,pwd3;
    private JButton sure,back;
    String pwd,npwd,spwd;

    public Cpasswd() {
        this.setTitle("密码更改");
        this.setSize(500, 300);
        this.setLocation(500, 200);
        this.setResizable(false);
        //this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pan1 = new JPanel();
        pan1.setBounds(80, 20, 300, 30);
        this.add(pan1);
        pan1.add(new JLabel("原密码："));
        pwd1 = new JPasswordField(20);
        pan1.add(pwd1);

        pan2 = new JPanel();
        pan2.setBounds(80, 60, 300, 30);
        this.add(pan2);
        pan2.add(new JLabel("新密码："));
        pwd2 = new JPasswordField(20);
        pan2.add(pwd2);

        pan3 = new JPanel();
        pan3.setBounds(75, 100, 300, 30);
        this.add(pan3);
        pan3.add(new JLabel("确认密码："));
        pwd3 = new JPasswordField(20);
        pan3.add(pwd3);

        sure = new JButton("确认");
        back = new JButton("返回");
        sure.addActionListener(this);
        back.addActionListener(this);

        pan4 = new JPanel();
        pan4.setBounds(100, 160, 300, 36);
        this.add(pan4);
        pan4.add(sure);
        pan4.add(back);

        pan5 = new JPanel();
        pan5.setBounds(100,200,300,36);
        this.add(pan5);
        pan5.add(new JLabel("(提示：密码只能为六位数)"));

        //setVisible(false);
        setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object source = e.getSource();
        if(source==back) {
            this.dispose();
            new Menu();
        }else if(source==sure) {
            pwd = pwd1.getText().toString();
            npwd = pwd2.getText().toString();
            spwd = pwd3.getText().toString();
            try {
                boolean flag = Account.cpasswd(pwd, npwd, spwd);
                if(flag) {
                    JOptionPane.showMessageDialog(this, "密码修改成功,请重新登录");
                    Test.user.clear();
                    this.dispose();
                    Test.login();
                    new Login();
                }else {
                    JOptionPane.showMessageDialog(this, "密码修改失败");
                    this.dispose();
                    new Menu();
                }

            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }



	/*public static void main(String args[]) {
		new Cpasswd();
	}*/
}

