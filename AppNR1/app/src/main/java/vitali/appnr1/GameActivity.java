package vitali.appnr1;


import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    Galgelogik gamelogic = new Galgelogik();

    private ImageView galgeStatusDiagram;
    private Button btPlay;
    private TextView txInfo, txWord;
    public EditText txLetter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Load the game status diagram.
        galgeStatusDiagram = (ImageView) findViewById(R.id.imageViewGalge);
        galgeStatusDiagram.setImageResource(R.drawable.galge);

        // Get id's
        btPlay = (Button) findViewById(R.id.buttonPlay);
        txLetter = (EditText) findViewById(R.id.editTextLetter);
        txWord = (TextView) findViewById(R.id.textViewGuessWord);
        txInfo = (TextView) findViewById(R.id.textViewTypeded);


        // Create listener
        btPlay.setOnClickListener(this);

        txLetter.setFocusableInTouchMode(true);
        txLetter.requestFocus();
        txLetter.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                System.out.println("A key had been pressed");
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    if(keyCode == KeyEvent.KEYCODE_ENTER){

                        System.out.println("ENTER");
                        setLetter();

                        return true;
                    }
                }
                return false;
            }
        });


    }

    @Override
    public void onClick(View v) {
        if(v == btPlay){
            setLetter ();
        }
    }

    private  void setLetter (){
        String inputLetter = txLetter.getText().toString();
        if(inputLetter.length() != 1){
            txLetter.setError("One character allowed!");
            // Make a visual warning to the user.
            Toast.makeText(this, "Please write ONE letter at a time!", Toast.LENGTH_SHORT).show();
            return;
        }
        txLetter.setError(null);
        gamelogic.gætBogstav(inputLetter);
        txLetter.setText("");
        updateScreen();
    }
    private void updateScreen() {
        int nrAttempts = 7 - gamelogic.getAntalForkerteBogstaver();

        // Draw the galge.
        if(nrAttempts == 0) {
            galgeStatusDiagram.setImageResource(R.drawable.forkert6);
        }
        if(nrAttempts == 1) {
            galgeStatusDiagram.setImageResource(R.drawable.forkert5);
        }
        if(nrAttempts == 2) {
            galgeStatusDiagram.setImageResource(R.drawable.forkert4);
        }
        if(nrAttempts == 3) {
            galgeStatusDiagram.setImageResource(R.drawable.forkert3);
        }
        if(nrAttempts == 4) {
            galgeStatusDiagram.setImageResource(R.drawable.forkert2);
        }
        if(nrAttempts == 5) {
            galgeStatusDiagram.setImageResource(R.drawable.forkert1);
        }
        if(nrAttempts == 6) {
            galgeStatusDiagram.setImageResource(R.drawable.galge);
        }

        // Function: setText(): Destroys the buffer content by filling the text to be set.
        // Function: append(): Adds a text to a buffer and then prints the result.
        txWord.setText(gamelogic.getSynligtOrd());
        txInfo.setText("Used letters: " + gamelogic.getBrugteBogstaver() + "\nYou have " + nrAttempts + " attempts left.");

        if(gamelogic.erSpilletVundet()){
            txInfo.append("\nCongrutulation \n!! You WON !!");
        }
        if(gamelogic.erSpilletTabt()){
            txWord.setText("GAME OVER");
            txInfo.setText("The right word was: " + gamelogic.getOrdet());
        }

    }

}
