package com.nitjsr.urja1920.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.nitjsr.urja1920.R;

public class NotificationSettingsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Switch notifications, athletics, cricket, football, basketball, volleyball, hockey, chess, badminton, tt;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);
        overridePendingTransition(0, 0);

        notifications = findViewById(R.id.switch_notify);
        athletics = findViewById(R.id.switch_athletics);
        cricket = findViewById(R.id.switch_cricket);
        football = findViewById(R.id.switch_football);
        basketball = findViewById(R.id.switch_basketball);
        volleyball = findViewById(R.id.switch_volleyball);
        hockey = findViewById(R.id.switch_hockey);
        chess = findViewById(R.id.switch_chess);
        badminton = findViewById(R.id.switch_badminton);
        tt = findViewById(R.id.switch_tt);
        pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        editor = pref.edit();
        if(pref.getBoolean("Notify",true)){
            notifications.setChecked(true);
            enableSwitch();
        }
        else{
            disableSwitch();
        }
        if(pref.getBoolean("Athletics",true)){
            athletics.setChecked(true);
        }
        if(pref.getBoolean("Cricket",true)){
            cricket.setChecked(true);
        }
        if(pref.getBoolean("Football",true)){
            football.setChecked(true);
        }
        if(pref.getBoolean("Basketball",true)){
            basketball.setChecked(true);
        }
        if(pref.getBoolean("Volleyball",true)){
            volleyball.setChecked(true);
        }
        if(pref.getBoolean("Hockey",true)){
            hockey.setChecked(true);
        }
        if(pref.getBoolean("Chess",true)){
            chess.setChecked(true);
        }
        if(pref.getBoolean("Badminton",true)){
            badminton.setChecked(true);
        }
        if(pref.getBoolean("Table Tennis",true)){
            tt.setChecked(true);
        }
        notifications.setOnCheckedChangeListener(this);
        athletics.setOnCheckedChangeListener(this);
        cricket.setOnCheckedChangeListener(this);
        chess.setOnCheckedChangeListener(this);
        football.setOnCheckedChangeListener(this);
        volleyball.setOnCheckedChangeListener(this);
        basketball.setOnCheckedChangeListener(this);
        tt.setOnCheckedChangeListener(this);
        hockey.setOnCheckedChangeListener(this);
        badminton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //Toast.makeText(NotificationSettingsActivity.this,"noti:"+buttonView,Toast.LENGTH_SHORT).show();
        if(buttonView.getId() == R.id.switch_notify) {
            //Toast.makeText(NotificationSettingsActivity.this,"noti",Toast.LENGTH_SHORT).show();
            if(isChecked) {
                editor.putBoolean("Notify", true);
                enableSwitch();
            }
            else{
                editor.putBoolean("Notify",false);
                disableSwitch();
            }
        }
        if(buttonView.getId() == R.id.switch_athletics) {
            if(isChecked)
                editor.putBoolean("Athletics",true);
            else{
                editor.putBoolean("Athletics",false);
            }
        }
        if(buttonView.getId() == R.id.switch_cricket) {
            if(isChecked)
                editor.putBoolean("Cricket",true);
            else{
                editor.putBoolean("Cricket",false);
            }
        }
        if(buttonView.getId() == R.id.switch_football) {
            if(isChecked)
                editor.putBoolean("Football",true);
            else{
                editor.putBoolean("Football",false);
            }
        }
        if(buttonView.getId() == R.id.switch_volleyball) {
            if(isChecked)
                editor.putBoolean("Volleyball",true);
            else{
                editor.putBoolean("Volleyball",false);
            }
        }
        if(buttonView.getId() == R.id.switch_basketball) {
            if(isChecked)
                editor.putBoolean("Basketball",true);
            else{
                editor.putBoolean("Basketball",false);
            }
        }
        if(buttonView.getId() == R.id.switch_hockey) {
            if(isChecked)
                editor.putBoolean("Hockey",true);
            else{
                editor.putBoolean("Hockey",false);
            }
        }
        if(buttonView.getId() == R.id.switch_chess) {
            if(isChecked)
                editor.putBoolean("Chess",true);
            else{
                editor.putBoolean("Chess",false);
            }
        }
        if(buttonView.getId() == R.id.switch_badminton) {
            if(isChecked)
                editor.putBoolean("Badminton",true);
            else{
                editor.putBoolean("Badminton",false);
            }
        }
        if(buttonView.getId() == R.id.switch_tt) {
            if(isChecked)
                editor.putBoolean("Table Tennis",true);
            else{
                editor.putBoolean("Table Tennis",false);
            }
        }
        editor.apply();
    }

    private void disableSwitch() {
        athletics.setEnabled(false);
        cricket.setEnabled(false);
        football.setEnabled(false);
        volleyball.setEnabled(false);
        basketball.setEnabled(false);
        hockey.setEnabled(false);
        chess.setEnabled(false);
        badminton.setEnabled(false);
        tt.setEnabled(false);

        athletics.setChecked(false);
        cricket.setChecked(false);
        basketball.setChecked(false);
        volleyball.setChecked(false);
        tt.setChecked(false);
        hockey.setChecked(false);
        badminton.setChecked(false);
        chess.setChecked(false);
        football.setChecked(false);

        editor.putBoolean("Athletics", false);
        editor.putBoolean("Cricket", false);
        editor.putBoolean("Football", false);
        editor.putBoolean("Volleyball", false);
        editor.putBoolean("Basketball", false);
        editor.putBoolean("Table Tennis", false);
        editor.putBoolean("Badminton", false);
        editor.putBoolean("Hockey", false);
        editor.putBoolean("Chess", false);
        editor.apply();
    }

    private void enableSwitch() {
        athletics.setEnabled(true);
        cricket.setEnabled(true);
        football.setEnabled(true);
        volleyball.setEnabled(true);
        basketball.setEnabled(true);
        hockey.setEnabled(true);
        chess.setEnabled(true);
        badminton.setEnabled(true);
        tt.setEnabled(true);
    }
}
