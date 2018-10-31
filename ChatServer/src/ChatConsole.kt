 /*
 Zerihun Dinku Student number 1706218
 This a singleton to print the chat message to the console
  */

object ChatConsole:ChatHistoryObserver{


    fun start(){
        ChatHistory.registerObserver(this)
    }

    override fun newMessage(message: ChatMessage) {

        println(message.toString())
    }
}