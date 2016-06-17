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

import com.jtel.mtproto.tl.TlMethod;
import com.jtel.mtproto.tl.TlObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This file is part of JTel
 * IntelliJ idea.
 * Date     : 6/7/16
 * Package : com.jtel.mtproto.services
 *
 * @author <a href="mailto:mohammad.mdz72@gmail.com">Mohammad Mohammad Zade</a>
 */

public abstract class TlSchemaProvider {

    private TlSchema mtpSchema;
    private TlSchema apiSchema;

    private static TlSchemaProvider instance;

    public static TlSchemaProvider getInstance() {
        if (instance == null) {
            instance = TlSchemaFactory.createDefault();
        }
        return instance ;
    }



    protected abstract TlSchema loadMtpSchema();

    protected abstract TlSchema loadApiSchema();


    protected void initialize(){
        if(apiSchema == null){
            apiSchema = loadMtpSchema();
        }
        if (mtpSchema == null) {
            mtpSchema = loadApiSchema();
        }
    }

    public TlSchema getApiSchema() {
        return apiSchema;
    }

    public TlSchema getMtpSchema() {

        return mtpSchema;
    }


    public TlObject getConstructor(String predicate, boolean mtp) {
        List<TlObject> constructors;
        if(mtp) {
            constructors = mtpSchema.constructors;
        }
        else {
            constructors = apiSchema.constructors;
        }

        for (TlObject o : constructors) {
            if (o.predicate.equals(predicate)) {
                //System.out.println(o);
                return o;
            }
        }
        return null;
    }
    public TlObject getConstructor(String predicate) {
        TlObject tlObject = getConstructor(predicate,false);
        if(tlObject == null) {
            tlObject = getConstructor(predicate,true);
        }
        return tlObject;
    }
    public TlObject getConstructor(int id) {


        for (TlObject o : mtpSchema.constructors) {
            if (o.id == id) {
               // System.out.println(o);
                return o;
            }
        }
        for (TlObject o : apiSchema.constructors) {
            if (o.id == id) {
                //System.out.println(o);
                return o;
            }
        }
        return null;
    }
    public List<TlObject> getDefinitions(String type, boolean mtp) {
        List<TlObject> constructors;
        List<TlObject> definitions = new ArrayList<>();
        if(mtp) {
            constructors = mtpSchema.constructors;
        }
        else {
            constructors = apiSchema.constructors;
        }

        for (TlObject o : constructors) {
            if (o.type.equals(type)) {
                definitions.add(o);
            }
        }
        return definitions;
    }

    public TlMethod getMethod(String method){
        for (TlMethod o : mtpSchema.methods) {
            if (o.method.equals(method)) {
                return o;
            }
        }
        for (TlMethod o : apiSchema.methods) {
            if (o.method.equals(method)) {
                return o;
            }
        }
        return new TlMethod();
    }

}
