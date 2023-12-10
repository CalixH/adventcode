import kotlin.Long.Companion.MAX_VALUE

fun main() {
    val input = generateSequence(::readLine)
    val lines = input.toList()
    val bids = mutableListOf<Int>()
    val cards = mutableListOf<String>()
    val map = mutableMapOf('A' to 0, 'K' to 0, 'Q' to 0, 'J' to 0, 'T' to 0, '9' to 0, '8' to 0, '7' to 0, '6' to 0,
        '5' to 0, '4' to 0, '3' to 0, '2' to 0)
    for (i in lines) {
        bids.add(i.split(" ")[1].toInt())
        cards.add(i.split(" ")[0])
    }
    for (i in cards) {
        val chars = i.toCharArray()
        for (j in chars) {
            map[j] = map[j]!! + 1
        }

    }
}

fun main6() {
    val input = generateSequence(::readLine)
    val lines = input.toList()
    val times = lines[0].split(":")[1].split(" ").toMutableList()
    times.removeAll(listOf(""))
    val dist = lines[1].split(":")[1].split(" ").toMutableList()
    dist.removeAll(listOf(""))

    var total = 0
    for (j in 0..51699878) {
        if (j*(51699878L-j) > 377117112241505L) {
            total++
        }
    }

    println(total)
}

fun main5() {
    val input = generateSequence(::readLine)
    val lines = input.toList()
    var seeds = listOf<String>()
    val soil = mutableListOf<Triple<Long,Long,Long>>()
    val fert = mutableListOf<Triple<Long,Long,Long>>()
    val water = mutableListOf<Triple<Long,Long,Long>>()
    val light = mutableListOf<Triple<Long,Long,Long>>()
    val temp = mutableListOf<Triple<Long,Long,Long>>()
    val hum = mutableListOf<Triple<Long,Long,Long>>()
    val loc = mutableListOf<Triple<Long,Long,Long>>()

    var soilB = false
    var fertB = false
    var waterB = false
    var lightB = false
    var tempB = false
    var humB = false
    var locB = false

    for (i in lines) {
        if (i.contains("seeds:")) {
            val str = i.substring(startIndex = 7)
            seeds = str.split(" ")
        } else if (i.contains("seed-to-soil")) {
            soilB = true
        } else if (i.contains("soil-to-fertilizer")) {
            fertB = true
        } else if (i.contains("fertilizer-to-water")) {
            waterB = true
        } else if (i.contains("water-to-light")) {
            lightB = true
        } else if (i.contains("light-to-temperature")) {
            tempB = true
        } else if (i.contains("temperature-to-humidity")) {
            humB = true
        } else if (i.contains("humidity-to-location")) {
            locB = true
        } else if (i == "") {
             soilB = false
             fertB = false
             waterB = false
             lightB = false
             tempB = false
             humB = false
             locB = false
        } else if (soilB) {
            val str = i.split(" ")
            soil.add(Triple(str[0].toLong(), str[1].toLong(), str[2].toLong()))
        } else if (fertB) {
            val str = i.split(" ")
            fert.add(Triple(str[0].toLong(), str[1].toLong(), str[2].toLong()))
        } else if (waterB) {
            val str = i.split(" ")
            water.add(Triple(str[0].toLong(), str[1].toLong(), str[2].toLong()))
        } else if (lightB) {
            val str = i.split(" ")
            light.add(Triple(str[0].toLong(), str[1].toLong(), str[2].toLong()))
        } else if (tempB) {
            val str = i.split(" ")
            temp.add(Triple(str[0].toLong(), str[1].toLong(), str[2].toLong()))
        } else if (humB) {
            val str = i.split(" ")
            hum.add(Triple(str[0].toLong(), str[1].toLong(), str[2].toLong()))
        } else if (locB) {
            val str = i.split(" ")
            loc.add(Triple(str[0].toLong(), str[1].toLong(), str[2].toLong()))
        }
    }

    var min: Long = MAX_VALUE

    for (k in seeds.indices) {
        if (k % 2 == 0) {
            for (l in 0..<seeds[k+1].toLong()) {
                var i =seeds[k].toLong()+l
                for (j in soil) {
                    if (i >= j.second && i < j.second + j.third ) {
                        i=j.first + (i - j.second)
                        break
                    }
                }
                for (j in fert) {
                    if (i >= j.second && i < j.second + j.third ) {
                        i=j.first + (i - j.second)
                        break
                    }
                }
                for (j in water) {
                    if (i >= j.second && i < j.second + j.third ) {
                        i=j.first + (i - j.second)
                        break
                    }
                }
                for (j in light) {
                    if (i >= j.second && i < j.second + j.third ) {
                        i=j.first + (i - j.second)
                        break
                    }
                }
                for (j in temp) {
                    if (i >= j.second && i < j.second + j.third ) {
                        i=j.first + (i - j.second)
                        break
                    }
                }
                for (j in hum) {
                    if (i >= j.second && i < j.second + j.third ) {
                        i=j.first + (i - j.second)
                        break
                    }
                }
                for (j in loc) {
                    if (i >= j.second && i < j.second + j.third ) {
                        i=j.first + (i - j.second)
                        break
                    }
                }

                if (i < min) {
                    min = i
                }

            }
        } else {
            continue
        }
    }

    println(min)

}

fun main4() {
    val input = generateSequence(::readLine)
    val lines = input.toList()

    val mynum = mutableListOf<String>()
    val num = mutableListOf<String>()

    for (i in lines) {
        mynum.add(i.split("|")[1])
        num.add(i.split("|")[0].split(":")[1])
    }

    var totalsum = 0
    val mycards = mutableListOf<MutableList<String>>()
    val cards = mutableListOf<MutableList<String>>()

    val augmycards = mutableListOf<MutableList<String>>()
    val augcards = mutableListOf<MutableList<String>>()

    for (i in mynum.indices) {
        val mynums = mynum[i].split(" ").toMutableList()
        mynums.removeAll(listOf(""))
        mycards.add(mynums)
        augmycards.add(mynums)
        val nums = num[i].split(" ").toMutableList()
        nums.removeAll(listOf(""))
        cards.add(nums)
        augcards.add(nums)
    }
    var i = 0
    while (i < mycards.size) {
        var sum = 0
        for (j in mycards[i]) {
            if (cards[i].contains(j)) {
                sum++
            }
        }
        val count = augmycards.count{ it == mycards[i] }
        for (k in 1.. count) {
            for (j in 1..sum) {
                augcards.add(cards[i + j])
                augmycards.add(mycards[i + j])
            }
        }
        i++
    }
    println(augmycards.size)
}



fun main3() {
    val input = generateSequence(::readLine)
    val lines = input.toList()
    val chars = mutableListOf<CharArray>()
    for (i in lines) {
        chars.add(i.toCharArray())
    }
    var sum = 0
    val location = mutableListOf<Pair<Int, Int>>()
    val map = mutableMapOf<Pair<Int, Int>, Pair<Int, Int>>()

    for (i in chars.indices) {
        var checked = false
        var start = 0
        var end: Int
        var good = false

        for (j in chars[i].indices) {
            if (chars[i][j].isDigit() && !checked) {
                good = numCheck(chars, i, j, location)
                start = j
                checked = true
            } else if (!chars[i][j].isDigit() && checked) {
                checked = false
                end = j-1
                if (good) {
                    val num = chars[i].slice(start..end).joinToString(separator = "").toInt()
                    if (map[location[location.size-1]] == null) {
                        map[location[location.size-1]] = Pair(num, 1)

                    } else {
                        map[location[location.size-1]] = Pair(map[location[location.size-1]]!!.first * num, map[location[location.size-1]]!!.second + 1)
                    }
                }
            } else if ( j == chars[i].size - 1 && chars[i][j].isDigit()) {
                checked = false
                end = j
                if (good) {
                    val num = chars[i].slice(start..end).joinToString(separator = "").toInt()
                    if (map[location[location.size-1]] == null) {
                        map[location[location.size-1]] = Pair(num, 1)

                    } else {
                        map[location[location.size-1]] = Pair(map[location[location.size-1]]!!.first * num, map[location[location.size-1]]!!.second + 1)
                    }
                }
            }
        }
    }
    for (i in map) {
        if (i.value.second == 2) {
            sum += i.value.first
        }
    }
    println(sum)
}

fun numCheck(chars: MutableList<CharArray>, i: Int, j: Int, location: MutableList<Pair<Int, Int>>): Boolean {
    if (i-1 in chars.indices && j-1 in chars[i-1].indices && chars[i-1][j-1] == '*' ) {

        location.add(Pair(i-1,j-1))
        return true
    }
    if (i-1 in chars.indices && j in chars[i-1].indices && chars[i-1][j] == '*') {

        location.add(Pair(i-1,j))
        return true
    }
    if (i-1 in chars.indices && j+1 in chars[i-1].indices && chars[i-1][j+1] == '*') {

        location.add(Pair(i-1,j+1))
        return true
    }
    if (i in chars.indices && j-1 in chars[i].indices && chars[i][j-1] == '*') {

        location.add(Pair(i,j-1))
        return true
    }
    if (i in chars.indices && j+1 in chars[i].indices && chars[i][j+1] == '*') {

        location.add(Pair(i,j+1))
        return true
    }
    if (i+1 in chars.indices && j-1 in chars[i+1].indices && chars[i+1][j-1] == '*') {

        location.add(Pair(i+1,j-1))
        return true
    }
    if (i+1 in chars.indices && j in chars[i+1].indices && chars[i+1][j] == '*') {

        location.add(Pair(i+1,j))
        return true
    }
    if (i+1 in chars.indices && j+1 in chars[i+1].indices && chars[i+1][j+1] == '*') {

        location.add(Pair(i+1,j+1))
        return true
    }
    if (i in chars.indices && j+1 in chars[i].indices && chars[i][j+1].isDigit()) {
        return numCheck(chars, i, j+1, location)
    }
    return false
}



fun main2() {
    val input = generateSequence(::readLine)
    val lines = input.toList()

    var sum = 0

    for (i in lines) {
        var red = 0
        var green = 0
        var blue = 0
        val substr = i.substring(startIndex = 8)
        var num: Int
        var color: String
        for (j in substr.indices) {
            if (substr[j].isDigit() && substr[j+1].isDigit()) {
                num = 10*substr[j].digitToInt() + substr[j+1].digitToInt()
                color = substr.substring(startIndex = j+3, endIndex = j+6)
                when (color) {
                    "red" -> if (num > red) red = num
                    "blu" -> if (num > blue) blue = num
                    "gre" -> if (num > green) green = num
                }
            } else if (substr[j].isDigit()) {
                num = substr[j].digitToInt()
                color = substr.substring(startIndex = j+2, endIndex = j+5)
                when (color) {
                    "red" -> if (num > red) red = num
                    "blu" -> if (num > blue) blue = num
                    "gre" -> if (num > green) green = num
                }
            }
        }
        sum += red*green*blue
    }
    println( sum)
}

fun main1() {
    val input = generateSequence(::readLine)
    val lines = input.toList()
    var sum = 0
    var firstPosition = 0
    var lastPosition = 0
    for (i in lines) {
        val chars = i.toCharArray()
        var first = 0
        var last = 0
        for (j in chars) {
            if (j.isDigit()) {
                first = j.digitToInt()
                firstPosition = chars.indexOf(j)
                break
            }
        }
        for (j in chars.size - 1 downTo 0) {
            if (chars[j].isDigit()) {
                last = chars[j].digitToInt()
                lastPosition = j
                break
            }
        }

        val one = i.indexOf("one")
        val two = i.indexOf("two")
        val three = i.indexOf("three")
        val four = i.indexOf("four")
        val five = i.indexOf("five")
        val six = i.indexOf("six")
        val seven = i.indexOf("seven")
        val eight = i.indexOf("eight")
        val nine = i.indexOf("nine")

        val rev = i.reversed()

        val onel = rev.indexOf("eno")
        val twol = rev.indexOf("owt")
        val threel = rev.indexOf("eerht")
        val fourl = rev.indexOf("ruof")
        val fivel = rev.indexOf("evif")
        val sixl = rev.indexOf("xis")
        val sevenl = rev.indexOf("neves")
        val eightl = rev.indexOf("thgie")
        val ninel = rev.indexOf("enin")

        if (one >= 0 && one < firstPosition) {
            first = 1
            firstPosition = one
        }
        if (two >= 0 && two < firstPosition) {
            first = 2
            firstPosition = two
        }
        if (three >= 0 && three < firstPosition) {
            first = 3
            firstPosition = three
        }
        if (four >= 0 && four < firstPosition) {
            first = 4
            firstPosition = four
        }
        if (five >= 0 && five < firstPosition) {
            first = 5
            firstPosition = five
        }
        if (six >= 0 && six < firstPosition) {
            first = 6
            firstPosition = six
        }
        if (seven >= 0 && seven < firstPosition) {
            first = 7
            firstPosition = seven
        }
        if (eight >= 0 && eight < firstPosition) {
            first = 8
            firstPosition = eight
        }
        if (nine >= 0 && nine < firstPosition) {
            first = 9
        }

        if (onel >= 0 && onel < i.length - lastPosition) {
            last = 1
            lastPosition = i.length - onel - 1
        }
        if (twol >= 0 && twol < i.length - lastPosition) {
            last = 2
            lastPosition = i.length - twol - 1
        }
        if (threel >= 0 && threel < i.length - lastPosition) {
            last = 3
            lastPosition = i.length - threel - 1
        }
        if (fourl >= 0 && fourl < i.length - lastPosition) {
            last = 4
            lastPosition = i.length - fourl - 1
        }
        if (fivel >= 0 && fivel < i.length - lastPosition) {
            last = 5
            lastPosition = i.length - fivel - 1
        }
        if (sixl >= 0 && sixl < i.length - lastPosition) {
            last = 6
            lastPosition = i.length - sixl - 1
        }
        if (sevenl >= 0 && sevenl < i.length - lastPosition) {
            last = 7
            lastPosition = i.length - sevenl - 1
        }
        if (eightl >= 0 && eightl < i.length - lastPosition) {
            last = 8
            lastPosition = i.length - eightl - 1
        }
        if (ninel >= 0 && ninel < i.length - lastPosition) {
            last = 9
            lastPosition = i.length - ninel - 1
        }

        val num = first.toString() + last.toString()
        println("$first + $last = $num")
        sum += num.toInt()
    }
    println(sum)
}