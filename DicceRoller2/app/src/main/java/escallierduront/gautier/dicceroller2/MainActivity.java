package escallierduront.gautier.dicceroller2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.EditText;
import java.lang.Math;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rollButton = (Button) findViewById(R.id.button);
        //Nous allons recupérer l'objet TextView pour qu'on puisse modifier le texte
        final TextView txtV=(TextView) findViewById(R.id.txtv);
        final TextView txtV2=(TextView) findViewById(R.id.txtv2);
        //on récupere le edittext
        final EditText edit=(EditText) findViewById(R.id.editText);

        rollButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //le nombre entrant par l'utilisateur
                //si la chaine est vide on sort de la fonction== on fait rien
                if(edit.getText().toString()==""){
                    return;
                }
                int foo;
                try {
                    foo = Integer.parseInt(edit.getText().toString());
                }
                catch (NumberFormatException e)
                {
                    foo = 0;
                }
                if(foo<2 || foo>6) {
                    return;
                }
                int nb=0;
                int nb2=0;
                do {
                    nb=getRandomNumber();
                    nb2=getRandomNumber();
                }while((nb2+nb)!=foo);
                setTextInTextView(txtV,nb);
                setTextInTextView(txtV2,nb2);
                //On appel la fct getRandomNumber et après on fait la conversion en String
                /*int nb=getRandomNumber();
                int nb2=0;
                do {
                    nb2=getRandomNumber();
                }while(nb2==nb);
                setTextInTextView(txtV,nb);
                setTextInTextView(txtV2,nb2);*/
            }
        });
    }
    private void setTextInTextView(TextView v, int nb) {
        v.setText(String.valueOf(nb));
        v.setTextSize(40);
    }
    private int getRandomNumber(){
        int min=1;
        int max=6;
        int range=max-min+1;
        //on retourne un nombre compirs entre 1 et 6
        return (int)(Math.random()*range+min);
    }
}
