fun main() {
    // 고칠부분
    //1. isEmpty 칸이 비었는지 검사
    //2. isRange 입력의 범위 검사




    var cnt = 1 // 몇 번째 판인지
    var player = "O"    // 플레이어 1: O, 플레이어 2: X (말을 놓을 때 쉽게 놓기 위해 변수 선언)
    var playerInt = 1   // 플레이어
    var placeArr: Array<Array<String>> = arrayOf(arrayOf(" "," "," "), // 말을 놓는 판
        arrayOf(" "," "," "),
        arrayOf(" "," "," "))

    while(true) {
        println("$cnt 번째 턴")
        printBoard(placeArr)    // 판을 그리는 메서드
        print("Player $playerInt 입력(줄,칸) : ")
        val input: String? = readLine() // 입력
        val inputArray: List<String>? = input?.split(",")     // 입력 arr로 배치

        placeArr[inputArray!!.get(1)!!.toInt()-1][inputArray!!.get(0)!!.toInt()-1] = player // 입력한 위치에 말을 놓은

        cnt++

        if (whoWin(placeArr)==true) {   // 승리 판정 메서드
            println("Player $playerInt 승리!")
            break
        }

        if (cnt%2==1) {     // 한 경기가 끝나면 플레이어 바꿈
            player = "O"
            playerInt = 1
        } else {
            player = "X"
            playerInt = 2
        }
    }
}

fun printBoard(array: Array<Array<String>>){
    for(i in 0..2){
        print("$i ")
        for(j in 0..2){
            print(array[i][j])
            if (j!=2)
                print("|")
        }
        println()
        if (i!=2)
            println("  -+-+-")
    }
}

fun whoWin(array: Array<Array<String>>):Boolean {
    var win = false // false: lose, true: win

    for(i in 0 .. 2){
        // 열 일치
        if(array[0][i]==array[1][i]&&array[0][i]==array[2][i]&&array[0][i]!=" ")
            return true
        // 행 일치
        else if(array[i][0]==array[i][1]&&array[i][0]==array[i][2]&&array[i][0]!=" ")
            return true
        // 대각선 일치
    }
    if(array[0][0]==array[1][1]&&array[0][0]==array[2][2]&&array[0][0]!=" ")
        return true
    if(array[2][0]==array[1][1]&&array[2][0]==array[0][2]&&array[0][2]!=" ")
        return true

    return false
}