package vitali.appnr1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Declare variables, to remember through the methodes.
    Button nr1 = null, nr2 = null, nr3 = null, OK = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find all buttons by ID, and get them.
        Button nr1 = (Button) findViewById(R.id.button1);
        Button nr2 = (Button) findViewById(R.id.button2);
        Button nr3 = (Button) findViewById(R.id.button3);
        Button OK = (Button) findViewById(R.id.buttonOK);

        //Set a listener to each buttons, for in this method.
        nr1.setOnClickListener(this);
        nr2.setOnClickListener(this);
        nr3.setOnClickListener(this);
        OK.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Get elements by ID, and use by the even. Write to a textfied by ID.
        TextView printToTextView = (TextView) findViewById(R.id.textToScreen);
        EditText textName = (EditText) findViewById(R.id.editTextName);
        String persName = textName.toString();

        //Write out to terminal. The clicked name of the button.
        System.out.println("A button " + ((Button)v).getText().toString() + " has been clicked..");

        //Get elements by ID, and use them on a even.
        switch (v.getId()) {
            case R.id.button1: {
                //Functionality of button Nr.1
                printToTextView.setText("You have pressed on button nr: 1");
                break;
            }
            case R.id.button2: {
                //Functionality of button Nr.2
                printToTextView.setText("You have pressed on button nr: 2");
                break;
            }
            case R.id.button3: {
                //Functionality of button Nr.3
                printToTextView.setText("You have pressed on button nr: 3");
                break;
            }
            case R.id.buttonOK: {
                //Functionality of button OK
                if(persName == null) {
                    printToTextView.setText("Please write toy name!");
                }
                else if (persName != null) {
                    printToTextView.setText("Welcome " + persName);
                }
            }
            default:
                //Do nothing.
                break;
        }

        //Another way to implemt on click, is by listeling for a button even.
        if (v == nr1) {
            //Functionality of button Nr.1
            printToTextView.setText("You have pressed on button nr: 1");
        }
        else if (v == nr2) {
            //Functionality of button Nr.2
            printToTextView.setText("You have pressed on button nr: 2");
        }
        else if (v == nr3) {
            //Functionality of button Nr.3
            printToTextView.setText("You have pressed on button nr: 3");
        }
        else if (v == OK) {
            //Functionality of button OK
            if(persName == null) {
                printToTextView.setText("Please write toy name!");
            }
            else if (persName != null) {
                printToTextView.setText("Welcome " + persName);
            }
        }

    }
}
