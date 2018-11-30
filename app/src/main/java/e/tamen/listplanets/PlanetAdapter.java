package e.tamen.listplanets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import e.tamen.listplanets.R;


public class PlanetAdapter extends ArrayAdapter<planetItem>
{
    static class ViewHolder
    {
        TextView name;
        TextView distance;
        ImageView image;
    }

    ArrayList<planetItem> m_planets;
    Context m_context;
    Resources m_resources;
    int m_viewRes;


    public PlanetAdapter(Context context, int textViewResourceId, ArrayList<planetItem> planets)
    {
        super(context, textViewResourceId, planets);
        m_planets = planets;
        m_context = context;
        m_resources = context.getResources();
        m_viewRes = textViewResourceId;
    }

    @Override
    public View getView(int position, View ConvertView, ViewGroup parent)
    {
        View view = ConvertView;
        ViewHolder holder;

        if(view == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(m_viewRes, parent, false);
            holder = new ViewHolder();
            holder.name  = (TextView)view.findViewById(R.id.TXT_Name);
            holder.distance = (TextView)view.findViewById(R.id.TXT_Distance);
            holder.image = (ImageView)view.findViewById(R.id.IMG_Planet);
            view.setTag(holder);
        }else
        {
            holder = (ViewHolder)view.getTag();
        }
        final planetItem item = m_planets.get(position);
        if(item != null)
        {
            final String planetName = String.format("Nom de la planète : %s", item.GetName());
            holder.name.setText(planetName);
            final String planetDistance = String.format("Eloignement de la planète : %s millions de km", (item.GetDistance()));
            holder.distance.setText(planetDistance);
            final Bitmap planetImage = item.GetImage();
            holder.image.setImageBitmap(planetImage);
        }
        return view;
    }

    public int getCount()
    {
        return m_planets.size();
    }
}
