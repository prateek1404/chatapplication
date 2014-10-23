/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chatapplication;


import java.net.*;
import java.io.*;
import java.util.*;

class Server extends Thread
{
        Boolean flag=false;
	DataInputStream in;
	PrintStream out;
        Chat_Friend ch;

	public Server(Chat_Friend c)
        {
            ch=c;
                start();
	}

        public void run()
        {
            System.out.println("Inside the Server Constructor");
		try{
				ServerSocket s=new ServerSocket(5432);
				Socket soc;

                                System.out.println("Getting ready to recieve socket");
                                flag=true;
				soc=s.accept();
				InetAddress i1=soc.getInetAddress();
        		 System.out.println("Connection established with"+ i1);
        		 in=new DataInputStream(soc.getInputStream());
	 			 out=new PrintStream(soc.getOutputStream());
       			listenToClient(ch);

		}


		catch(Exception e)
		{
		}



        }

        public void addClient(Chat_Friend ch)
        {

            //listenToClient();
            System.out.println("Listening to Client");
        }

        public boolean getFlag()
        {
                return flag;
        }

	public void listenToClient(Chat_Friend c)
	{
                
               
		while(true)
		{
			try
			{
					String str="";
    		        if((str=in.readLine())!=null||((str=in.readLine()).equals(" "))==true)
    		        {
                                                        System.out.println(str);
							c.incomingChat(str);
							//System.out.println("hello");
					}
			}
			catch(Exception e)
			{

			}
		}


	}

	

}


