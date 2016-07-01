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

package com.jtel.api.objects;

import com.jtel.mtproto.tl.TlObject;

/**
 * This file is part of JTel
 * IntelliJ idea.
 * Date     : 7/1/16
 * Package : com.jtel.api.objects
 *
 * @author <a href="mailto:mohammad.mdz72@gmail.com">Mohammad Mohammad Zade</a>
 */

public abstract class TlObjectWrapper {

    protected TlObject context;

    public TlObjectWrapper(TlObject object){
        context = object;
    }

    protected abstract void wrap();

}
