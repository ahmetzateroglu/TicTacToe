package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout

class TwoPlayer : AppCompatActivity() {


    private lateinit var playerOneLayout: LinearLayout
    private lateinit var playerTwoLayout: LinearLayout
    private lateinit var image1: ImageView
    private lateinit var image2: ImageView
    private lateinit var image3: ImageView
    private lateinit var image4: ImageView
    private lateinit var image5: ImageView
    private lateinit var image6: ImageView
    private lateinit var image7: ImageView
    private lateinit var image8: ImageView
    private lateinit var image9: ImageView


    private val combinationList: ArrayList<IntArray> = ArrayList()
    private var boxPositions = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    private var playerTurn = 1
    private var totalSelectedBoxes = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_player)

        playerOneLayout = findViewById(R.id.playerOneLayout)
        playerTwoLayout = findViewById(R.id.playerTwoLayout)

        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        image3 = findViewById(R.id.image3)
        image4 = findViewById(R.id.image4)
        image5 = findViewById(R.id.image5)
        image6 = findViewById(R.id.image6)
        image7 = findViewById(R.id.image7)
        image8 = findViewById(R.id.image8)
        image9 = findViewById(R.id.image9)

        combinationList.add(intArrayOf(0, 1, 2))
        combinationList.add(intArrayOf(3, 4, 5))
        combinationList.add(intArrayOf(6, 7, 8))
        combinationList.add(intArrayOf(0, 3, 6))
        combinationList.add(intArrayOf(1, 4, 7))
        combinationList.add(intArrayOf(2, 5, 8))
        combinationList.add(intArrayOf(2, 4, 6))
        combinationList.add(intArrayOf(0, 4, 8))


        image1.setOnClickListener {

            if (isBoxSelectable(0)){
                performAction(image1, 0)
            }
        }
        image2.setOnClickListener {

            if (isBoxSelectable(1)){
                performAction(image2, 1)
            }
        }
        image3.setOnClickListener {

            if (isBoxSelectable(2)){
                performAction(image3, 2)
            }
        }
        image4.setOnClickListener {

            if (isBoxSelectable(3)){
                performAction(image4, 3)
            }
        }
        image5.setOnClickListener {

            if (isBoxSelectable(4)){
                performAction(image5, 4)
            }
        }
        image6.setOnClickListener {

            if (isBoxSelectable(5)){
                performAction(image6, 5)
            }
        }
        image7.setOnClickListener {

            if (isBoxSelectable(6)){
                performAction(image7, 6)
            }
        }
        image8.setOnClickListener {

            if (isBoxSelectable(7)){
                performAction(image8, 7)
            }
        }
        image9.setOnClickListener {

            if (isBoxSelectable(8)){
                performAction(image9, 8)
            }
        }
    }

    private fun performAction(imageView: ImageView, selectedBoxPosition : Int){

        boxPositions[selectedBoxPosition] = playerTurn

        if (playerTurn == 1){
            imageView.setImageResource(R.drawable.cross)

            if (checkPlayerWin()){

                val winDialog = WinDialog(this@TwoPlayer, "Birinci Oyuncu Kazandı.", this@TwoPlayer)
                winDialog.setCancelable(false)
                winDialog.show()
            }
            else if (totalSelectedBoxes == 9){

                val winDialog = WinDialog(this@TwoPlayer, "Berabere!", this@TwoPlayer)
                winDialog.setCancelable(false)
                winDialog.show()
            }
            else{

                changePlayerTurn(2)
                totalSelectedBoxes++
            }
        }
        else{

            imageView.setImageResource(R.drawable.circle)

            if (checkPlayerWin()){

                 val winDialog = WinDialog(this@TwoPlayer, "İkinci Oyuncu Kazandı.", this@TwoPlayer)
                 winDialog.setCancelable(false)
                 winDialog.show()
            }
            else if (totalSelectedBoxes == 9){

                val winDialog = WinDialog(this@TwoPlayer, "Berabere!", this@TwoPlayer)
                winDialog.setCancelable(false)
                winDialog.show()
            }
            else{

                changePlayerTurn(1)
                totalSelectedBoxes++
            }

        }

    }

    private fun changePlayerTurn(currentPlayerTurn : Int){

        playerTurn = currentPlayerTurn

        if (playerTurn == 1){

            playerOneLayout.setBackgroundResource(R.drawable.round_back_dark_blue_stroke) // 20 radius ama beyaz stroke var
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_dark_blue_20) // 20 radius
        }
        else{

            playerTwoLayout.setBackgroundResource(R.drawable.round_back_dark_blue_stroke)
            playerOneLayout.setBackgroundResource(R.drawable.round_back_dark_blue_20)

        }
    }


    private fun checkPlayerWin(): Boolean {
        var response = false

        for (i in combinationList.indices) {
            val combination = combinationList[i]

            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn && boxPositions[combination[2]] == playerTurn) {
                response = true
            }
        }

        return response
    }

    private fun isBoxSelectable(boxPosition: Int): Boolean {
        var response = false

        if (boxPositions[boxPosition] == 0) {
            response = true
        }
        return response
    }

     fun restartMatch(){

        boxPositions = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

        playerTurn = 1

        totalSelectedBoxes = 1

        image1.setImageResource(R.drawable.trasnparent)
        image2.setImageResource(R.drawable.trasnparent)
        image3.setImageResource(R.drawable.trasnparent)
        image4.setImageResource(R.drawable.trasnparent)
        image5.setImageResource(R.drawable.trasnparent)
        image6.setImageResource(R.drawable.trasnparent)
        image7.setImageResource(R.drawable.trasnparent)
        image8.setImageResource(R.drawable.trasnparent)
        image9.setImageResource(R.drawable.trasnparent)

    }



}