package tp.ensim.TP2INFO2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEtalab {
    private String type;
    private String version;
    private List<Feature> features;
    private String attribution;
    private String licence;
    private String query;
    private int limit;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Feature {
        private String type;
        private Geometry geometry;
        private Properties properties;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Geometry {
            private String type;
            private double[] coordinates;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Properties {
            private String label;
            private double score;
            private String housenumber;
            private String id;
            private String name;
            private String postcode;
            private String citycode;
            private double x;
            private double y;
            private String city;
            private String context;
            private String featureType;
            private double importance;
            private String street;
        }
    }
}
