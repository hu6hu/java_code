package shiyan.shiyan_06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Qu extends JFrame implements ActionListener{

    private JPanel qu1,qu2,qu3,qu4;
    private JTextField qu;
    private JButton sure,back;
    //private Date currentdate;
    //int money;
    public Qu() {


        this.setTitle("取款");
        this.setSize(500, 300);
        this.setLocation(500, 200);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        qu1 = new JPanel();
        qu1.setBounds(0, 20, 500, 30);
        qu1.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
        qu1.add(new JLabel("账户："+Login.getid()));//erro 从这里开始
        this.add(qu1);

        qu2 = new JPanel();
        qu2.setBounds(0, 50, 500, 30);
        qu2.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
        qu2.add(new JLabel("余额："+Login.getmoney()));
        this.add(qu2);

        qu3 = new JPanel();
        qu3.setBounds(0, 80, 500, 30);
        qu3.add(new JLabel("取款金额："));
        qu = new JTextField(20);
        qu.setDocument(new NumLimit());
        qu3.add(qu);
        this.add(qu3);

        sure = new JButton("确定");
        back = new JButton("返回");
        back.addActionListener(this);
        sure.addActionListener(this);

        qu4 = new JPanel();
        qu4.setBounds(0,130,500,50);
        qu4.add(sure);
        qu4.add(back);
        this.add(qu4);


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
            String m=qu.getText().toString();
            int money=Integer.parseInt(m);
            int lmoney = Integer.parseInt(Login.mymoney);
            if(money<100) {
                JOptionPane.showMessageDialog(this, "取款金额不能小于100");
            }else if(money>5000) {
                JOptionPane.showMessageDialog(this, "取款金额不能超过5000");
            }else if(money>lmoney) {
                JOptionPane.showMessageDialog(this, "余额不足");
            }else if(money%100==0){
                try {
                    Account.outmoney(money);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(this, "取款成功");
                try {
                    Date currenttime = new Date();
                    Writer fw = new FileWriter("record"+Login.myid+".txt",true);
                    fw.write("用户在"+currenttime+"取出"+money+"元"+"\n");
                    fw.flush();
                    fw.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                qu.removeAll();
                this.dispose();
                new Menu();
            }else {
                JOptionPane.showMessageDialog(this, "取款金额必须是整百数");
            }
        }
    }



	/*public static void main(String args[]) {
		new Qu();
	}*/

}

