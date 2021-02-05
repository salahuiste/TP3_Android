package escallierduront.gautier.dicoroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import java.lang.Math;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rollButton = (Button) findViewById(R.id.button);
        //Nous allons recupérer l'objet TextView pour qu'on puisse modifier le texte
        final TextView txtV=(TextView) findViewById(R.id.txtv);
        rollButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //On appel la fct getRandomNumber et après on fait la conversion en String
                int nb=getRandomNumber();
                txtV.setText(String.valueOf(nb));
                txtV.setTextSize(40);
            }
        });
    }
    private int getRandomNumber(){
        int min=1;
        int max=6;
        int range=max-min+1;
        //on retourne un nombre compirs entre 1 et 6
        return (int)(Math.random()*range+min);
    }
}
