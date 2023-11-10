import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class MessageListener : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.author.isBot) return
        if (event.message.contentRaw == "ping") {
            event.channel.sendMessage("pong").queue()
        }
    }
}