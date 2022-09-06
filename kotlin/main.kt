import java.util.Scanner

fun main(){
    val scan = Scanner(System.`in`)
    var complete:Int// Полное совпадение
    var partial:Int// Частичное совпадение
    var attempts = 0 // Попытки

    var randomNum = (1..9).random()
    var randomX:Int = (1..9).random()
    var randomY:Int = (1..9).random()
    var randomZ:Int = (1..9).random()
    val y:Int = randomNum
    var numberString:String = "" + randomNum

    while (numberString.length < 4) {
        val x = numberString.length
        if ((randomX != y) && (randomNum != randomX) && (randomX != randomY) && (randomX != randomZ)) numberString += randomX
        if (numberString.length != x) randomNum = randomX
        randomX = (1..9).random()
        randomY = (1..9).random()
        randomZ = (1..9).random()
    }

    println(numberString) //Это нужно закоментить чтоб разгадывать

    println("Попробуйте разгадать четырехзначное число")

    var numberUser = 0
    var numberUserStr:String

    while (numberUser != randomNum){
        complete = 0
        partial = 0
        println("Введите предполагаемое число: ")
        numberUser = scan.nextLine().trim().toInt() // Считали первое число
        numberUserStr = numberUser.toString()
        if (numberUser <= 999) return // Пока числа только от 1000 до 9999, позже сделать от 0000

       /* Проверяем полные совпадения*/
        if (numberUserStr[0] == numberString[0]) complete++
            else if((numberUserStr[0] == numberString[1]) || (numberUserStr[0] == numberString[2]) || (numberUserStr[0] == numberString[3])) partial++
        if (numberUserStr[1] == numberString[1]) complete++
            else if((numberUserStr[1] == numberString[0]) || (numberUserStr[1] == numberString[2]) || (numberUserStr[1] == numberString[3])) partial++
        if (numberUserStr[2] == numberString[2]) complete++
            else if((numberUserStr[2] == numberString[0]) || (numberUserStr[2] == numberString[1]) || (numberUserStr[2] == numberString[3])) partial++
        if (numberUserStr[3] == numberString[3]) complete++
            else if((numberUserStr[3] == numberString[0]) || (numberUserStr[3] == numberString[1]) || (numberUserStr[3] == numberString[2])) partial++

        /* Проверяем частичные совпадения*/
        if ((numberUserStr[0] == numberUserStr[1]) || (numberUserStr[0] == numberUserStr[2]) || (numberUserStr[0] == numberUserStr[3])) partial--
        if ((numberUserStr[1] == numberUserStr[0]) || (numberUserStr[1] == numberUserStr[2]) || (numberUserStr[1] == numberUserStr[3])) partial--
        if ((numberUserStr[2] == numberUserStr[0]) || (numberUserStr[2] == numberUserStr[1]) || (numberUserStr[2] == numberUserStr[3])) partial--
        if ((numberUserStr[3] == numberUserStr[0]) || (numberUserStr[3] == numberUserStr[1]) || (numberUserStr[3] == numberUserStr[2])) partial--
        if (partial < 0) partial = 0

        attempts++

        if (complete == 4) {
            println("Вы выйграли! Колличество ваших попыток: $attempts Правильно число $numberString")
            break
        }

        println("Колличество полных совпадений: $complete, частичных совпадений: $partial " +
                "\nКолличество попыток: $attempts")
    }
}