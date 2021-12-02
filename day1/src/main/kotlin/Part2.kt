import java.io.File

class Part2 {

    fun calc(file: String): Int {
        var depths: List<Int> = File(file).useLines { it.toList() }.map<String, Int> { it.toInt() }.toList()
        var windowed = depths.windowed(3, 1).map { it.sum() }

        val it = windowed.iterator()

        var previous = windowed.first()
        var count = 0
        while (it.hasNext()) {
            val next = it.next()
            if (next > previous) count++
            previous = next
        }
        return count
    }
}