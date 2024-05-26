package shiyan.shiyan_06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Account {

    String id;
    String passwd,money;
    static String user;
    //SimpleDateFormat sdate;
    //Date currentTime;

    public Account(String id,String passwd,String money) {
        this.id = id;
        this.passwd = passwd;
        this.money = money;
    }

    //实现取钱的方法，会在取钱界面事件监听中被调用，后面几个方法与之类似
    public static void outmoney(int mymoney)throws Exception{
        int lmoney = Integer.parseInt(Login.mymoney);

        String uu = Login.myid+" "+Login.mypasswd+" "+Login.mymoney;
        //System.out.println(uu);
        lmoney-=mymoney;
        Login.mymoney =String.valueOf(lmoney);
        for(int i = 0;i<2;i++) {
            if(uu.equals(Test.len[i])) {
                user = Login.myid+" "+Login.mypasswd+" "+Login.mymoney;
                System.out.println(user);
                Test.len[i] = user;
                Writer fw = new FileWriter("userfile.txt");
                //Reader fr = new FileReader("userfile.txt");
                for(int j = 0;j<2;j++) {
                    fw.write(Test.len[i]+"\n");
                }
                fw.flush();
                fw.close();

                //Test.user.get(i).money = Login.mymoney;
                //throw new Exception("取钱成功");
            }
        }

    }

    public static void inmoney(int money)throws Exception{
        int lmoney = Integer.parseInt(Login.mymoney);

        String uu = Login.myid+" "+Login.mypasswd+" "+Login.mymoney;
        //System.out.println(uu);
        lmoney+=money;
        Login.mymoney =String.valueOf(lmoney);
        for(int i = 0;i<2;i++) {
            if(uu.equals(Test.len[i])) {
                user = Login.myid+" "+Login.mypasswd+" "+Login.mymoney;
                System.out.println(user);
                Test.len[i] = user;
                break;

            }
        }

        Writer fw = new FileWriter("userfile.txt");
        for(int i = 0;i<2;i++) {
            fw.write(Test.len[i]+"\n");
        }
        fw.flush();
        fw.close();

    }

    public static String cha() throws Exception{
        FileReader fr = new FileReader("record"+Login.myid+".txt");
        BufferedReader bfr = new BufferedReader(fr);
        String record,fb;
        StringBuffer sb = new StringBuffer();

        while((record=bfr.readLine())!=null) {
            System.out.println(record);
            sb.append(record+"\n");
        }
        fb = sb.toString();
        return fb;
    }

    public static boolean cpasswd(String pwd,String npwd,String spwd) throws Exception {
        boolean flag = false;
        if(pwd.equals(Login.mypasswd)) {
            if(npwd.length()==6) {
                if(npwd.equals(spwd)) {
                    String uu = Login.myid+" "+Login.mypasswd+" "+Login.mymoney;
                    Login.mypasswd = npwd;
                    System.out.println(Login.mypasswd);
                    for(int i = 0;i<2;i++) {
                        if(uu.equals(Test.len[i])) {
                            user = Login.myid+" "+Login.mypasswd+" "+Login.mymoney;
                            System.out.println(user);
                            Test.len[i] = user;
                            System.out.println(Test.len[i]);
                            break;

                        }
                    }
                    Writer fw = new FileWriter("userfile.txt");
                    for(int i = 0;i<2;i++) {
                        fw.write(Test.len[i]+"\n");
                    }
                    fw.flush();
                    fw.close();
                    flag = true;
                }else {
                    flag = false;
                }
            }else {
                flag = false;
            }
        }else {
            flag = false;
        }

        return flag;
    }
}

