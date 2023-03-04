package kr.code6150;

import kr.code6150.thread.ReadThread;
import kr.code6150.thread.WriteThread;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException{

        // Server 에 접속하는 Socket ()
        try {
            System.out.println("서버에 접속을 시도합니다.");
            Socket client = new Socket("127.0.0.1", 4982);

            System.out.println("이게 되네");

            new ReadThread(client).start();
            new WriteThread(client).start();

        } catch (ConnectException e) {
            System.out.println("서버 안열었잖아");
        }
    }

}
