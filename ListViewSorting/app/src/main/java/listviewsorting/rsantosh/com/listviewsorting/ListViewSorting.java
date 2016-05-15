package listviewsorting.rsantosh.com.listviewsorting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListViewSorting extends AppCompatActivity implements View.OnClickListener {


    //Declaration of variables.
    public ArrayList<String> li;
    ListView Months;
    public ArrayAdapter<String> adp;

    Button descending;
    Button ascending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_sorting);

        //Initialisation of variables.
        Months= (ListView) findViewById(R.id.months);
        li = new ArrayList<String>();
        li=getMonths();

        ascending = (Button)findViewById(R.id.ascending);
        ascending.setOnClickListener(this);

        descending = (Button)findViewById(R.id.descending);
        descending.setOnClickListener(this);

        //Initialisation of adapters.
        ArrayAdapter<String> adp = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_dropdown_item_1line,li);

        adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        //Setting the adapter to the variables.
        Months.setAdapter(adp);

    }


    //Initialisation of values to array.
    private ArrayList<String> getMonths() {

        li.add("January");
        li.add("Febraury");
        li.add("March");
        li.add("April");
        li.add("June");
        li.add("July");
        li.add("August");
        li.add("September");
        li.add("November");
        li.add("December");

        return li;
    }


    @Override
    public void onClick(View view) {

        //Switch case for the command button.
        switch (view.getId()){

            //Case for ascending order.
            case (R.id.ascending):

                Toast.makeText(this, "Ascending order" ,Toast.LENGTH_LONG).show();
                Collections.sort(li, new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        String Month1 = s1;
                        String Month2 = s2;
                        return Month1.compareToIgnoreCase(Month2);
                    }
                });

                //This code is to update the array list.
                ArrayAdapter<String> adp = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_dropdown_item_1line,li);
                adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                Months.setAdapter(adp);

                break;

            //Case for descending order.
            case (R.id.descending):
                Toast.makeText(this, "Descending Order" ,Toast.LENGTH_LONG).show();

               Collections.sort(li, new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        String Month1 = s1;
                        String Month2 = s2;
                        return Month2.compareToIgnoreCase(Month1);
                    }
                });

                //This code is to update the array list.
                adp = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_dropdown_item_1line,li);
                adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                Months.setAdapter(adp);

                break;
        }

    }
}
