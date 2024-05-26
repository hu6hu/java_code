package shiyan.shiyan_06;

import javax.swing.text.*;

public class NumLimit extends PlainDocument {

    public NumLimit() {
        super();
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        // TODO Auto-generated method stub
        if(str==null) {
            return;
        }

        char[] s = str.toCharArray();
        int length = 0;
        //过滤非数字
        for (int i = 0; i < s.length; i++) {
            if ((s[i] >= '0') && (s[i] <= '9')) {
                s[length++] = s[i];
            }
            super.insertString(offs, new String(s, 0, length), a);
        }
    }


}

