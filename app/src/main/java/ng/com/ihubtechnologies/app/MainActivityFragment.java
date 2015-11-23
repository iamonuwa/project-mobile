package ng.com.ihubtechnologies.app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        String[] weekDays = {
                "MONDAYS",
                "TUESDAYS",
                "WEDNESDAYS",
                "THURSDAYS",
                "FRIDAYS"
        };
        List weeks = new ArrayList(Arrays.asList(weekDays));
        final ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), R.layout.list_item_days, R.id.list_item_days_textview,weeks);
        ListView listView = (ListView) rootView.findViewById(
                R.id.list_item_days);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemPosition = (String) arrayAdapter.getItem(position);
                Intent intent = new Intent(getActivity(), DetailsActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, itemPosition);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
