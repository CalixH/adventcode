fun main() {
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