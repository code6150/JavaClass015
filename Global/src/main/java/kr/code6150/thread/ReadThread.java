package kr.code6150.thread;

// implements   -> 구현 ( interface 를 class 가 구현 할 때 쓰는 키워드 ) -> interface -> class
// extends      -> 확장 ( interface 나 class 조금 더 보충해줄 때 쓰는 키워드 ) -> 같은 타입끼리만 가능
//              -> ( 클래스의 경우 1:1 확장 / interface 의 경우 1:n 확장 )

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadThread extends Thread {

    // ReadThread 는 소켓의 정보를 필요로 한다. ( 이 정보는 외부에 있다. )
    // 클래스가 생성될 때 호출되는 생성자에는 인자를 통한 데이터 전달이 가능하다.
    //default constructor -> public ReadThread() {}
    private final Socket socket;
    public ReadThread(Socket socket) {
        this.socket = socket;
    }

    // Thread 는 start() 했을 때 자동으로 run() 메소드를 실행.
    @Override
    public void run() {
            try (DataInputStream dis = new DataInputStream(socket.getInputStream())) {
                while (socket.isConnected()) {
                    System.out.println("\r받은 메세지 : " + dis.readUTF());
                    System.out.print("보낼 메세지 : ");
                }
                dis.close();
            } catch (IOException e) {System.out.println("데이터를 읽는데 실패 했습니다.");}
    }

}
