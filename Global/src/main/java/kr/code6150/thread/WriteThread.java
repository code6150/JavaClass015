package kr.code6150.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread extends Thread {

    // ReadThread 는 소켓의 정보를 필요로 한다. ( 이 정보는 외부에 있다. )
    // 클래스가 생성될 때 호출되는 생성자에는 인자를 통한 데이터 전달이 가능하다.
    //default constructor -> public ReadThread() {}
    private final Socket socket;
    public WriteThread(Socket socket) {
        this.socket = socket;
    }

    // Thread 는 start() 했을 때 자동으로 run() 메소드를 실행.
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        try (DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            while (socket.isConnected()) {
                System.out.print("보낼 메세지 : ");
                dos.writeUTF(sc.nextLine());
                dos.flush();
            }
        } catch (IOException e) {
            System.out.println("데이터를 쓰는데 실패했습니다.");
        }
    }

}