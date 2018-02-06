package za.co.crosstek.core;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tinus
 */
@Singleton
public class Communicator {

    private static final Logger LOG = LoggerFactory.getLogger(Communicator.class);

    private static boolean SENDING_SMSES = false;
    private static boolean SENDING_EMAIL = false;
    private static boolean SENDING_NOTIFICATIONS = false;

    @Schedule(second = "*/30", minute = "*", hour = "*", persistent = false)
    public synchronized void sendEmails() {

        try {

        } catch (Exception e) {
            LOG.error("Could not send emails", e);
        }
    }

    @Schedule(second = "*/15", minute = "*", hour = "*", persistent = false)
    public synchronized void sendNotifications() {

        try {

        } catch (Exception e) {
            LOG.error("Could not send notifications", e);
        }
    }

    @Schedule(second = "*/30", minute = "*", hour = "*", persistent = false)
    public synchronized void sendSmses() {

        try {

        } catch (Exception e) {
            LOG.error("Could not send smses", e);
        }
    }

}
