package codetree;

// 컴파일: javac UDPMyEchoServer.java
// 사용법: java UDPMyEchoServer 3000

import java.net.*;
import java.io.*;

public class UDPMyEchoServer {
    final int MAXBUFFER = 512;

    public static void main(String[] args) {
        // main함수의 인자값인 포트를 저장 
        int arg_port = Integer.parseInt(args[0]);
        // UDPMyEchoServer 객체의 work() 호출
        new UDPMyEchoServer().work(arg_port);
    }

    void work(int arg_port) {
        int port = arg_port;
        byte buffer[] = new byte[MAXBUFFER];
        try {
            DatagramSocket Socket = new DatagramSocket(port);        // 비연결형 서버 소켓 객체 생성
            DatagramPacket recv_packet;
            System.out.println("Running the UDP Echo Server... ");

            while (true) {
                // 데이터 수신
                recv_packet = new DatagramPacket(buffer, buffer.length);
                Socket.receive(recv_packet);

                // 수신패킷의 데이터를 받아 대문자로 변환
                String sentence = new String(recv_packet.getData());
                String capitalizedSentence = sentence.toUpperCase();

                // 대문자 데이터를 byte배열로 변환
                byte tx_buffer[] = new byte[MAXBUFFER];
                tx_buffer = capitalizedSentence.getBytes();

                // 에코 데이터 생성 및 송신: 송신용 패킷 생성
                DatagramPacket send_packet = new DatagramPacket
                        //(recv_packet.getData(), recv_packet.getLength(),
                        (tx_buffer, recv_packet.getLength(),
                                recv_packet.getAddress(), recv_packet.getPort());

                // 송신용 패킷 송신
                Socket.send(send_packet);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

// End of File