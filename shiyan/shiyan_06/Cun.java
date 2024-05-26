package shiyan.shiyan_06;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import javax.swing.*;

public class Cun extends JFrame implements ActionListener{

    private JPanel cun1,cun2,cun3,cun4;
    private JTextField cun;
    private JButton sure,back;
    public Cun() {
        this.setTitle("存款");
        this.setSize(500, 300);
        this.setLocation(500, 200);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        cun1 = new JPanel();
        cun1.setBounds(0, 20, 500, 30);
        cun1.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
        cun1.add(new JLabel("账户："+Login.myid));
        this.add(cun1);

        cun2 = new JPanel();
        cun2.setBounds(0, 50, 500, 30);
        cun2.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
        cun2.add(new JLabel("余额："+Login.mymoney));
        this.add(cun2);

        cun3 = new JPanel();
        cun3.setBounds(0, 80, 500, 30);
        cun3.add(new JLabel("存款金额："));
        cun = new JTextField(20);
        cun.setDocument(new NumLimit());
        cun3.add(cun);
        this.add(cun3);

        sure = new JButton("确定");
        back = new JButton("返回");
        sure.addActionListener(this);
        back.addActionListener(this);

        cun4 = new JPanel();
        cun4.setBounds(0,130,500,50);
        cun4.add(sure);
        cun4.add(back);
        this.add(cun4);


        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object source = e.getSource();
        if(source==back){
            this.dispose();
            new Menu();
        }else if(source==sure) {
            String c = cun.getText().toString();
            int money = Integer.parseInt(c);
            System.out.println(c+money);
            if(money%100==0) {

                try {
                    Account.inmoney(money);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(this, "存钱成功");
                try {
                    Date currenttime = new Date();//获取当前时间
                    //将此次操作记录写入记录文件
                    Writer fw = new FileWriter("record"+Login.myid+".txt",true);
                    fw.write("用户在"+currenttime+"存入"+money+"元"+"\n");
                    fw.flush();
                    fw.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                cun.removeAll();
                this.dispose();
                new Menu();
            }else {
                JOptionPane.showMessageDialog(this, "存入金额必须是整百数");
            }
        }
    }



	/*public static void main(String args[]) {
		new Cun();
	}*/
}

