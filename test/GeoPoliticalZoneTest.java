import GeoPoliticalZone.GeoPoliticalZone;
import org.junit.jupiter.api.Test;

import static GeoPoliticalZone.GeoPoliticalZone.GeoZones.NORTH_CENTRAL;
import static GeoPoliticalZone.GeoPoliticalZone.GeoZones.SOUTH_WEST;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoPoliticalZoneTest {

    @Test
    public void geoZoneTest(){
        GeoPoliticalZone geoZone = new GeoPoliticalZone();
        assertEquals(6, GeoPoliticalZone.GeoZones.values().length);
    }

    @Test
    public void returnGeoZoneForStateEntered(){
        GeoPoliticalZone geoZone = new GeoPoliticalZone();
        assertEquals(NORTH_CENTRAL,geoZone.getZone("Kwara"));
        assertEquals(SOUTH_WEST ,geoZone.getZone("lagos"));
    }




}
