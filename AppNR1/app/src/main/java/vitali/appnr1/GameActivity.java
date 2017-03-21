package vitali.appnr1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    Galgelogik gamelogic = new Galgelogik();

    private ImageView galgeStatusDiagram;
    private Button btPlay;
    private TextView txInfo, txWord;
    private EditText txLetter;

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

    }

    @Override
    public void onClick(View v) {
        if(v == btPlay){
            String inputLetter = txLetter.getText().toString();
            if(inputLetter.length() != 1){
                txLetter.setError("One character allowed!");
                // Make a visual warning to the user.
                Toast.makeText(this, "Please write ONE letter at a time!", Toast.LENGTH_LONG).show();
                return;
            }
            txLetter.setError(null);
            gamelogic.gætBogstav(inputLetter);
            txLetter.setText("");
            updateScreen();
        }
    }

    private void updateScreen() {

    }
}
