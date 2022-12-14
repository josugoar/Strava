package es.deusto.ingenieria.sd.strava.server.services;

import java.util.List;

import es.deusto.ingenieria.sd.strava.server.data.domain.Activity;
import es.deusto.ingenieria.sd.strava.server.data.domain.Athlete;

public class ActivityAppService {

    private static ActivityAppService instance;

    private ActivityAppService() {
    }

    public static ActivityAppService getInstance() {
        if (instance == null) {
            instance = new ActivityAppService();
        }

        return instance;
    }

    public void createActivity(final Athlete athlete, final Activity activity) throws IllegalArgumentException {
        athlete.addActivity(activity);
    }

    public List<Activity> getActivities(final Athlete athlete) {
        return List.copyOf(athlete.getActivities());
    }

}
