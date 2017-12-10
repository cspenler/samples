package de.cspenler.interfaceA;

import java.util.UUID;

public class BackendADAO {

    public String getValue() throws Exception {
        return ("backend-a:" + UUID.randomUUID());
    }
}
