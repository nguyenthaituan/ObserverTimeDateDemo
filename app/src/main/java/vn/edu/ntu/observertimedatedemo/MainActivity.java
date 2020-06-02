package vn.edu.ntu.observertimedatedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements MyDateDialog.OnMyDateChangeListener, MyTimeDialog.OnMyTimeChangeListener{
    EditText dateCongTac, timeCongTac;
    ImageView imvCongtac, imvTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        setViews();
    }
    private void addViews () {
        dateCongTac = findViewById(R.id.dateCongTac);
        dateCongTac.setEnabled(false);
        imvCongtac = findViewById(R.id.date);
        timeCongTac = findViewById(R.id.timeCongTac);
        timeCongTac.setEnabled(false);
        imvTime = findViewById(R.id.imvTime);
    }
    private void setViews () {
        imvCongtac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDateDialog myDateDialog = new MyDateDialog(MainActivity.this, Calendar.getInstance(), MainActivity.this);
                myDateDialog.showDateDialog();
            }
        });
        imvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                MyTimeDialog myTimeDialog = new MyTimeDialog(MainActivity.this, Calendar.getInstance(), MainActivity.this);
                myTimeDialog.showTimeDialog();
            }
        });
    }

    @Override
    public void dateUpdate(Calendar newDate) {
        StringBuilder stringBuilder  = new StringBuilder();
        stringBuilder.append(newDate.get(newDate.DAY_OF_MONTH))
                .append("/")
                .append(newDate.get(newDate.MONTH) + 1)
                .append("/")
                .append(newDate.get(newDate.YEAR));
        dateCongTac.setText(stringBuilder.toString());
    }
    public void timeUpdate(Calendar newTime)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(newTime.get(newTime.HOUR_OF_DAY))
                .append("h")
                .append(newTime.get(newTime.MINUTE))
                .append("p");
        timeCongTac.setText(stringBuilder.toString());
    }
}
