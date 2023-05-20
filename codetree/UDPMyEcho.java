package codetree;

import java.net.*;
import java.io.*;

public class UDPMyEcho extends Exception {
    final static int MAXBUFFER = 512;

    public static void main(String[] args) {

        /* 인자값이 2개가 아니라면 :: 호스트ip,port 번호 */
        if (args.length != 2) {
            System.out.println("사용법: java UDPMyEcho host-ip port");
            System.exit(0);
        }

        /* 버퍼와 포트 */
        byte buffer[] = new byte[MAXBUFFER];
        int bufferLength = 0;
        int port = Integer.parseInt(args[1]);    // 입력 포트 번호 저장

        /* 송,수신 로직 실행 */
        try {

            /* IP주소 객체 */
            InetAddress inetaddr = InetAddress.getByName(args[0]);
            /* 송신용,수신용 데이터그램 객체 */
            DatagramSocket Socket = new DatagramSocket();    // 비연결형 클라이언트 소켓 생성
            DatagramPacket send_packet;                    // 송신용 데이터그램 패킷
            DatagramPacket recv_packet;                    // 수신용 데이터그램 패킷

            while (true) {
                // 키보드 입력 읽기
                System.out.print("Input Data : ");
                // 표준 입력 스트림으로 사용자 입력을 바이트 어레이에 넣음
                bufferLength = System.in.read(buffer);
                // 데이터 송신
                send_packet = new DatagramPacket(buffer, buffer.length, inetaddr, port);
                Socket.send(send_packet);
                // 에코 데이터 수신
                recv_packet = new DatagramPacket(buffer, buffer.length);
                Socket.receive(recv_packet);

                // 화면 출력을 위해 버퍼를 스트링으로 복사
                String result = new String(buffer, 0, bufferLength);
                System.out.println("Echo Data : " + result);

                if (result.indexOf("BYE") >= 0) // BYE 입력시 종료
                    break;
            }
            Socket.close();
        } catch (UnknownHostException ex) {    // 잘못된 서버 주소로 접근시
            System.out.println("Error in the host address ");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
