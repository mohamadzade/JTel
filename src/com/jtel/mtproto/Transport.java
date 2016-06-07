package com.jtel.mtproto;

import java.io.IOException;

/**
 * This file is part of JTel
 * IntelliJ idea.
 * Date     : 6/6/16
 * Package : com.jtel.mtproto.services
 *
 * @author <a href="mailto:mohammad.mdz72@gmail.com">Mohammad Mohammad Zade</a>
 */

public interface  Transport {

    void send(byte[] message) throws IOException;

    byte[] receive() throws IOException;
}
