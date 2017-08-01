package ancapopa.clinica;

import android.app.Application;

import com.squareup.otto.Bus;

/**
 * Created by vlad on 26/07/2017.
 */

public class ClinicaApplication extends Application {
    private Bus eventBus;
    public void onCreate() {
        super.onCreate();

        eventBus = new Bus();
    }

    public Bus getEventBus() {
        return eventBus;
    }
}
