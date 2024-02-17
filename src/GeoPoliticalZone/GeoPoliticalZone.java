package GeoPoliticalZone;

public class GeoPoliticalZone {


    public enum GeoZones{
        NORTH_CENTRAL("Benue","FCT","Kogi","Kwara","Nassarawa","Niger","Plateau"),
        NORTH_EAST("Adamanwa","Bauchi","Borno","Gombe","Taraba","Yobe"),
        NORTH_WEST("Kaduna","Kastina","Kano","Kebbi","Sokoto","Jigawa","Zamfara"),
        SOUTH_EAST("Abia","Anambra","Ebonyi","Enugu","Imo"),
        SOUTH_SOUTH("Akwa-Ibom","Bayelsa","Cross River","Delta","Edo","Rivers"),
        SOUTH_WEST("Ekiti","lagos","Osun","Ondo","Ogun","Oyo"),
        ;

        private String[] states;
        GeoZones(String...states) {
            this.states = states;
        }

        public String[] getStates(){
            return states;
        }


    }



    public GeoZones getZone(String state) {
        GeoZones[] zones = GeoZones.values();

        for (int index = 0; index < zones.length; index++) {
            GeoZones zone = zones[index];
            for (int states = 0; states < zone.getStates().length; states++) {
                if (zone.getStates()[states].equalsIgnoreCase(state)) return zone;
            }
        }
        return null;
    }
}
