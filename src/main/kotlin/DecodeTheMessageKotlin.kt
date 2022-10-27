import java.util.HashMap

object DecodeTheMessageKotlin {
    @JvmStatic
    fun main(args: Array<String>) {
        val key = "the quick brown fox jumps over the lazy dog"
        val message = "vkbs bs t suepuv"
        decodeMessage(key, message)
    }

  private  fun decodeMessage(key: String, message: String): String? {
        var alphabet = 'a'
        val hs = HashMap<Char, Char>()
        for (c in key) {
            if (c.toString() == " " || hs.containsKey(c))
                continue
            else {
                hs[c] = alphabet
                alphabet++
            }
        }
        val sb = StringBuilder(message)
        for (c in message.indices) {
            if (message[c].toString() != " ")
                sb.setCharAt(c, hs[message[c]]!!)
        }
        return sb.toString()
    }
}