package Experiment.shiyan_06.atm_04;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//ATM系统入口类
public class ATMSystem extends JFrame {
    Scanner sc = new Scanner(System.in);

    private static ArrayList<Account> accounts = new ArrayList<>();//存储用户信息

    //构造函数
    public ATMSystem() {
        initUI();
    }

    //初始化页面
    private void initUI() {
        setTitle("中国银行");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//设置窗口在屏幕中居中显示

        JPanel panel = new JPanel();
        getContentPane().add(panel);
//        panel.setLayout(new GridLayout(2, 1, 10, 10));//行间距和列间距为10像素

        JButton loginButton = new JButton("登录");
        loginButton.addActionListener(e -> loginAdmin());//为登录按钮添加监视器，点击时调用loginAdmin()方法
        JButton registerButton = new JButton("开户");
        registerButton.addActionListener(e -> register());//为开户按钮添加监视器，点击时调用register()方法
        panel.add(loginButton);
        panel.add(registerButton);
    }

    //用户登录
    private void loginAdmin() {
        if (accounts.size() == 0) {
            JOptionPane.showMessageDialog(this, "当前系统没有账户，请先开户，再进行登录！");
            return;
        }//accounts为ArrayList的对象

        String cardId = JOptionPane.showInputDialog(this, "请输入您的卡号：");
        Account acc = getAccountByCardId(cardId, accounts);
        if (acc != null) {
            String password = JOptionPane.showInputDialog(this, "请输入您的密码：");
            if (acc.getPaasWord().equals(password)) {
                JOptionPane.showMessageDialog(this, "中国银行欢迎" + acc.getUserName() + "先生/女生进入银行系统,您卡号是：" + acc.getCardId());
                loginMenu(acc, accounts);
            } else {
                JOptionPane.showMessageDialog(this, "密码输入错误，请重新输入。");
            }
        } else {
            JOptionPane.showMessageDialog(this, "系统中不存在该账户，请重新输入。");
        }
    }

    //用户开户
    private void register() {
        Account account = new Account();
        String userName = JOptionPane.showInputDialog(this, "请您输入账户用户名:", "开户信息", JOptionPane.PLAIN_MESSAGE);
        account.setUserName(userName);

        String password1 = JOptionPane.showInputDialog(this, "请您输入账户密码:", "开户信息", JOptionPane.PLAIN_MESSAGE);
        String password2 = JOptionPane.showInputDialog(this, "请您再次输入账户密码:", "开户信息", JOptionPane.PLAIN_MESSAGE);
        if (password1.equals(password2)) {
            account.setPaasWord(password1);
        } else {
            JOptionPane.showMessageDialog(this, "对不起，您2次输入的密码不一致，请重新输入。");
            return;
        }
        double quotaMoney = Double.parseDouble(JOptionPane.showInputDialog(this, "请您设置账户当次取现的最大额度:", "开户信息", JOptionPane.PLAIN_MESSAGE));
        account.setQuotaMoney(quotaMoney);
        String cardId = RandomCardId(accounts);
        account.setCardId(cardId);
        accounts.add(account);
        JOptionPane.showMessageDialog(this, "恭喜" + userName + "先生/女生开户成功！您的卡号是：" + cardId + " 请妥善保管卡号，切勿告诉他人！");
    }

    //用户操作页面
    private void loginMenu(Account acc, ArrayList<Account> accounts) {
        JFrame frame = new JFrame("用户操作页面");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(new GridLayout(8, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton queryButton = new JButton("查询账户");
        queryButton.addActionListener(e -> showAccount(acc));
        JButton depositButton = new JButton("存款");
        depositButton.addActionListener(e -> depositMoney(acc, sc));
        JButton drawButton = new JButton("取款");
        drawButton.addActionListener(e -> drawMoney(acc, sc));
        JButton transferButton = new JButton("转账");
        transferButton.addActionListener(e -> transferMoney(sc, acc, accounts));
        JButton updatePasswordButton = new JButton("修改密码");
        updatePasswordButton.addActionListener(e -> updatePassWord(sc, acc));
        JButton exitButton = new JButton("退出");
        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "退出成功，欢迎下次光临，请取走您的银行卡！");
            frame.dispose();
        });
        JButton deleteAccountButton = new JButton("注销账户");
        deleteAccountButton.addActionListener(e -> deleteAccount(acc, sc, accounts));
        JButton queryTransactionButton = new JButton("查询流水");
        queryTransactionButton.addActionListener(e -> queryTransaction(acc));

        panel.add(queryButton);
        panel.add(depositButton);
        panel.add(drawButton);
        panel.add(transferButton);
        panel.add(queryTransactionButton);
        panel.add(updatePasswordButton);
        panel.add(deleteAccountButton);
        panel.add(exitButton);

        frame.setVisible(true);
    }

    //随机得到卡号
    private static String RandomCardId(ArrayList<Account> accounts) {
        Random r = new Random();
        while (true) {
            String cardId = "622682";
            for (int i = 0; i < 8; i++) {
                cardId += r.nextInt(10);
            }
            Account acc = getAccountByCardId(cardId, accounts);
            if (acc == null) {
                return cardId;
            }
        }
    }

    //查看是否有账户
    private static Account getAccountByCardId(String cardId, ArrayList<Account> accounts) {
        for (Account acc : accounts) {
            if (acc.getCardId().equals(cardId)) {
                return acc;
            }
        }
        return null;
    }

    //展示账户信息
    private static void showAccount(Account acc) {
        JOptionPane.showMessageDialog(null,
                "卡号：" + acc.getCardId() + "\n" +
                        "户主：" + acc.getUserName() + "\n" +
                        "余额：" + acc.getMoney() + "\n" +
                        "限额：" + acc.getQuotaMoney());
    }

    //存款
    private static void depositMoney(Account acc, Scanner sc) {
        double money = Double.parseDouble(JOptionPane.showInputDialog(null, "请输入存款金额："));
        acc.setMoney(acc.getMoney() + money);
        JOptionPane.showMessageDialog(null, "恭喜您，" + money + "元存款成功！");
        showAccount(acc);
    }

    //取款
    private static void drawMoney(Account acc, Scanner sc) {
        if (acc.getMoney() < 100) {
            JOptionPane.showMessageDialog(null, "对不起，您的账户余额是：" + acc.getMoney() + "元，不足100元，无法进行取钱业务");
            return;
        }
        double money = Double.parseDouble(JOptionPane.showInputDialog(null, "请输入取款金额："));
        if (money > acc.getQuotaMoney()) {
            JOptionPane.showMessageDialog(null, "对不起，您当前取款金额每次超过：" + acc.getQuotaMoney() + "限额的范围");
        } else if (money > acc.getMoney()) {
            JOptionPane.showMessageDialog(null, "对不起,您的余额不足,您的余额为：" + acc.getMoney());
        } else {
            acc.setMoney(acc.getMoney() - money);
            JOptionPane.showMessageDialog(null, "恭喜您，" + money + "取钱成功！您当前的余额为：" + (acc.getMoney()) + "元");
            showAccount(acc);
        }
    }

    //转账
    private static void transferMoney(Scanner sc, Account acc, ArrayList<Account> accounts) {
        if (accounts.size() < 2) {
            JOptionPane.showMessageDialog(null, "当前系统中不足2个账户，无法进行转账");
            return;
        }
        if (acc.getMoney() == 0) {
            JOptionPane.showMessageDialog(null, "您的账户余额为" + acc.getMoney() + "元，无法进行转账");
            return;
        }
        String cardId = JOptionPane.showInputDialog(null, "请输入对方的卡号：");
        if (cardId.equals(acc.getCardId())) {
            JOptionPane.showMessageDialog(null, "对不起，不能给自己转账");
            return;
        }
        Account account = getAccountByCardId(cardId, accounts);
        if (account == null) {
            JOptionPane.showMessageDialog(null, "对不起，您输入的卡号不存在，请重新输入。");
        } else {
            String userName = account.getUserName();
            String tip = "*" + userName.substring(1);
            String preName = JOptionPane.showInputDialog(null, "请您输入[" + tip + "]的姓氏");
            if (userName.startsWith(preName)) {
                double money = Double.parseDouble(JOptionPane.showInputDialog(null, "请您输入转账金额："));
                if (money > acc.getMoney()) {
                    JOptionPane.showMessageDialog(null, "您的账户余额不足，最多可以转" + acc.getMoney() + "元");
                } else {
                    acc.setMoney(acc.getMoney() - money);
                    account.setMoney(account.getMoney() + money);
                    JOptionPane.showMessageDialog(null, "恭喜您，" + money + "元转账成功！您的账户还剩下：" + acc.getMoney() + "元");
                }
            } else {
                JOptionPane.showMessageDialog(null, "对不起，您输入的信息有误！");
            }
        }
    }

    //修改密码
    private static void updatePassWord(Scanner sc, Account acc) {
        String oldPassword = JOptionPane.showInputDialog(null, "请输入当前账户的原始密码：");
        if (oldPassword.equals(acc.getPaasWord())) {
            String newPassword = JOptionPane.showInputDialog(null, "请你输入新的密码");
            String confirmPassword = JOptionPane.showInputDialog(null, "请你再次输入新的密码");
            if (newPassword.equals(confirmPassword)) {
                acc.setPaasWord(newPassword);
                JOptionPane.showMessageDialog(null, "密码修改成功！");
            } else {
                JOptionPane.showMessageDialog(null, "您2次输入的密码不一致");
            }
        } else {
            JOptionPane.showMessageDialog(null, "您输入的密码有误，请重新输入。");
        }
    }

    //销户
    private static void deleteAccount(Account acc, Scanner sc, ArrayList<Account> accounts) {
        int result = JOptionPane.showConfirmDialog(null, "请确认是否销户？", "销户确认", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            if (acc.getMoney() > 0) {
                JOptionPane.showMessageDialog(null, "注销失败，您的金额必须为0");
            } else {
                accounts.remove(acc);
                JOptionPane.showMessageDialog(null, "账户注销成功!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "当前账户继续保留！");
        }
    }

    //打印账户流水
    private static void queryTransaction(Account acc) {
        JFrame frame = new JFrame("账户流水");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("卡号: " + acc.getCardId() + "\n" +
                "户主: " + acc.getUserName() + "\n" +
                "余额: " + acc.getMoney() + "\n\n" +
                "交易流水:\n");
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("关闭");
        closeButton.addActionListener(e -> frame.dispose());
        panel.add(closeButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }


}


