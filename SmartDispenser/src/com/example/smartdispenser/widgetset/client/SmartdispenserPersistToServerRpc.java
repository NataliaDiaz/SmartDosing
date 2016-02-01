package com.example.smartdispenser.widgetset.client;

import com.vaadin.shared.communication.ServerRpc;

public interface SmartdispenserPersistToServerRpc extends ServerRpc {
    void persistToServer();
}
