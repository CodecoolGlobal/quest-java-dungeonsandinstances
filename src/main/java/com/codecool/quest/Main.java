package com.codecool.quest;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.GameMap;
import com.codecool.quest.logic.MapLoader;
import com.codecool.quest.logic.actors.Actor;
import com.codecool.quest.logic.items.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.event.*;

public class Main extends Application {
    GameMap map = MapLoader.loadMap();
    Canvas canvas = new Canvas(
            map.getWidth() * Tiles.TILE_WIDTH,
            map.getHeight() * Tiles.TILE_WIDTH);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Label healthLabel = new Label();
    Label itemPickUp = new Label();
    ListView listView = new ListView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane ui = new GridPane();
        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));

        ui.add(new Label("Health: "), 0, 0, 1, 1);
        ui.add(healthLabel, 1, 0);
        ui.add(itemPickUp, 0,1);

        /*Button button = new Button("Pick up item");
        ui.add(button, 0, 1, 1, 1);
        button.setPrefSize(100, 50);*/

      /*  listView.getItems().add("Pine");
        listView.getItems().add("Key");
        listView.getItems().add("Bomb");*/


     /*   if(!map.getPlayer().getItemToPickup(map.getPlayer().getCell()).equals(null)){
            listView.getItems().add(map.getPlayer().getItemToPickup(map.getPlayer().getCell()).getTileName());
        }*/

       /* button.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent e) {
                button.setText("Item picked");
            }
        });*/



        VBox vbox = new VBox(listView);
        vbox.setPrefSize(100,150);
        ui.add(vbox, 0, 2, 1, 1);

        ui.setHgap(10);
        ui.setVgap(10);

        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(canvas);
        borderPane.setRight(ui);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);

        primaryStage.setTitle("Codecool Quest");
        primaryStage.show();

        GameTimer gameTimer = new GameTimer();
        gameTimer.setup(this::step);
        gameTimer.play();


    }


    private void step() {
        map.getActors().forEach(Actor::move);
        refresh();

    }

    private void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case W:
                map.getPlayer().setNewDY(-1);
                break;
            case S:
                map.getPlayer().setNewDY(1);
                break;
            case A:
                map.getPlayer().setNewDX(-1);
                break;
            case D:
                map.getPlayer().setNewDX(1);
                break;
            case E:
                Item item = map.getPlayer().getCell().getItem();
                if(item == null){
                    break;
                }else{
                    map.getPlayer().pickUpItem(item);
                    map.getPlayer().getCell().setItem(null);
                    listView.getItems().add(item.getTileName());
                }
        }
    }

    private void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Cell cell = map.getCell(x, y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else if(cell.getItem() != null){
                    Tiles.drawTile(context, cell.getItem(), x, y);
                } else{
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        healthLabel.setText("" + map.getPlayer().getHealth());

        Item item = map.getPlayer().getCell().getItem();
        //listView.getItems().add(item.getTileName());
        if(item == null){
            itemPickUp.setText("'E' to pick up: nothing");
     /*       System.out.println(item.getTileName());
            listView.getItems().add(item.getTileName());
            map.getPlayer().getCell().setItem(null);*/
        }else{
            itemPickUp.setText("'E' to pick up: " + item.getTileName());
            }

        }
    }

