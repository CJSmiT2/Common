package ua.org.smit.common.web.antibrut;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AntiBrut {

    private final int maxCount;

    private final List<Action> actions = new ArrayList<>();

    public AntiBrut(int maxCount) {
        this.maxCount = maxCount;
    }

    public boolean isCanHit(int id, String session) {
        deleteOld();
        if (maxCount > 0 && isOverLoad(maxCount, id, session)) {
            return true;
        }

        if (isBrutal(id, session)) {
            return false;
        } else {
            actions.add(new Action(id, session));
            return true;
        }
    }

    private boolean isBrutal(int id, String session) {
        for (Action action : actions) {
            if (action.isEquals(id, session)) {
                if (action.isOutTime()) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private void deleteOld() {
        Iterator<Action> i = actions.iterator();
        while (i.hasNext()) {
            Action action = i.next();
            if (action.isOld()) {
                i.remove();
            }
        }
    }

    private boolean isOverLoad(int maxCount, int id, String session) {
        int count = 0;
        for (Action action : actions) {
            if (action.isEquals(id, session)) {
                count++;
            }
        }
        return count > maxCount;
    }

    class Action {

        private final int periodSec = 5 * 1000;
        private final int id;
        private final String session;
        private final long time;

        public Action(int id, String session) {
            this.id = id;
            this.session = session;
            this.time = System.currentTimeMillis();
        }

        private boolean isEquals(int id, String session) {
            return this.id == id && this.session.equals(session);
        }

        private boolean isOutTime() {
            return System.currentTimeMillis() > (time + periodSec);
        }

        private boolean isOld() {
            return System.currentTimeMillis() > (time + (120 * 1000)); // 2min
        }

    }

}
