/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chatapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author prateek
 */
public class AccountDetails implements Serializable{

        private String Username;
        private String Screenname;
        private String Password;
        //public ArrayList<String> iplist;
        int Age;
        File f;
        FileOutputStream fos;

        public AccountDetails(String username,String screenname,String password,int age) throws FileNotFoundException
        {
            Username=username;
            Screenname=screenname;
            Password=password;
            Age=age;
          //  iplist=new ArrayList<String>();
            fos=new FileOutputStream(username);
        }
        public String getUsername()

        {
            return Username;

        }
        public String getPassword()
        {
            return Password;
        }
        public String getScreenname()
        {
            return Screenname;
        }

        public String toString()
        {
            StringBuffer buffer=new StringBuffer();
            buffer.append(Username);
            buffer.append(Screenname);
            buffer.append(Password);
            buffer.append(String.valueOf(Age));

            return buffer.toString();

        }


}
