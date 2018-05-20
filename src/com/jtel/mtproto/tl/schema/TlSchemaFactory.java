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

package com.jtel.mtproto.tl.schema;

import com.jtel.mtproto.storage.ConfStorage;

/**
 * This file is part of JTel
 * IntelliJ idea.
 * Date     : 6/17/16
 * Package : com.jtel.mtproto.tl.schema
 *
 * @author <a href="mailto:mohammad.mdz72@gmail.com">Mohammad Mohammad Zade</a>
 */

public final class TlSchemaFactory {

    public static String defaultProvider =  ConfStorage.getInstance().getApiConfiguration().getApiTlSchemaProvider();


    public static TlSchemaProvider createDefault(){
        return create(defaultProvider);
    }

    public static TlSchemaProvider create(String schema){
        switch (schema){
            case "json":
            default:
                return new JSONTlSchemaProvider();
        }
    }
}
