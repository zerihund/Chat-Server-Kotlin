/*
Zerihun Dinku Student number 1706218
ChatHistoryObservable interface for chatHistory

 */

interface ChatHistoryObservable{
     fun registerObserver(observer:ChatHistoryObserver)
     fun deregisterObserver(observer:ChatHistoryObserver)
     fun notifyObservers (message:ChatMessage)

 }