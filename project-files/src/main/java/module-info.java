module eus.ehu.borderpanedemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.xml;
    requires jdk.xml.dom;
    requires javafx.web;
    requires java.datatransfer;
    requires java.desktop;
    requires okhttp3;
    requires com.google.gson;

    opens eus.ehu.socialnetwork to javafx.fxml;
    exports eus.ehu.socialnetwork;
    opens eus.ehu.socialnetwork.domain to javafx.fxml, com.google.gson;
    exports eus.ehu.socialnetwork.domain;
    opens eus.ehu.socialnetwork.controllers to javafx.fxml, com.google.gson;
    exports eus.ehu.socialnetwork.controllers;

}
