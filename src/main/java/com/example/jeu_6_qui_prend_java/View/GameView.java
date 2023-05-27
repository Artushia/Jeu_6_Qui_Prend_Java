package com.example.jeu_6_qui_prend_java.View;

//import com.example.jeu_6_qui_prend_java.View.CardView;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GameView {

    private BorderPane component;
    private Pane centerArea;

    int cardWidth = 65;
    int cardHeight = 115;

    Insets cardInsets = new Insets(2);

    int currEndRow = 7;
    int currEndCol = 4;

    Label endLabel;}

    //---------------------------------------------------------------------------------------------

 /*   public GameView() {

        this.component = new BorderPane();
        centerArea = new Pane();


        int row = 0;
        int col = 1;

        for (int i = 0; i <= 3; i++) {

            Rectangle rectangleOutline = new Rectangle(cardWidth, cardHeight);
            rectangleOutline.setStyle("-fx-fill: transparent; -fx-stroke: black; -fx-stroke-width: 2px;");
            nodeSetLayoutAt(rectangleOutline, cardPosForRowCol(row, i));

        }


    }}*/


        /*for(Card card: Cards.cards) {
            if (card.value % 20 == 0) {
                row++;
                col = 0;
            }
            CardView cardView = new CardView(card, cardWidth, cardHeight);
            Pane cardComponent = cardView.getComponent();
            // assign position..

            nodeSetLayoutAt(cardComponent, cardPosForRowCol(row, col));

            cardComponent.setOnMouseClicked(e -> onMouseClickCard(e, cardView));

            centerArea.getChildren().add(cardComponent);
            col++;
        }*/

       /* centerArea.getChildren().add(endLabel);
        currEndRow = row; currEndCol = col;
        nodeSetLayoutAt(endLabel, cardPosForRowCol(currEndRow, currEndCol));

        component.setCenter(centerArea);*/


  /*  private void onMouseClickCard(MouseEvent e, CardView cardView) {
        if (e.isSecondaryButtonDown() || e.isShiftDown() || e.isControlDown()) {
            // TODO ... animate move card to end..
            System.out.println("onMouseClickCard..RightButton => move card " + cardView + " to end");

            Pane cardComponent = cardView.getComponent();
            Point2D fromPt = new Point2D(cardComponent.getLayoutX(), cardComponent.getLayoutY());

            Point2D toPt = cardPosForRowCol(currEndRow, currEndCol);
            currEndCol++;
            nodeSetLayoutAt(endLabel, cardPosForRowCol(currEndRow, currEndCol));

            // remove then add cardView, so that it is on top of all others
            centerArea.getChildren().remove(cardComponent);
            centerArea.getChildren().add(cardComponent);

            // animate move card to end
            Point2D translate = toPt.subtract(fromPt);
            TranslateTransition translateTransition = new TranslateTransition();
            translateTransition.setNode(cardComponent);
            translateTransition.setDuration(Duration.millis(500));
            translateTransition.setToX(translate.getX());
            translateTransition.setToY(translate.getY());
            translateTransition.play();

        } else {
            System.out.println("onMouseClickCard => toggle card " + cardView);
            cardView.toggleCard();
        }
    }

    protected static void nodeSetLayoutAt(Node node, Point2D pt) {
        node.setLayoutX(pt.getX());
        node.setLayoutY(pt.getY());
    }
    protected Point2D cardPosForRowCol(int row, int col) {
        return new Point2D(10 + col * (cardInsets.getLeft() + cardWidth + cardInsets.getRight())
                , 10 + row * (cardInsets.getTop() + cardHeight + cardInsets.getBottom()));
    }


    //---------------------------------------------------------------------------------------------

    public Node getComponent() {
        return component;
    }

}*/
