package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.如果采用单线程，就无法处理并发，因为当第一个客户端连接到服务器但并没向服务端发数据，服务端会一直阻塞等待
 * 第一个客户端的数据(read)，程序会释放CPU,导致第二个客户端无法连接服务器端。
 * 2.如果采用多线程，就可以完成并发处理，原理是子线程自己阻塞；但是有缺点：每个客户端都新开一个线程，a.线程调度
 * 开销，用户态内核态来回切换 b.浪费内存资源；根源就是阻塞
 *
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        //专门用来监听，当有客户端链接到服务端时，accept就会解阻塞
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(9876));
        while (true) {
            System.out.println("等待连接");
            //socket专门负责通信
            Socket socket = serverSocket.accept();//阻塞，程序释放CPU资源
            System.out.println("链接成功");
//            System.out.println("start");
//            int read = socket.getInputStream().read(bs);//read也会阻塞
//            System.out.println("end data---"+read);
            new Thread(new ExecuteSocket(socket)).start();

        }

    }

    static class ExecuteSocket implements Runnable{
        Socket socket;
        public ExecuteSocket(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            byte[] bs = new byte[1024];

            try {
                socket.getInputStream().read(bs);
                String content = new String(bs);
                System.out.println(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
