/*
 * This file is part of JTel.
 *
 *     JTel is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     JTel is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with JTel.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jtel.mtproto.services;

import java.util.Random;

/**
 * This file is part of JTel
 * IntelliJ idea.
 * Date     : 6/6/16
 * Package : com.jtel.mtproto.services
 *
 * @author <a href="mailto:mohammad.mdz72@gmail.com">Mohammad Mohammad Zade</a>
 */

public final class TimeManagerService {

    private static  TimeManagerService instance;

    public synchronized static TimeManagerService getInstance() {
        if (instance == null) {
            instance = new TimeManagerService();
        }
        return instance;
    }

    private long timeDelta;


    private TimeManagerService() {

    }

    public long getLocalTime() {
        return System.currentTimeMillis();
    }

    public void setTimeDelta(long timeDelta) {
        this.timeDelta = timeDelta;
    }

    public long generateMessageId() {

    int a=        new Random().nextInt(0x0FFFFFFF);

        return  ((getLocalTime()+timeDelta)/1000) << 32 | a ;
    }



}
