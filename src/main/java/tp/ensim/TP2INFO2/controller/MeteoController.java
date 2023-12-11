package tp.ensim.TP2INFO2.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import tp.ensim.TP2INFO2.model.AdresseMeteo;
import tp.ensim.TP2INFO2.model.AdresseMeteoRepository;
import tp.ensim.TP2INFO2.model.ResponseEtalab;
import tp.ensim.TP2INFO2.model.ResponseMeteo;


@Controller
public class MeteoController {

     @Autowired
    private AdresseMeteoRepository adresseMeteoRepository;


    double latitude;
    double longitude;

    RestTemplate restTemplate = new RestTemplate();

    public static String token = "4f70fd762e9d89340b13bf82da2fb8cd695d92592d55c1625c69843d5d07183d";


    @GetMapping("/meteo")
    public String showMeteoForm() {
        return "meteo";
    }

    @PostMapping("/meteo")
    public String getWeather(@RequestParam("address") String address, Model model) {

        String query = address.toLowerCase().replace(" ", "+");

        ResponseEntity<ResponseEtalab> response = restTemplate.getForEntity(
            "https://api-adresse.data.gouv.fr/search/?q=" + query + "&limit=1",
            ResponseEtalab.class
        );

        ResponseEtalab jsonResponse = response.getBody();

        model.addAttribute("response", jsonResponse);

       // Récupération des fonctionnalités
        List<ResponseEtalab.Feature> features = jsonResponse.getFeatures();

        if (features != null && !features.isEmpty()) {
            // Pour accéder à la première fonctionnalité de la liste
            ResponseEtalab.Feature firstFeature = features.get(0);

            // Récupération de la géométrie de la première fonctionnalité
            ResponseEtalab.Feature.Geometry geometry = firstFeature.getGeometry();


            // Accès aux coordonnées à partir de la géométrie
            latitude = geometry.getCoordinates()[1];
            longitude = geometry.getCoordinates()[0];

            model.addAttribute("latitude", latitude);
            model.addAttribute("longitude", longitude);

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            HttpEntity<String> requestEntity = new HttpEntity<>(headers);

            String urlMeteo = "https://api.meteo-concept.com/api/forecast/daily/0?token="+ token + "&latlng=" + latitude + "," + longitude;

            ResponseEntity<ResponseMeteo> res = restTemplate.exchange(urlMeteo, HttpMethod.GET, requestEntity, ResponseMeteo.class);


            ResponseMeteo meteoResponse = res.getBody();

            // Récupérer les données spécifiques pour l'affichage
            String wind10m = meteoResponse.getForecast().getWind10m();
            String probarain = meteoResponse.getForecast().getProbarain();
            String tmin = meteoResponse.getForecast().getTmin();
            String tmax = meteoResponse.getForecast().getTmax();
            String sunHours = meteoResponse.getForecast().getSun_hours();

            int sunHoursInt = 0;
            int probarainInt = 0;
            try {
                sunHoursInt = Integer.parseInt(sunHours);
                probarainInt = Integer.parseInt(probarain);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            // Ajouter les données au modèle pour les afficher dans la vue
            model.addAttribute("wind10m", wind10m);
            model.addAttribute("probarain", probarain);
            model.addAttribute("probarainInt", probarainInt);
            model.addAttribute("tmin", tmin);
            model.addAttribute("tmax", tmax);
            model.addAttribute("sunHours", sunHours);
            model.addAttribute("sunHoursInt", sunHoursInt);

            model.addAttribute("address", address);

            AdresseMeteo adresseMeteo = new AdresseMeteo();
            adresseMeteo.setAddress(address);
            adresseMeteo.setCreation(new Date());
            adresseMeteo.setWind10m(wind10m);
            adresseMeteo.setProbarain(probarain);
            adresseMeteo.setTmin(tmin);
            adresseMeteo.setTmax(tmax);
            adresseMeteo.setSunHours(sunHours);

            adresseMeteoRepository.save(adresseMeteo);

        } else {
            return "error";
        }



        return "meteo";
    }

    @GetMapping("/searchAddress")
    public String searchAddresses(@RequestParam(name="query", required=false, defaultValue="") String query, Model model) {
        // Recherche des adresses contenant la chaîne spécifiée dans l'adresse
        List<AdresseMeteo> addresses = adresseMeteoRepository.findByAddressContaining(query);
        model.addAttribute("addresses", addresses);
        model.addAttribute("query", query);
        return "listeAdresses";
    }

    @PostMapping("/delete/{id}")
    public String deleteAddress(@PathVariable("id") Long id) {
        // Supprimer l'adresse de la base de données en utilisant son ID
        adresseMeteoRepository.deleteById(id);
        return "redirect:/searchAddress";
    }


}