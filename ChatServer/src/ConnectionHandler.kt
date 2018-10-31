/*
Zerihun Dinku Student number 1706218
This class handles the chat server connection
 */
import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream

class ConnectionHandler(private val input:InputStream,private val out:OutputStream):Runnable{

   override fun run() {
        val printer=PrintStream(out,true)
        printer.println("Print the welcome message")
        printer.println("Enter your command:")
        while (true){
           val cI=CommandInterpreter(input,printer)
            cI.run()

        }
    }
}