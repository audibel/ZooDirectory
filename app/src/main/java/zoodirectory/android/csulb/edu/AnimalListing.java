package zoodirectory.android.csulb.edu;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AnimalListing extends AppCompatActivity {

    List<AnimalModel> animalList = new ArrayList<>();
    ListView    customListView;
    private static CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_listing);

        customListView = (ListView)findViewById(R.id.listView);

        initList();

        final AlertDialog dangerAnimalDialog = new AlertDialog.Builder(this)
                .setMessage("This animal is very scary. Are you sure you want to see its details ?")
                .setTitle("Are you sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent myIntent = new Intent(getApplicationContext(), AnimalDetails.class);
                        myIntent.putExtra("animal", animalList.get(animalList.size() - 1));
                        startActivity(myIntent);
                    }
                })
                .setNegativeButton("No, thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create();

        customAdapter = new CustomAdapter(animalList, getApplicationContext());

        customListView.setAdapter(customAdapter);

        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                if (position == animalList.size() - 1 )
                    dangerAnimalDialog.show();
                else {
                    Intent myIntent = new Intent(view.getContext(), AnimalDetails.class);
                    myIntent.putExtra("animal", animalList.get(position));
                    startActivity(myIntent);
                }
            }
        });
    }

    private void initList() {
        animalList.add(new AnimalModel("Fox", getResources().getString(R.string.foxDesc), R.drawable.fox));
        animalList.add(new AnimalModel("White Bear", getResources().getString(R.string.whitebearDesc), R.drawable.whitebear));
        animalList.add(new AnimalModel("Shark", getResources().getString(R.string.sharkDesc), R.drawable.shark));
        animalList.add(new AnimalModel("Rhino", getResources().getString(R.string.rhinoDesc), R.drawable.rhino));
        animalList.add(new AnimalModel("Tiger", getResources().getString(R.string.tigerDesc), R.drawable.tiger));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.zoo_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.informations:
                Intent intentInfo = new Intent(AnimalListing.this, ZooInformations.class);
                startActivity(intentInfo);
                break;
            case R.id.uninstall:
                Intent intentUninstall = new Intent(Intent.ACTION_DELETE);
                intentUninstall.setData(Uri.parse("package:" + this.getPackageName()));
                startActivity(intentUninstall);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
