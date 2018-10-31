/*
Zerihun Dinku Student number 1706218
 This a singleton to store a chat history
 */
object ChatHistory:ChatHistoryObservable{
    var chatHistory = mutableSetOf<ChatMessage>()

    fun insert(message: ChatMessage){
        chatHistory.add(message)
        notifyObservers(message)
    }
    private val chatMessage = mutableListOf<ChatHistoryObserver>()

    override fun registerObserver(observer: ChatHistoryObserver) {//register chat observer
        chatMessage.add(observer)
    }
    override fun notifyObservers(message: ChatMessage) {//notify the observer about the new chat
       for (observer in chatMessage){
            observer.newMessage(message)
       }
    }

    override fun deregisterObserver(observer: ChatHistoryObserver) {
        chatMessage.remove(observer)
    }
   override fun toString():String{
       var msg = "History:"

       for (message in chatHistory){
           msg += "\n\r$message "
       }
       return msg
    }

}