module com.example.jeu_6_qui_prend_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires org.slf4j;
    requires javafx.media;  // Declare the SLF4J dependency


    exports com.example.jeu_6_qui_prend_java.Model;
    exports com.example.jeu_6_qui_prend_java.Controller;
    opens com.example.jeu_6_qui_prend_java.Controller to javafx.fxml;
    opens com.example.jeu_6_qui_prend_java.Model to javafx.fxml;
    exports com.example.jeu_6_qui_prend_java.View;
    opens com.example.jeu_6_qui_prend_java.View to javafx.fxml;
}