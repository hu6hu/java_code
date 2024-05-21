package shiyan.shiyan_04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

//继承JFrame并且接口按键监听ActionListener
//ActionListener是一个监听器接口，接收动作事件的侦听器界面，用于处理GUI事件
class JS extends JFrame implements ActionListener {

    //历史记录的阵列
    JTextArea historyArea = new JTextArea();
    ArrayList<String> historyList = new ArrayList<>();

    private StringBuilder sBuilder = new StringBuilder(); //利用StringBuilder类来显示，以及区分两个操作数
    JTextArea text = new JTextArea();
    double a, b;
    Double sum;
    int operator;
    Stack<Double> numStack = new Stack<>();
    Stack<Character> opStack = new Stack<>();

    public JS() {
        setBounds(100, 100, 760, 450);
        setTitle("计算器");

        //创建菜单栏
        JMenuBar menubar = new JMenuBar();
        //创建菜单对象
        JMenu menu1 = new JMenu("查看(V)");
        JMenu menu2 = new JMenu("编辑(E)");
        JMenu menu3 = new JMenu("帮助(H)");
        //将菜单加入到菜单条中
        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        //将设置好的菜单条放在窗口中
        this.setJMenuBar(menubar);

        this.setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        //设置历史记录面板
        p3.setLayout(new BorderLayout());//给p3面板设立一个新的布局管理器
//        historyArea = new JTextArea();  //创建一个新的文本区域
        JScrollPane scrollPane = new JScrollPane(historyArea);  //创建一个滚动面板，显示指定组件的内容，当组件的内容大于视图时，会显示水平和垂直滚动条。
        p3.add(new JLabel("History"), BorderLayout.NORTH);//将标签history放入p3面板的北部
        p3.add(scrollPane, BorderLayout.CENTER); // Adding JScrollPane for scrolling
        this.add(p3, BorderLayout.CENTER);

        //设置组件大小
        text.setPreferredSize(new Dimension(740, 80));//setPreferredSize方法，接受一个Dimension对象作为一个参数，包含了组件的建议宽度和高度

        //设置文本框
        p1.add(text);
        this.add(p1, BorderLayout.NORTH);

        p2.setLayout(new FlowLayout());//FlowLayout 创建一个流布局管理器
        p2.setLayout(new GridLayout(6, 4));
        //添加按钮
        JButton[] buttons = new JButton[24];
        buttons[1] = new JButton("C");
        buttons[0] = new JButton("CE");
        buttons[2] = new JButton("(");
        buttons[3] = new JButton(")");
        buttons[4] = new JButton("9");
        buttons[5] = new JButton("8");
        buttons[6] = new JButton("7");
        buttons[7] = new JButton("/");
        buttons[8] = new JButton("6");
        buttons[9] = new JButton("5");
        buttons[10] = new JButton("4");
        buttons[11] = new JButton("*");
        buttons[12] = new JButton("3");
        buttons[13] = new JButton("2");
        buttons[14] = new JButton("1");
        buttons[15] = new JButton("-");
        buttons[16] = new JButton(".");
        buttons[17] = new JButton("0");
        buttons[18] = new JButton("%");
        buttons[19] = new JButton("+");
        buttons[20] = new JButton("=");
        buttons[21] = new JButton("^");
        buttons[22] = new JButton("");
        buttons[23] = new JButton("");

        //将按钮组件添加入容器
        for (int i = 0; i < buttons.length; i++)
            p2.add(buttons[i]);
        //设置按钮的背景颜色为橙色，并添加到面板中
        buttons[20].setBackground(Color.ORANGE);
        p2.add(buttons[20]);

        //将面板p2加入到窗体中，布局：中间
        add(p2, BorderLayout.WEST);

        //为每一个事件(按钮)添加监视器
        for (int i = 0; i < buttons.length; i++)
            buttons[i].addActionListener(this);


        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //点击X号可以关闭程序
    }


    //事件处理
    public void actionPerformed(ActionEvent e) {    //e是一个 ActionEvent 对象，表示用户执行的动作事件

        String lab = e.getActionCommand();  //getActionCommand() 方法返回与事件关联的命令字符串，通常用于识别触发事件的组件

        if (lab.equals("0") || lab.equals("1") || lab.equals("2") || lab.equals("3") ||
                lab.equals("4") || lab.equals("5") || lab.equals("6") || lab.equals("7") ||
                lab.equals("8") || lab.equals("9") || lab.equals(".")) {
            sBuilder.append(lab);//将用户按下的按钮字符 lab（即用户点击的按钮上显示的字符）追加到字符串构建器 sBuilder 中。
            text.setText(sBuilder.toString());//将字符串构建器 sBuilder 中的内容转换为字符串，并将其设置为文本区域 text 的文本内容，以便用户能够看到他们输入的内容。
        } else if (lab.equals("CE")) {
            if (sBuilder.length() > 0) {
                sBuilder.deleteCharAt(sBuilder.length() - 1);//删除字符串构建器（StringBuilder）sBuilder 中的最后一个字符
                text.setText(sBuilder.toString());//将删除后的字符串设置为文本区域（JTextField）text 的文本内容。
            }
        } else if (lab.equals("C")) {
            sBuilder = new StringBuilder();
            text.setText("");
        } else if (lab.equals("+") || lab.equals("*") || lab.equals("/") || lab.equals("%")||lab.equals("^")) {
            sBuilder.append(lab);
            text.setText(sBuilder.toString());
        } else if (lab.equals("-")) {
            // 判断是否为减号或负号
            if (isMinusSign('-', sBuilder.toString(), sBuilder.length())) {
                sBuilder.append("-");
                text.setText(sBuilder.toString());
            } else {
                sBuilder.append(lab);
                text.setText(sBuilder.toString());
            }
        } else if (lab.equals("(")) {
            sBuilder.append("(");
            text.setText(sBuilder.toString());
        } else if (lab.equals(")")) {
            sBuilder.append(")");
            text.setText(sBuilder.toString());
        } else if (lab.equals("=")) {
            String expression = sBuilder.toString();//将字符串构建器（StringBuilder）sBuilder 中的内容转换为字符串
//            System.out.println(expression);
            sum = evaluate(expression);//通过 evaluate() 方法计算表达式的值
            text.setText(sum.toString());//将计算结果转换为字符串，并设置为文本区域的文本内容
            sBuilder = new StringBuilder();//将字符串构建器 sBuilder 重新实例化为一个新的空的字符串构建器
            sBuilder.append(sum);//并将计算结果追加到新的字符串构建器中。

            historyList.add(expression + " = " + sum);
            updateHistory();
        }
    }

    // 判断字符是否是减号或负号
    private boolean isMinusSign(char c, String expression, int index) {
        if (c != '-') {
            return false; // 如果不是减号直接返回false
        }

        // 如果是字符串的第一个字符，或者前一个字符是左括号，则为负号
        if (index == 0 || expression.charAt(index - 1) == '(') {
            return true;
        }

        // 否则为减号
        return false;
    }



    //计算表达式的值
    private double evaluate(String expression) {

        //清空操作数栈（numStack）中的所有元素。
        numStack.clear();
        //操作符栈（opStack）中的所有元素。
        opStack.clear();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);//根据i返回字符
            if (Character.isDigit(c) || c == '.') {  //isDigit方法：判断是否为数字
                StringBuilder num = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    num.append(expression.charAt(i++));
                }
                i--;
                numStack.push(Double.parseDouble(num.toString()));//parseDouble方法：返回一个新 double初始化为指定的代表的值 String
            } else if (c == '(') {
                opStack.push(c);
            } else if (c == ')') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    performOperation();
                }
                opStack.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%'|| c == '^') {
                while (!opStack.isEmpty() && precedence(opStack.peek()) >= precedence(c)) {
                    performOperation();     //.peek()查看此堆栈顶部的对象，而不从堆栈中删除它。
                }
                opStack.push(c);
            }

        }

        while (!opStack.isEmpty()) {
            performOperation();
        }

        return numStack.pop();
    }

    //执行计算
    private void performOperation() {
        char op = opStack.pop();
        double num2 = numStack.pop();
        double num1 = numStack.pop();
        switch (op) {
            case '+':
                numStack.push(num1 + num2);
                break;
            case '-':
                numStack.push(num1 - num2);
                break;
            case '*':
                numStack.push(num1 * num2);
                break;
            case '/':
                if (num2 != 0)
                    numStack.push(num1 / num2);
                else
                    numStack.push(Double.NaN); // Indicate division by zero
                break;
            case '^':
                numStack.push(Math.pow(num1, num2));
                break;
            case '%':
                numStack.push(num1 % num2);
        }
    }

    //操作符
    private int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '%':
                return 3;
            case '^':
                return 4;
            default:
                return -1;
        }
    }

    //更新记录
    private void updateHistory() {
        historyArea.setText(""); // 清空历史记录面板的内容
        for (String history : historyList) {
            historyArea.append(history + "\n"); // 将历史记录逐行添加到历史记录面板
        }
    }

    public static void main(String[] args) {
        new JS();
    }
}