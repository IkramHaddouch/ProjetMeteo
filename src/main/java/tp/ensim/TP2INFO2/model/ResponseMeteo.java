package tp.ensim.TP2INFO2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMeteo {
    private City city;
    private String update;
    private Forecast forecast;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class City {
        private String insee;
        private String cp;
        private String name;
        private String latitude;
        private String longitude;
        private String altitude;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Forecast {
        private String insee;
        private String cp;
        private String latitude;
        private String longitude;
        private String day;
        private String datetime;
        private String wind10m;
        private String gust10m;
        private String dirwind10m;
        private String rr10;
        private String rr1;
        private String probarain;
        private String weather;
        private String tmin;
        private String tmax;
        private String sun_hours;
        private String etp;
        private String probafrost;
        private String probafog;
        private String probawind70;
        private String probawind100;
        private String gustx;
    }

}

