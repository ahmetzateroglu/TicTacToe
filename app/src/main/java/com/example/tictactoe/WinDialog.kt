package com.example.tictactoe

import android.content.Context
import android.os.Bundle
import android.app.Dialog
import android.widget.Button
import android.widget.TextView
import androidx.annotation.NonNull

class WinDialog(@NonNull context: Context, private val message: String, private val twoPlayer: TwoPlayer) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.win_dialog_layout)

        val messageTxt = findViewById<TextView>(R.id.messageTxt)
        val startAgainBtn = findViewById<Button>(R.id.startAgainBtn)


        messageTxt.setText(message)

        startAgainBtn.setOnClickListener {

            twoPlayer.restartMatch()
            dismiss()

        }
    }
}


/*
public class Windialog extends Dialog {

    private final String message;
    private final MainActivity mainActivity;

    public WinDialog(@NonNull Context context, String message, MainActivity mainactivity){
        super(context);
        this.message = message;
        this.mainactivity= mainactivity
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.win_dialog_layout);

        twoPlayer.restartMatch();
        dismiss();
    }}*/
