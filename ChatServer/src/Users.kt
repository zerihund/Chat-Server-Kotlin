/*Zerihun Dinku Student number 1706218
This is a singleton for adding or removing user from users list*/

object Users
{
    val users = mutableSetOf<String>()
    fun insertUser(userName:String){//Checks if the user name already exist and insert the user to users list
        if (users.contains(userName)){
            println("The user exists in the list")
        }
        else {
            users.add(userName)
            println("Username set to $userName")
        }
    }
    fun removeUser(userName: String){//:excuted when the command is :quit
        users.remove(userName)
        println("user signed off $userName")
    }
    override fun toString():String{
        var usr ="List of Online Users->"

        for (name in users){

          usr +="\r$name"
        }
        return usr

    }
}