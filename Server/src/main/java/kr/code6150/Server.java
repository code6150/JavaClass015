package kr.code6150;

import kr.code6150.thread.ReadThread;
import kr.code6150.thread.WriteThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        // Socket ( ServerSocket ) - 포트 번호를 통해 생성
        ServerSocket ss = new ServerSocket(4982);

        // 클라이언트의 접속 요청을 허용/차단 할 수 있다.

        System.out.println("클라이언트의 연결 요청을 기다립니다.");
        Socket client = ss.accept();

        System.out.println(client.getPort() + "의 연결 요청을 수락했습니다.");

        // 무한정 반복하여 주고 받는 데이터를 만들고 싶다.

        new ReadThread(client).start();
        new WriteThread(client).start();

    }

}
