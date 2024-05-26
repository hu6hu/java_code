package shiyan.shiyan_06;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Menu extends JFrame implements ActionListener{

    private JPanel menu1,menu2;
    private JButton cun,qu,cha,zhuan,cpasswd,exit,back;
    private JDialog tip;
    private JLabel tips;
    public Menu() {
        this.setTitle("袁氏高级储蓄银行");
        this.setSize(500, 300);
        this.setLocation(500, 200);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        menu1 = new JPanel();
        menu1.setBounds(0, 0, 500, 30);
        menu1.setBackground(new Color(255,222,173));
        menu1.add(new JLabel("请选择需要进行的业务"));
        this.add(menu1);

        menu2 = new JPanel();
        menu2.setBounds(0, 30, 500, 250);
        menu2.setBackground(new Color(255,239,213));
        menu2.setLayout(null);
        this.add(menu2);

        cun = new JButton("存款");
        qu = new JButton("取款");
        cha = new JButton("查询");
        zhuan = new JButton("转账");
        cpasswd = new JButton("更改密码");
        exit = new JButton("退出");
        back = new JButton("返回");

        menu2.add(cun);
        menu2.add(qu);
        menu2.add(cha);
        menu2.add(zhuan);
        menu2.add(cpasswd);
        menu2.add(exit);

        cun.setBounds(25,30,100,30);
        qu.setBounds(360,30,100,30);
        cha.setBounds(25,90,100,30);
        zhuan.setBounds(360,90,100,30);
        cpasswd.setBounds(25,150,100,30);
        exit.setBounds(360,150,100,30);

        cun.addActionListener(this);
        qu.addActionListener(this);
        cha.addActionListener(this);
        zhuan.addActionListener(this);
        cpasswd.addActionListener(this);
        exit.addActionListener(this);
        back.addActionListener(this);

        tips = new JLabel("私人银行，无法转账");
        tips.setBounds(90, 20, 150, 30);
        back.setBounds(105, 60, 80, 30);

        tip = new JDialog(this, "转账", true);
        tip.setSize(300,150);
        tip.setLayout(null);
        tip.setLocation(600,250);
        tip.add(tips);
        tip.add(back);

        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object source = e.getSource();
        if(source==cun) {
            this.dispose();
            new Cun();
        }else if(source==qu) {
            this.dispose();
            new Qu();
        }else if(source==cha) {
            this.dispose();
            try {
                new Cha();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }else if(source==zhuan) {
            tip.setVisible(true);
        }else if(source==cpasswd) {
            this.dispose();
            new Cpasswd();
        }else if(source==exit) {
            Test.login();
            this.dispose();
            new Login();
            JOptionPane.showMessageDialog(null,"请记得取走你的银行卡");
        }else if(source==back) {
            tip.dispose();
        }
    }



	/*public static void main(String args[]) {
		new Menu();
	}*/
}


