import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class MessageListener : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.author.isBot) return
        var msg = event.message.contentRaw
        msg = when {
            msg.startsWith("https://x.com") -> msg.replace("https://x.com", "https://vxtwitter.com")
            msg.startsWith("https://twitter.com") -> msg.replace("https://twitter.com", "https://vxtwitter.com")
            else -> return
        }
        event.message.delete().queue()
        event.channel.sendMessage("from ${event.author.asMention}\n$msg").queue()
    }
}