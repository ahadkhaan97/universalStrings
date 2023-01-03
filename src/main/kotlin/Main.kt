fun main() {
    solution(mutableListOf("amazon", "apple", "facebook", "google", "leetcode"), mutableListOf("l", "e"))
}

fun solution(words1: MutableList<String>, words2: MutableList<String>) {
    val listToReturn = mutableListOf<String>()
    val mapList = mutableListOf<HashMap<Char, Int>>()
    val mapList2 = mutableListOf<HashMap<Char, Int>>()

    for (i in 0 until words1.size) {
        val map = HashMap<Char, Int>()
        for (j in 0 until words1[i].length) {
            map[words1[i][j]] = (map[words1[i][j]] ?: 0) + 1
        }
        mapList.add(map)
    }

    for (i in 0 until words2.size) {
        val map = HashMap<Char, Int>()
        for (j in 0 until words2[i].length) {
            map[words2[i][j]] = (map[words2[i][j]] ?: 0) + 1
        }
        mapList2.add(map)
    }

    for (i in 0 until mapList.size) {
        var traversed = true
        for (j in 0 until mapList2.size) {
            mapList2[j].forEach {
                if (!mapList[i].containsKey(it.key) || mapList[i][it.key]!! < it.value) {
                    traversed = false
                }
            }
        }
        if (traversed)
            listToReturn.add(words1[i])
    }

    listToReturn.forEach {
        println(it)
    }
}

