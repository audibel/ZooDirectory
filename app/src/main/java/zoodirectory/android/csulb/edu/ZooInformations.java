package zoodirectory.android.csulb.edu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by LouisAudibert on 02/03/2017.
 */

public class ZooInformations extends AppCompatActivity {

    Button callBtn;
    Intent callIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoo_informations);

        callBtn = (Button) findViewById(R.id.button_call);
        callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:888-8888"));

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(callIntent);
            }
        });
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
                Intent intentInfo = new Intent(ZooInformations.this, ZooInformations.class);
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
