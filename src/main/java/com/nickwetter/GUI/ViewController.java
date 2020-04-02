package com.nickwetter.GUI;

import com.nickwetter.Item.Item;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Observable;

//FXML controller class

public class ViewController
{
    @FXML private TableView<Item> itemTable;
    @FXML private TableColumn<Item,String> nameColumn;
    @FXML private TableColumn<Item, Integer> qtyColumn;
    @FXML private TableColumn<Item,Integer> idColumn;
    @FXML private TableColumn<Item, Double> ppuColumn;
    @FXML private TableColumn<Item, Double> totalPriceColumn;
    
}
