/*
Zerihun Dinku Student number 1706218
chat server class to create the Socket and thread
 */
import java.net.ServerSocket

class ChatServer{

    fun serve(){
        ChatConsole.start()
        TopChatter.start()
        try {
            val serverSocket = ServerSocket(30003, 5)
            while (true) {
                val ss = serverSocket.accept()
                println("new connection${ss.inetAddress.hostAddress} ${ss.port}")
                val myThread = Thread(ConnectionHandler(ss.getInputStream(),ss.getOutputStream()))
                myThread.start()

            }
        }catch (e: Exception){
            println("Got exception: ${e.message}")
        }
    }
}