package lu.cct.profilewithbackend;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ecborera on 4/15/15.
 */
public class ProfileAdapter extends BaseAdapter {
    private ArrayList<HashMap<String, String>> list;

    public ProfileAdapter(ArrayList<HashMap<String, String>> orig_list) {
        list = new ArrayList<>();
        list.addAll(orig_list);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public HashMap<String, String> getItem(int position) {
        return list.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /* TODO */
        return null;
    }
}
