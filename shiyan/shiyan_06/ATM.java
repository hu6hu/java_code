package shiyan.shiyan_06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM extends JFrame implements ActionListener {

    long total_money;

    public ATM() {
        setBounds(400, 200, 760, 450);
        setTitle("ATM登录系统");

        this.setLayout(new BorderLayout());
        Label l1 = new Label("用户名：");
        Label l2 = new Label("密码：");
        this.add(l1, BorderLayout.NORTH);
        this.add(l2, BorderLayout.CENTER);

        JMenuBar menubar = new JMenuBar();
        JMenu menu1 = new JMenu("存款");
        JMenu menu2 = new JMenu("余额查询");
        JMenu menu3 = new JMenu("账户记录");
        JMenu menu4 = new JMenu("帮助");
        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        menubar.add(menu4);
        this.setJMenuBar(menubar);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cunkuan() {
        // 可以将存款相关的界面和逻辑放在这里
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 处理事件的逻辑可以写在这里
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.cunkuan(); // 调用存款方法
    }
}