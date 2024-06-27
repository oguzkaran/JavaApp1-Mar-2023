package org.csystem.app.weatherinfo.daily.scheduler;

import com.karandev.util.data.service.DataServiceException;
import com.sunny.app.weatherinfo.daily.service.WeatherInfoDailyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {"com.sunny", "com.eager"})
@EnableScheduling
@Slf4j
public class CollectorScheduler {
    private final WeatherInfoDailyService m_weatherInfoDailyService;

    public CollectorScheduler(WeatherInfoDailyService weatherInfoDailyService)
    {
        m_weatherInfoDailyService = weatherInfoDailyService;
    }

    @Scheduled(cron = "0 0 2,14 * * *")
    public void schedule()
    {
        try {
            m_weatherInfoDailyService.collectPlaceInfoLocationWeatherData();
            log.info("Weather data collected");
        }
        catch (DataServiceException ex) {
            log.error("collectPlaceInfoLocationWeatherData:{}", ex.getMessage());
        }
    }
}
