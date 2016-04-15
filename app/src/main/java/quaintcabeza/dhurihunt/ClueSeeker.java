package quaintcabeza.dhurihunt;

import android.app.Activity;
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
import android.widget.ImageView;


public class ClueSeeker extends Activity {

    private static final int k_numClues = 9;

    private Clue[] d_clues = new Clue[9];
    private int d_currentIndex;

    private EditText d_passPhraseView;
    private ImageView d_clueImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clue_seeker);

        d_passPhraseView = (EditText) findViewById(R.id.pass_phrase_text);
        d_clueImage = (ImageView) findViewById(R.id.clue_image);

        if (savedInstanceState != null) {
            restoreState(savedInstanceState);
        }
        else {
            initializeState();
        }
        addPassPhraseListener();
        refreshView();
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

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putParcelableArray("d_clues", d_clues);
        savedInstanceState.putInt("d_currentIndex", d_currentIndex);
        super.onSaveInstanceState(savedInstanceState);

    }

    public void onClueClick(View view) {
        Intent intent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=AEANas_Pjgo"));
        startActivity(intent);
    }

    public void onLeftClick(View view) {
        d_currentIndex = (d_currentIndex == 0) ? k_numClues : d_currentIndex;
        --d_currentIndex;
        refreshView();
    }

    public void onRightClick(View view) {
        d_currentIndex = (d_currentIndex + 1) % k_numClues;
        refreshView();
    }

    public void refreshView() {
        Clue clue = d_clues[d_currentIndex];
        d_clueImage.setImageResource(clue.d_imageUrl);
    }

    private void initializeState() {
        d_currentIndex = 0;

        d_clues[0] = new Clue();
        d_clues[1] = new Clue();
        d_clues[2] = new Clue();
        d_clues[3] = new Clue();
        d_clues[4] = new Clue();
        d_clues[5] = new Clue();
        d_clues[6] = new Clue();
        d_clues[7] = new Clue();
        d_clues[8] = new Clue();

        d_clues[0].d_imageUrl = R.drawable.clue;
        d_clues[1].d_imageUrl = R.drawable.stocking;
        d_clues[2].d_imageUrl = R.drawable.apron;
        d_clues[3].d_imageUrl = R.drawable.tea;
        d_clues[4].d_imageUrl = R.drawable.zingermans;
        d_clues[5].d_imageUrl = R.drawable.purse;
        d_clues[6].d_imageUrl = R.drawable.watch;
        d_clues[7].d_imageUrl = R.drawable.woollen;
        d_clues[8].d_imageUrl = R.drawable.lair;

        d_clues[0].d_videoUrl = "";
        d_clues[1].d_videoUrl = "";
        d_clues[2].d_videoUrl = "";
        d_clues[3].d_videoUrl = "";
        d_clues[4].d_videoUrl = "";
        d_clues[5].d_videoUrl = "";
        d_clues[6].d_videoUrl = "";
        d_clues[7].d_videoUrl = "";
        d_clues[8].d_videoUrl = "";

        d_clues[0].d_passPhrase = "sindhuri maata ki jai ho";
        d_clues[1].d_passPhrase = "lambu ne tujhe lamba kar diya";
        d_clues[2].d_passPhrase = "ab main tujhe pehnunga";
        d_clues[3].d_passPhrase = "kkkkkiran";
        d_clues[4].d_passPhrase = "terrraaa surooooooor";
        d_clues[5].d_passPhrase = "kya mast chal hai zaalim";
        d_clues[6].d_passPhrase = "khushbooo";
        d_clues[7].d_passPhrase = "abcdefghijklmnopqrstuvwxyz";
        d_clues[8].d_passPhrase =
          "tadapti raaton mein bhadakti jismon ki dhadakti aag ko bujhaane ka";
    }

    private void restoreState(Bundle savedInstanceState) {
        d_clues = (Clue[]) savedInstanceState.getParcelableArray("d_clues");
        d_currentIndex = savedInstanceState.getInt("d_currentIndex");
    }

    private void addPassPhraseListener() {
        d_passPhraseView.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (d_passPhraseView.getText().toString().equals("ffff")) {
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
            }
        });
    }
}
