package e.tamen.listplanets;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class planetItem
{
    private String m_name;
    private String m_distance;
    private Bitmap m_image;

    public void SetName(String name) {m_name = name;}
    public String GetName() {return m_name;}

    public void SetDistance(String distance){ m_distance = distance;}
    public String GetDistance() {return m_distance;}

    public void SetImage(Bitmap image) { m_image = image; }
    public Bitmap GetImage() {return m_image;}
}
