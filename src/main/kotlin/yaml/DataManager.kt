package yaml

class DataManager {
    companion object {
        private var BOT_TOKEN = ""

        fun initializeEnv() {
            BOT_TOKEN = System.getenv("BOT_TOKEN")
        }

        fun initializeData(
            botToken: String,
        ) {
            BOT_TOKEN = botToken
        }

        fun getBotToken(): String {
            return BOT_TOKEN
        }

    }
}