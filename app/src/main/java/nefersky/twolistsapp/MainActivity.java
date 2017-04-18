package nefersky.twolistsapp;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private String[] mMonthArray = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль",
            "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    private String[] mDayOfWeekArray = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница",
            "Суббота", "Воскресенье"};

    private ArrayAdapter<String> mMonthAdapter, mDayOfWeekAdapter;

    private String mMonth, mDayOfWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        mMonthAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mMonthArray);
        mDayOfWeekAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDayOfWeekArray);

        setListAdapter(mMonthAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if(getListAdapter() == mMonthAdapter) {
            mMonth = l.getItemAtPosition(position).toString();
            setListAdapter(mDayOfWeekAdapter);
            mDayOfWeekAdapter.notifyDataSetChanged();
        } else {
            mDayOfWeek = l.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(), mMonth + " " + mDayOfWeek, Toast.LENGTH_SHORT).show();
            setListAdapter(mMonthAdapter);
            mMonthAdapter.notifyDataSetChanged();
        }
    }
}
