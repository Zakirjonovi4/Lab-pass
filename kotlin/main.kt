import java.util.Scanner

fun main(){
    val scan = Scanner(System.`in`)
    var complete:Int// Полное совпадение
    var partial:Int// Частичное совпадение
    var attempts:Int = 0 // Попытки
    var coincidences:Int = 0 //Совпадения


    var randomNum = (1..9).random()
    println("Num ->" + randomNum)
    var randomX:Int = (1..9).random()
    var randomY:Int = (1..9).random()
    var randomZ:Int = (1..9).random()
    var x:Int = 1
    var y:Int = randomNum
    var numberString:String = "" + randomNum
    println("Длина на старте -> " + numberString.length)
    while (numberString.length < 4) {

        var x = numberString.length

        if ((randomX != y) && (randomNum != randomX) && (randomX != randomY) && (randomX != randomZ)) numberString += randomX

        if (numberString.length != x) randomNum = randomX

        randomX = (1..9).random()
        randomY = (1..9).random()
        randomZ = (1..9).random()

    }
    println(numberString)

    println("Попробуйте разгадать четырехзначное число")
//    println("Введите первую попытку: ")
    var numberUser:Int = 0
    var numberUserStr:String
    //println(randomNum)
    while (numberUser != randomNum){
        complete = 0
        partial = 0
        println("Введите предполагаемое число: ")
        numberUser = scan.nextLine().trim().toInt() // Считали первое число
        numberUserStr = numberUser.toString()
        if (numberUser <= 999) return // Пока числа только от 1000 до 9999, позже сделать от 0000

       /* Проверяем полные совпадения, с неполными еще есть проблемы*/

        if (numberUserStr[0] == numberString[0]) complete++
            else if((numberUserStr[0] == numberString[1]) || (numberUserStr[0] == numberString[2]) || (numberUserStr[0] == numberString[3])) partial++
        if (numberUserStr[1] == numberString[1]) complete++
            else if((numberUserStr[1] == numberString[0]) || (numberUserStr[1] == numberString[2]) || (numberUserStr[1] == numberString[3])) partial++
        if (numberUserStr[2] == numberString[2]) complete++
            else if((numberUserStr[2] == numberString[0]) || (numberUserStr[2] == numberString[1]) || (numberUserStr[2] == numberString[3])) partial++
        if (numberUserStr[3] == numberString[3]) complete++
            else if((numberUserStr[3] == numberString[0]) || (numberUserStr[3] == numberString[1]) || (numberUserStr[3] == numberString[2])) partial++

        if ((numberUserStr[0] == numberUserStr[1]) || (numberUserStr[0] == numberUserStr[2]) || (numberUserStr[0] == numberUserStr[3])) partial--
        if ((numberUserStr[1] == numberUserStr[0]) || (numberUserStr[1] == numberUserStr[2]) || (numberUserStr[1] == numberUserStr[3])) partial--
        if ((numberUserStr[2] == numberUserStr[0]) || (numberUserStr[2] == numberUserStr[1]) || (numberUserStr[2] == numberUserStr[3])) partial--
        if ((numberUserStr[3] == numberUserStr[0]) || (numberUserStr[3] == numberUserStr[1]) || (numberUserStr[3] == numberUserStr[2])) partial--
        if (partial < 0) partial = 0


        println("Колличество полных совпадений: $complete, частичных совпадений: $partial " +
                "\nP.S. Частичные совпадения пока могут отображаться неверно =(")
    }
    println("Вы выйграли! Правильно число $randomNum")
}