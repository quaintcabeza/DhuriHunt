package quaintcabeza.dhurihunt;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ClueSeeker extends ActionBarActivity {

    private EditText d_passPhraseView;
    private Button d_leftButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("FOO", "onCreate");
        setContentView(R.layout.activity_clue_seeker);
        d_leftButton = (Button) findViewById(R.id.left_button);
        d_passPhraseView = (EditText) findViewById(R.id.pass_phrase_text);
        d_passPhraseView.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Log.e("FOO", s.toString());
                if (d_passPhraseView.getText().toString().equals("ffff")) {
                    d_leftButton.setEnabled(false);
                }
            }

            public void beforeTextChanged(
                    CharSequence s,
                    int start,
                    int count,
                    int after) {
            }

            public void onTextChanged(
                    CharSequence s,
                    int start,
                    int before,
                    int count) {
                Log.e("FOO", s.toString());
                if (s.toString() == "asdf") {
                    d_leftButton.setEnabled(false);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_clue_seeker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onLeftClick(View view) {
        Intent intent = new Intent(this, Playback.class);
        startActivity(intent);
    }

    public void onRightClick(View view) {
        Intent intent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=AEANas_Pjgo"));
        startActivity(intent);
    }
}
