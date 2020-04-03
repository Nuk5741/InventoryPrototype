package com.nickwetter.GUI;

import com.nickwetter.Item.Item;
import com.nickwetter.inventory.ParentList;
import com.nickwetter.inventory.SubList;
import com.nickwetter.inventory.SublistFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.Observable;
import java.util.Random;
import java.util.ResourceBundle;

//FXML controller class

/*
    THIS IS THE DEV. BRANCH
    MAKE WHATEVER CHANGES HERE
 */

public class ViewController implements Initializable
{
    ParentList list = ParentList.getInstance();
    SublistFactory factory = new SublistFactory();
    Random random = new Random();
    private int counter = 0;

    //Center tableView fields
    @FXML private TableView<Item> itemTable;
    @FXML private TableColumn<Item,String> nameColumn;
    @FXML private TableColumn<Item, Integer> qtyColumn;
    @FXML private TableColumn<Item,Integer> idColumn;
    @FXML private TableColumn<Item, Double> ppuColumn;
    @FXML private TableColumn<Item, Double> totalPriceColumn;

    //Sublist tableView fields
    @FXML private TableView<SubList> sublistTable;
    @FXML private TableColumn<SubList, String> sublistNameColumn;


    @FXML private void handleSublistPlusButton(ActionEvent event)
    {
        String name = "new sublist"+counter;
        SubList sublist = factory.createSublist(name);
        if(list.addSublist(sublist))
        {
            sublistTable.getItems().add(sublist);
            counter++;
        }

    }

    private void initializeItemTable()
    {
        intializeItemTableColumns();
        itemTable.setItems(getItems());

        itemTable.setEditable(true);
    }

    private void intializeItemTableColumns()
    {
        //Center tableView columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("name"));
        qtyColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("ID"));
        ppuColumn.setCellValueFactory(new PropertyValueFactory<Item, Double>("pricePerUnit"));
        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<Item, Double>("totalPrice"));
    }

    private void initializeEditableItemTableColumns()
    {
        //nameColumn.setCellValueFactory(TextFieldTableCell.forTableColumn());
    }




    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        initializeItemTable();
        //Sublist tableView columns
        sublistNameColumn.setCellValueFactory(new PropertyValueFactory<SubList, String>("name"));

        //Set items

        sublistTable.setItems(getSublists());

    }

    public ObservableList<Item> getItems()
    {

        ObservableList<Item> items = FXCollections.observableArrayList();
        //items.add(new Item.ItemBuilder("Chair",5).setPricePerUnit(34.21).build());

        for(Item i:list.getSelectedSublist().getList())
        {
            items.add(i);
        }

        return items;
    }

    public ObservableList<SubList> getSublists()
    {

        ObservableList<SubList> sublists = FXCollections.observableArrayList();

        for(SubList s: list.getSublists())
        {
            sublists.add(s);
        }

        return sublists;
    }
}
