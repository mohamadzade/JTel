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

import com.jtel.mtproto.tl.schema.TlSchemaProvider;
import com.sun.istack.internal.Nullable;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import static com.jtel.mtproto.tl.Streams.writeMethod;

/**
 * This file is part of JTel
 * IntelliJ idea.
 * Date     : 6/7/16
 * Package : com.jtel.mtproto.tl
 *
 * @author <a href="mailto:mohammad.mdz72@gmail.com">Mohammad Mohammad Zade</a>
 */

public class TlMethod extends TlObject {
    private String method;;

    public TlMethod(String methodName) throws IOException{
        TlSchemaProvider schemaManagerService = TlSchemaProvider.getInstance();
        TlMethod method = schemaManagerService.getMethod(methodName);
        setId( method.getId());
        this.method = method.method;
        setParams(method.getParams());
        setType(method.getType());

    }
    public  TlMethod(){
        method ="unknown";
        setParams(new ArrayList<>());
        setType("unknown");
    }
    @Nullable
    public TlMethod put(String field, @Nullable Object o) {
        for (TlParam param : getParams()) {
            if(param.getName().equals(field)){
                param.setValue(o);
                return this;
            }
        }
        return this;
    }

    @Override
    public String getName() {
        return method;
    }

    @Override
    public void setName(String name) {
        method = name;
    }

    @Override
    public byte[] serialize() throws IOException,InvalidTlParamException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        writeMethod(os,this);
        return os.toByteArray();
    }



    @Override
    public void deSerialize(InputStream is) throws IOException {
        throw  new NotImplementedException();
    }


    @Override
    public String toString() {
        return String.format("%s#%s %s = %s",method, HexBin.encode( ByteBuffer.allocate(4).putInt(getId()).array()),getParams().toString(),getType());
    }


}
