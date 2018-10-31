/*Zerihun Dinku Student number 1706218
  Command Interpreter for Chat Server. It observes when there is change in chat history*/

import java.io.*
import java.time.LocalDateTime
import java.util.*

class CommandInterpreter(var input: InputStream, var out: PrintStream): Runnable,ChatHistoryObserver {
    init {
        ChatHistory.registerObserver(this)
    }
    override fun newMessage(message: ChatMessage) {//override chatHistoryObserver new Message function
        out.println(message)
    }
    override fun run() {
        println("Welcome to 2018 chat server")
        println("Please, enter your command ")

        val userInput = Scanner(input)
        var quit = false
        var signedIn = false
        var userName = ""

        do {
            val command = userInput.nextLine()
            if (!signedIn) {// if the user not signed user inserted to user list
                if (command.startsWith(":")) {
                    var userCommand: List<String> = command.split(" ")
                    if (userCommand.size ==2 ) {
                        when (userCommand[0]) {
                            ":user" -> {
                                userName = userCommand[1]
                                if (Users.users.contains(userName)){
                                    out.println("The user name is taken: Enter a different user name: ")
                                }
                                else {
                                    Users.insertUser(userName)
                                    out.println("The user set to $userName.")
                                    signedIn = true
                                }
                            }
                            else -> out.println("User name not set. Use command :user to set it")
                        }
                    }
                    else{
                        out.println("User name not set. Use command :user to set it")
                    }
                } else {
                    out.println("User name not set. Use command :user to set it")
                }
            } else {
                //This is executed if user is signed in
                if (command.startsWith(":")) {
                    var userCommand: List<String> = command.split(" ")
                    when (userCommand[0]) {
                        ":exit" -> out.println("Did not get it :exit")
                        ":user" -> out.println("User name already specified ")
                        ":user" -> out.println("User name not set: no user name specified")
                        ":Users" -> out.println(Users)//Users.users.forEach { out.println(it) }
                        ":messages" -> out.println(ChatHistory)
                        ":top"->out.println(TopChatter.topChat)
                        ":quit" -> {Users.removeUser(userName)
                            quit=true
                        }
                        else -> out.println("Did not get it.")
                    }
                } else {
                    val timeNow = LocalDateTime.now()       //This excuted when the user name is set
                    val messages = ChatMessage(command, userName, timeNow)
                    ChatHistory.insert(messages)
                }
            }

        } while (!quit)
        println("Goodbye")
    }


}
