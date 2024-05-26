package shiyan.shiyan_06;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
/*
 * 查询类，实现查询界面，当被主界面按钮调用时即显示存取操作记录
 */
public class Cha extends JFrame implements ActionListener{

    private JPanel cha1,cha2,cha4;
    private JScrollPane cha3;
    private JTextArea cha;
    private JButton back;
    //static String reccord;
    public Cha() throws Exception{
        this.setTitle("查询");
        this.setSize(500, 300);
        this.setLocation(500, 200);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        cha1 = new JPanel();
        cha1.setBounds(0, 20, 500, 30);
        cha1.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
        cha1.add(new JLabel("账户："+Login.myid));
        this.add(cha1);

        cha2 = new JPanel();
        cha2.setBounds(0, 50, 500, 30);
        cha2.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
        cha2.add(new JLabel("余额："+Login.mymoney));
        this.add(cha2);


        cha = new JTextArea("用户操作记录如下：\n"+Account.cha());

        cha3 = new JScrollPane(cha);
        cha3.setBounds(0, 80, 500, 130);
        cha.setBackground(new Color(255,250,250));
        cha.setEditable(false);
        this.add(cha3);

        back = new JButton("返回");
        back.addActionListener(this);

        cha4 = new JPanel();
        cha4.setBounds(0,215,500,50);
        cha4.add(back);
        this.add(cha4);


        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==back) {
            this.dispose();
            new Menu();
        }
    }



	/*public static void main(String args[]) {
		new Cha();
	}*/
}

