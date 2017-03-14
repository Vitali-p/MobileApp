package vitali.appnr1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Implementing on click listener, for interactive app functionality.
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Declare global variables, to remember through the methodes. A "field" global variable.
    Button nr1 = null, nr2 = null, nr3 = null, OK = null, Inst = null, Sett = null, OKurl = null;
    WebView webView;

    //Initiation of User Interface of the app.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initiate the layout doby of XML file.
        setContentView(R.layout.activity_main);

        //Find all buttons by ID, and get them. Putting objects into the variables.
        nr1 = (Button) findViewById(R.id.button1);
        nr2 = (Button) findViewById(R.id.button2);
        nr3 = (Button) findViewById(R.id.button3);
        OK = (Button) findViewById(R.id.buttonOK);
        Inst = (Button) findViewById(R.id.buttonInstructions);
        Sett = (Button) findViewById(R.id.buttonSettings);
        OKurl = (Button) findViewById(R.id.buttonURLok);

        //Set a listener to each buttons, for in this method.
        nr1.setOnClickListener(this);
        nr2.setOnClickListener(this);
        nr3.setOnClickListener(this);
        OK.setOnClickListener(this);
        Inst.setOnClickListener(this);
        Sett.setOnClickListener(this);
        OKurl.setOnClickListener(this);

        //Web-view initiation.
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("http://javabog.dk");
/*
        //Set webview page same size.
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        //Load a default site.
        try{
            //Load webpage page.
            webView.loadUrl("http://javabog.dk");
        } catch (Exception e){
            e.printStackTrace();
        }
*/
    }

    @Override
    public void onClick(View v) {
        //Get elements by ID, and use by the even. Write to a textfied by ID.
        TextView printToTextView = (TextView) findViewById(R.id.textToScreen);

        //Read the input text in the text editor. And the URL text editor.
        String persName = ((EditText) findViewById(R.id.editTextName)).getText().toString();
        String URLName = ((EditText) findViewById(R.id.editTextURL)).getText().toString();

        //Write out to terminal, the clicked name of the button.
        System.out.println("A button " + ((Button)v).getText().toString() + " has been clicked..\n");
        //Or the same can be done by writing to the intern android log.
        Log.d("Tag: Click", "Message log printed...");

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
                if(persName.equals(null) || persName.equals("")) {
                    printToTextView.setText("Please write your name!");
                }
                else {
                    printToTextView.setText("Welcome " + persName +"!");
                }
            }
            case R.id.buttonInstructions: {
                //Functionality of button Instructions
                printToTextView.setText("You have entered; Instructions");
                break;
            }
            case R.id.buttonSettings: {
                //Functionality of button Settings
                printToTextView.setText("You have entered; Settings");
                break;
            }
            case R.id.buttonURLok: {
                //Functionality of button OK for URL
                if(URLName.equals(null) || URLName.equals("")) {
                    printToTextView.setText("Please enter a URL address!");
                }
                else {
                    if(URLName.contains("http://")){
                        webView.loadUrl(URLName);  //Load a site without URL root.
                    } else {
                        webView.loadUrl("http://"+URLName);  //Load a site with URL root.
                    }
                }
            }
            default:
                //Do nothing.
                break;
        }

/*
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
            if(persName.equals(null) || persName.equals("")) {
                printToTextView.setText("Please write your name!");
            }
            else {
                printToTextView.setText("Welcome " + persName);
            }
        }
        else if (v == Inst) {
            //Functionality of button Instructions
            printToTextView.setText("You have entered; Instructions");
        }
        else if (v == Sett) {
            //Functionality of button Settings
            printToTextView.setText("You have entered; Settings");
        }
        else if (v == OKurl) {
            //Functionality of button OK for URL
           if(URLName.equals(null) || URLName.equals("")) {
                printToTextView.setText("Please enter a URL address!");
            }
            else {
                if(URLName.contains("http://")){
                    webView.loadUrl(URLName);  //Load a site without URL root.
                } else {
                    webView.loadUrl("http://"+URLName);  //Load a site with URL root.
                }
            }
        }
        */

        intentsFunctions();
    }

    public void intentsFunctions (){
        // Write and use 3 different intents.
        // The Implicitte intents used in a extern app.

        // The Eksplicitte intents used in current app.
    }

}
