package yaml

import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.InputStream

class YamlLoader {
    companion object {
        private val logger = org.slf4j.LoggerFactory.getLogger(this::class.java)

        fun load(path: String) {
            logger.info("Loading yaml file: $path...")
            val inputStream: InputStream = File(path).inputStream()

            val yaml = Yaml()
            val data = yaml.load<Map<String, Any>>(inputStream)
            logger.info("Yaml file loaded: $path!")

            val source = data["source"]!!.toString()

            if (source == "ENV") {
                logger.info("Loading ENV variables...")
                DataManager.initializeEnv()
                logger.info("ENV variables loaded!")
                return
            }

            logger.info("Loading com.rokken.data from yml...")
            val botToken = data["bot-token"]!!.toString()

            DataManager.initializeData(botToken)
            logger.info("Data loaded!")
        }
    }
}