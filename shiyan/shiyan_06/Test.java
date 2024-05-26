package shiyan.shiyan_06;

import java.io.*;
import java.util.*;

public class Test {

    static File userfile;  //储存用户账户信息的文件
    static FileReader fr;
    static FileWriter fw;
    static List<Account> user;  //储存账户的集合
    public static String[] str,strs,len;
    //static String strs = new String();
    public static void main(String args[]) {

        user = new ArrayList<>();
        System.out.println(user.isEmpty());
		/*userfile = new File("userfile.txt");
		if(!userfile.exists()) {
			try {
				userfile.createNewFile();
				fw = new FileWriter("userfile.txt");
				str = new String[5];
				users();
				fw.write(str[0]);
				//fw.write("\n");
				fw.write(str[1]);

				fw.flush();
				fw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}*/

        login();
        new Login();
    }

    public static void login() {
        try {
            fr = new FileReader("userfile.txt");
            BufferedReader bfr = new BufferedReader(fr);

            len = new String[20];
            for(int i = 0;i<5;i++) {

                while((len[i]=bfr.readLine())=="\n") {

                    break;

                    //String[] ms = new String[5];
                    //ms = len.split("\\s");
                    //System.out.println(ms[0]);
					/*ms = len.split("\\s+");
					Account a = new Account(ms[0], ms[1], ms[2]);
					user.add(a);*/
                }
            }

            System.out.println(len[1]);
            strs = new String[20];

            for(int i = 0;i<2;i++) {
                strs = len[i].split("\\s");
                Account a = new Account(strs[0],strs[1], strs[2]);
                user.add(a);
                System.out.println(user.get(i).passwd);
            }
            //System.out.println(user.size());
            //System.out.println(user.get(0).money);type name = new type();
            fr.close();
            bfr.close();

            //System.out.printf(strs[0]);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

	/*public static void users() {
		str[0] = "286080822 1998 10000\n";
		str[1] = "52554917 1999 10000\n";
	}*/
}

