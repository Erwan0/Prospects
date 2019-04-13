package com.ynov.guillemin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText_name;
    private EditText editText_pwd;
    private TextView error;
    private CheckBox boxsavelogin;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private final static String username_pref ="Username";
    private final static String pwd_pref ="Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On recupere le bouton du layout
        Button button = (Button) findViewById(R.id.empty);
        Button buttonlogin = (Button) findViewById(R.id.connection);

        //on attribue le onclicklistener au button
        button.setOnClickListener(clickEmptyListener);
        buttonlogin.setOnClickListener(clickLoginListener);
        editText_name = (EditText) findViewById(R.id.inputName);
        editText_pwd = (EditText) findViewById(R.id.inputPassword);
        error = (TextView) findViewById(R.id.error);
        boxsavelogin = (CheckBox) findViewById(R.id.remember);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        editText_name.setText(preferences.getString(username_pref, ""));
        editText_pwd.setText(preferences.getString(pwd_pref, ""));
    }
        //Create an implementation of OnClickListener
        private View.OnClickListener clickEmptyListener = new View.OnClickListener() {
            public void onClick(View v) {
                //action realisee lorsque le bouton est clique.
                editText_name.setText("");
                editText_pwd.setText("");
            }
        };

    private View.OnClickListener clickLoginListener = new View.OnClickListener() {
        public void onClick(View v) {
            if (editText_name.length() > 0){
                if (editText_pwd.length() > 8) {
                    Intent intent = new Intent(MainActivity.this, ListProspectActivity.class);
                    startActivity(intent);
                    if (boxsavelogin.isChecked()){
                        editor = preferences.edit();
                        editor.putString(username_pref, editText_name.getText().toString());
                        editor.putString(pwd_pref, editText_pwd.getText().toString());
                        editor.commit();
                }
                    else {
                        editor = preferences.edit();
                        editor.putString(username_pref, "");
                        editor.putString(pwd_pref, "");
                        editor.commit();
                    }
                }
                else {
                    error.setVisibility(View.VISIBLE);
                }
            }
            else {
                error.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    } // kill l'app

    @Override
    protected void onPause() {
        super.onPause();
    } // Passe en arrière-plan

    @Override
    protected void onPostResume() {
        super.onPostResume();
    } // Appelé lorsque la reprise de l'activité est terminée

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    } // Enregister les paramettre

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    } // Récupere les données de onSaveInstanceState
}

/*
Lorsque on lance-on arriver directement sur l'app. Quand on change l'orientation du téléphone
l'app s'adapte et change en même temps. Quand on ferme l'app se ferme. Et quand on met l'app en
arrière-plan et qu'on relance on peut reprendre exactement là ou on s'était arrêté.
 */
