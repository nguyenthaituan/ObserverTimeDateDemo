package vn.edu.ntu.observertimedatedemo;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import java.util.Calendar;

public class MyTimeDialog {
    Context context;
    Calendar calendar_time;
    OnMyTimeChangeListener onMyTimeChangeListener;

    public MyTimeDialog(Context context, Calendar calendar_time, OnMyTimeChangeListener onMyTimeChangeListener)
    {
        this.context = context;
        this.calendar_time = calendar_time;
        this.onMyTimeChangeListener = onMyTimeChangeListener;

    }
    public void showTimeDialog(){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDate, int minute) {
                calendar_time.set(calendar_time.HOUR_OF_DAY, hourOfDate);
                calendar_time.set(calendar_time.MINUTE, minute);
                if(onMyTimeChangeListener != null)
                    onMyTimeChangeListener.timeUpdate(calendar_time);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog
                (context,
                onTimeSetListener,
                calendar_time.get(calendar_time.HOUR_OF_DAY),
                calendar_time.get(calendar_time.MINUTE),
                true );
        timePickerDialog.show();
    }
    public static interface OnMyTimeChangeListener{
        public void timeUpdate(Calendar newTime);
    }
}
