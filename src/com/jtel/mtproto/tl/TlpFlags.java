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

package com.jtel.mtproto.tl;

import com.jtel.common.io.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * This file is part of JTel
 * IntelliJ idea.
 * Date     : 6/23/16
 * Package : com.jtel.mtproto.tl
 *
 * @author <a href="mailto:mohammad.mdz72@gmail.com">Mohammad Mohammad Zade</a>
 */

public class TlpFlags {
    List<String> pFlags;
    public TlpFlags(){
        pFlags = new ArrayList<>();
    }


    protected void addFlag(String flag){
        pFlags.add(flag);
    }

    public boolean hasFlag(String flag){
        return pFlags.contains(flag);
    }

    @Override
    public String toString() {
        String flags ="<";
        flags+=String.join(",",pFlags);
        if(flags.equals("<")){
            flags+="...";
        }
        flags +=">";
        return String.format("pFlags:%s",flags);
    }
}
