package com.example.jeu_6_qui_prend_java.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Le6QuiPrendApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane mainBorderPanel = new BorderPane();

        VBox menuAndToolbar = new VBox();
        { // MenuBar with "File" menu
            MenuBar mb = new MenuBar();
            menuAndToolbar.getChildren().add(mb);

            Menu fileMenu = new Menu("File");
            mb.getMenus().add(fileMenu);
            MenuItem openMenuItem = new MenuItem("Open");
            fileMenu.getItems().add(openMenuItem);
            MenuItem saveMenuItem = new MenuItem("Save");
            fileMenu.getItems().add(saveMenuItem);
        }

        { // button Toolbar
            ToolBar toolBar = new ToolBar();
            menuAndToolbar.getChildren().add(toolBar);

            Button button1 = new Button("button1");
            toolBar.getItems().add(button1);
        }
        mainBorderPanel.setTop(menuAndToolbar);

        GameView gameView = new GameView();
        mainBorderPanel.setCenter(gameView.getComponent());

        Scene scene = new Scene(mainBorderPanel, 1400, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
