package sg.edu.rp.c346.id19040088.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView name;
    EditText nameInput;
    TextView number;
    EditText numInput;
    TextView pax;
    EditText paxInput;
    CheckBox smoke;
    DatePicker date;
    TimePicker time;
    Button reserve;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameDisplay);
        nameInput = findViewById(R.id.nameInput);
        number = findViewById(R.id.numDisplay);
        numInput = findViewById(R.id.numInput);
        pax = findViewById(R.id.paxDisplay);
        paxInput = findViewById(R.id.paxInput);
        smoke = findViewById(R.id.smokeBox);
        date = findViewById(R.id.datePicker);
        time = findViewById(R.id.timePicker);
        reserve = findViewById(R.id.reserveBtn);
        reset = findViewById(R.id.resetBtn);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                number.setText("");
                time.setCurrentHour(19);
                time.setCurrentMinute(30);
                date.updateDate(2020,5,1);
                smoke.setChecked(false);

            }
        });

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dateDisplay = "" + date.getDayOfMonth() + "/" + date.getMonth()+1 + "/" + date.getYear();
                String timeDisplay = "" + time.getCurrentHour() + ":" + time.getCurrentMinute();
                if(smoke.isChecked()) {
                    Toast.makeText(MainActivity.this, nameInput + ", you have booked a smoking room for " + paxInput + "people using this number " + numInput + "."
                            + "Date and time of reservation is " + dateDisplay + "," + timeDisplay ,Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Toast.makeText(MainActivity.this, nameInput + ", you have booked a non-smoking room for " + paxInput + "people using this number " + numInput + "."
                            + "Date and time of reservation is " + dateDisplay + "," + timeDisplay ,Toast.LENGTH_SHORT).show();
                    return;
                }


            }
        });
    }
    }

