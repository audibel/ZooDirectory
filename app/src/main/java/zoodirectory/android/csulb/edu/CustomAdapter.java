package zoodirectory.android.csulb.edu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LouisAudibert on 23/02/2017.
 */


public class CustomAdapter extends BaseAdapter {

    List<AnimalModel> animalList;
    Context context;


    public CustomAdapter(List<AnimalModel> list, Context context) {
        this.animalList = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.animalList.size();
    }

    @Override
    public AnimalModel getItem(int i) {
        return animalList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View newView = view;

        if (newView == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            newView = vi.inflate(R.layout.custom_row, viewGroup, false);
        }

        AnimalModel animal = getItem(i);

        if (animal != null) {
            ImageView   img = (ImageView) newView.findViewById(R.id.image);
            TextView    title = (TextView) newView.findViewById(R.id.title);
            String      animalName;

            animalName = animal.getName();
            img.setImageResource(animal.getImage());
            title.setText(animalName);
        }
        return newView;
    }
}
