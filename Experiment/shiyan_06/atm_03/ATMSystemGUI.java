package Experiment.shiyan_06.atm_03;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ATMSystemGUI {
    private JFrame frame;
    private ArrayList<Account> accounts;
    private Account currentAccount;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ATMSystemGUI window = new ATMSystemGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ATMSystemGUI() {
        accounts = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblWelcome = new JLabel("欢迎使用ATM系统");
        lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblWelcome.setBounds(140, 30, 200, 30);
        frame.getContentPane().add(lblWelcome);

        JButton btnLogin = new JButton("登录账户");
        btnLogin.setBounds(150, 80, 150, 30);
        frame.getContentPane().add(btnLogin);

        JButton btnRegister = new JButton("注册账户");
        btnRegister.setBounds(150, 120, 150, 30);
        frame.getContentPane().add(btnRegister);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
    }

    private void login() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JTextField cardIdField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        panel.add(new JLabel("卡号："));
        panel.add(cardIdField);
        panel.add(new JLabel("密码："));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "登录", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String cardId = cardIdField.getText();
            String password = new String(passwordField.getPassword());

            Account acc = judgeCardId(accounts, cardId);
            if (acc != null && acc.getPassword().equals(password)) {
                currentAccount = acc;
                JOptionPane.showMessageDialog(frame, "登录成功！", "消息", JOptionPane.INFORMATION_MESSAGE);
                showUserCommand();
            } else {
                JOptionPane.showMessageDialog(frame, "卡号或密码错误！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showUserCommand() {
        String[] options = {"查询账户", "存款", "取款", "修改密码", "退出"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(frame, "请选择操作", "用户操作", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (choice) {
                case 0:
                    showAccount(currentAccount);
                    break;
                case 1:
                    deposit();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    changePassword();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(frame, "退出成功！", "消息", JOptionPane.INFORMATION_MESSAGE);
                    return;
                default:
                    break;
            }
        }
    }

    private void register() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JPasswordField confirmPasswordField = new JPasswordField();
        JTextField amountField = new JTextField();

        panel.add(new JLabel("用户名："));
        panel.add(usernameField);
        panel.add(new JLabel("密码："));
        panel.add(passwordField);
        panel.add(new JLabel("确认密码："));
        panel.add(confirmPasswordField);
        panel.add(new JLabel("初始余额："));
        panel.add(amountField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "注册账户", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            double amount;

            try {
                amount = Double.parseDouble(amountField.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "请输入有效的初始余额！", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(frame, "两次输入的密码不一致！", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String cardId = getRandomCardId(accounts);
            Account account = new Account();
            account.setUsername(username);
            account.setPassword(password);
            account.setMoney(amount);
            account.setCardId(cardId);

            accounts.add(account);

            JOptionPane.showMessageDialog(frame, "恭喜" + username + "开户成功！\n您的卡号为：" + cardId, "开户成功", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void showAccount(Account acc) {
        JOptionPane.showMessageDialog(frame, "卡号：" + acc.getCardId() + "\n户主：" + acc.getUsername() + "\n余额：" + acc.getMoney(), "查询账户", JOptionPane.INFORMATION_MESSAGE);
    }

    private void deposit() {
        String input = JOptionPane.showInputDialog(frame, "请输入存款金额：");
        if (input != null && !input.isEmpty()) {
            try {
                double amount = Double.parseDouble(input);
                currentAccount.setMoney(currentAccount.getMoney() + amount);
                JOptionPane.showMessageDialog(frame, "存款成功！", "消息", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "请输入有效的金额！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void withdrawMoney() {
        String input = JOptionPane.showInputDialog(frame, "请输入取款金额：");
        if (input != null && !input.isEmpty()) {
            try {
                double amount = Double.parseDouble(input);
                if (amount <= currentAccount.getMoney()) {
                    currentAccount.setMoney(currentAccount.getMoney() - amount);
                    JOptionPane.showMessageDialog(frame, "取款成功！", "消息", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "余额不足！", "错误", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "请输入有效的金额！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void changePassword() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        JPasswordField passwordField = new JPasswordField();
        JPasswordField confirmPasswordField = new JPasswordField();

        panel.add(new JLabel("新密码："));
        panel.add(passwordField);
        panel.add(new JLabel("确认密码："));
        panel.add(confirmPasswordField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "修改密码", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (password.equals(confirmPassword)) {
                currentAccount.setPassword(password);
                JOptionPane.showMessageDialog(frame, "密码修改成功！", "消息", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "两次输入的密码不一致！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Account judgeCardId(ArrayList<Account> accounts, String cardId) {
        for (Account acc : accounts) {
            if (acc.getCardId().equals(cardId)) {
                return acc;
            }
        }
        return null;
    }

    private String getRandomCardId(ArrayList<Account> accounts) {
        Random r = new Random();
        while (true) {
            String cardId = "";
            for (int i = 0; i < 8; i++) {
                cardId += r.nextInt(10);
            }
            Account acc = judgeCardId(accounts, cardId);
            if (acc == null) {
                return cardId;
            }
        }
    }
}
