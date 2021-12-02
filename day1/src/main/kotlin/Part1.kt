import java.io.File

class Part1 {

    fun calc(file: String): Int {
        var depths: List<Int> = File(file).useLines { it.toList() }.map<String, Int> { it.toInt() }.toList()

        val it = depths.iterator()

        var previous = depths.first()
        var count = 0
        while (it.hasNext()) {
            val next = it.next()
            if (next > previous) count++
            previous = next
        }
        return count
    }
}