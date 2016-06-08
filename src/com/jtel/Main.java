package com.jtel;

import com.jtel.common.secure.Randoms;
import com.jtel.mtproto.Config;
import com.jtel.mtproto.PlainHttpTransport;
import com.jtel.mtproto.pq.Pq;
import com.jtel.mtproto.pq.PqSolver;
import com.jtel.mtproto.services.TlSchemaManagerService;
import com.jtel.mtproto.tl.TlMethod;
import com.jtel.mtproto.tl.TlObject;

import java.io.IOException;
import java.util.Random;

import static com.jtel.mtproto.tl.Streams.writeInt64;

public class Main {

    public static void main(String[] args) throws IOException {


        TlMethod method = new TlMethod("req_pq");
        method.put("nonce", Randoms.nextRandomBytes(16));

        PlainHttpTransport transport = new PlainHttpTransport(Config.dcAddresses.get(1));
        transport.send(method);
        TlObject resPq = transport.receive();
        PqSolver.Solve(new Pq(resPq.get("pq")));

    }


}
