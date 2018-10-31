/*
Zerihun Dinku Student number 1706218
This class is to show the message
 */
import java.time.LocalDateTime
class ChatMessage(val message:String, val name:String, val currentTime:LocalDateTime){

    override fun toString():String{
       return message + " from " + name + " at " + currentTime
    }
}