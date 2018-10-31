/*
Zerihun Dinku Student number 1706218
 This a singleton to print the top four chatters based on their number of messages
 */
object  TopChatter:ChatHistoryObserver{
    var topChat = ""
    fun start(){
        ChatHistory.registerObserver(this)
    }

    override fun newMessage(message: ChatMessage){
        var topChatter= Users.users.map { username->  username to ChatHistory.chatHistory
                .count { msg -> msg.name == username } }
                .sortedByDescending { it.second }.take(4)
                .fold("Top chatter->"){string,entry-> "$string\r\t ${entry.first} ................${entry.second}"}
            topChat = topChatter
            println(topChatter)
    }

    fun topChat(): String{
        return topChat
    }
}