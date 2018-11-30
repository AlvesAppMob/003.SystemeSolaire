package e.tamen.listplanets;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    ListView m_listView;
    ArrayList<planetItem> m_planets;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initialization();
    }

    private void Initialization()
    {
        final String[] planetList;

        m_planets = new ArrayList<planetItem>();
        m_listView = (ListView)findViewById(R.id.listView);
        //Loads planets list in XML
        planetList = getResources().getStringArray(R.array.planetNames);

        for(int i = 0 ; i < planetList.length ; i++)
        {
            planetItem newPlanet = new planetItem();
            newPlanet.SetName(planetList[i]);
            newPlanet.SetDistance(getResources().getStringArray(R.array.planetDistances)[i]);

            // load image
            try {
                // get input stream
                InputStream ims = getAssets().open(planetList[i].toLowerCase() + ".png");
                if(ims != null)
                {
                    // load image as Drawable
                    Bitmap bitmap = BitmapFactory.decodeStream(ims);
                    // set image to ImageView
                    newPlanet.SetImage(bitmap);
                }
            }
            catch(IOException ex) {
                return;
            }

            //IMAGE
            m_planets.add(newPlanet);
        }
        final PlanetAdapter adapter = new PlanetAdapter(this, R.layout.list_item, m_planets);
        final ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, m_planets);
        //m_listView.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                planetItem newPlanet = (planetItem)adapter.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), newPlanet.GetName(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
