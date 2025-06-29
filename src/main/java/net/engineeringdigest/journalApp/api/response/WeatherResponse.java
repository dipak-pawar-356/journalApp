
package net.engineeringdigest.journalApp.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WeatherResponse {

    private Current current;


    @Getter
    @Setter
    public class Current{

        private int temperature;


        @JsonProperty("weather_description")
        private List<String> weatherDescription;

        @JsonProperty("feelslike")
        private int feelsLike;


    }
}
