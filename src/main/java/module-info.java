module com.example.jeu_6_qui_prend_java {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jeu_6_qui_prend_java to javafx.fxml;
    exports com.example.jeu_6_qui_prend_java;
}