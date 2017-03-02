package zoodirectory.android.csulb.edu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_details);

        AnimalModel selectedAnimal = (AnimalModel) getIntent().getSerializableExtra("animal");
        TextView    description = (TextView)findViewById(R.id.description);
        ImageView   image = (ImageView)findViewById(R.id.image);

        description.setText(selectedAnimal.getDescription());
        image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), selectedAnimal.getImage()));
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
                Intent intentInfo = new Intent(AnimalDetails.this, ZooInformations.class);
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
