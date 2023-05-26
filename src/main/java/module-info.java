module com.example.jeu_6_qui_prend_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires org.slf4j;  // Declare the SLF4J dependency


    opens com.example.jeu_6_qui_prend_java to javafx.fxml;
    exports com.example.jeu_6_qui_prend_java;
    exports com.example.jeu_6_qui_prend_java.Model;
    exports com.example.jeu_6_qui_prend_java.ui;
    exports com.example.jeu_6_qui_prend_java.ui.card;
    opens com.example.jeu_6_qui_prend_java.Model to javafx.fxml;
}