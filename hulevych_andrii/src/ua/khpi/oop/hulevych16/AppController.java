package ua.khpi.oop.hulevych16;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class AppController {


    @FXML
    private TableView<Agency> table;

    @FXML
    private TableColumn<Agency, String> agencyName;

    @FXML
    private TableColumn<Agency, String> position;

    @FXML
    private TableColumn<Agency, Integer> salary;

    @FXML
    private TableColumn<Agency, String> workCircs;

    @FXML
    private TableColumn<Agency, Boolean> flag;

    @FXML
    private TableColumn<Agency, Integer> experience;

    @FXML
    private TableColumn<Agency, String>  education;




    @FXML
    private Button signUpButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button sortButton;

    @FXML
    private Button searchButton;

    @FXML
    private RadioButton firmNameSortRadio;

    @FXML
    private RadioButton yExpSortRadio;

    @FXML
    private RadioButton salarySortRadio;

    @FXML
    private RadioButton firmNameSearchRadio;

    @FXML
    private RadioButton salarySearchRadio;

    @FXML
    private RadioButton positionSearchRadio;

    @FXML
    private RadioButton yExpSearchRadio;

    @FXML
    private TextField searchPredicateField;

    @FXML
    private TextField countOfGeneratedField;

    @FXML
    private Button generateButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button saveDataButton;

    @FXML
    private Button loadDataButton;

    @FXML
    void initialize() {


        agencyName.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getFirmName()));
        position.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getPosition()));
        salary.setCellValueFactory(cellDataFeatures -> new SimpleIntegerProperty(cellDataFeatures.getValue().getSalary()).asObject());
        workCircs.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getCircs()));
        flag.setCellValueFactory(cellDataFeatures -> new SimpleBooleanProperty(cellDataFeatures.getValue().getKey()));
        experience.setCellValueFactory(cellDataFeatures -> new SimpleIntegerProperty(cellDataFeatures.getValue().getReqs().getYexp()).asObject());
        education.setCellValueFactory(cellDataFeatures -> new SimpleStringProperty(cellDataFeatures.getValue().getReqs().getEducation()));
        table.setItems(Collections.agenciesObservableList);

        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        table.setEditable(true);
        sortButton.setOnAction(actionEvent -> {
            if (salarySortRadio.isSelected()) {
                Collections.agenciesObservableList.sort(Comparator.comparingInt(o -> o.getSalary()));
            } else if (firmNameSortRadio.isSelected()) {
                Collections.agenciesObservableList.sort(Comparator.comparing(p -> p.getFirmName()));
            } else {
                Collections.agenciesObservableList.sort(Comparator.comparingInt(p -> p.getReqs().getYexp()));
            }
        });

        searchButton.setOnAction(actionEvent -> {
            Collections.agenciesObservableList.clear();
            String searchPredicate = searchPredicateField.getText();
            if (firmNameSearchRadio.isSelected()) {
                for (Agency e : Collections.list) {
                    if (searchPredicate.equalsIgnoreCase(e.getFirmName())) {
                        Collections.agenciesObservableList.add(e);
                    }
                }
            } else if (salarySearchRadio.isSelected()) {
                 String salary = searchPredicateField.getText();
                for (Agency e : Collections.list) {
                   if(e.getSalary() == Integer.parseInt(salary)){
                       Collections.agenciesObservableList.add(e);
                   }
                }
            } else if (positionSearchRadio.isSelected()) {
                searchPredicate = searchPredicateField.getText();
                    for (Agency e : Collections.list) {
                        if (searchPredicate.equalsIgnoreCase(e.getPosition())) {
                            Collections.agenciesObservableList.add(e);
                        }
                    }

            } else {
                for (Agency a : Collections.list) {
                    String yExp = searchPredicateField.getText();
                    for (Agency e : Collections.list) {
                        if(e.getReqs().getYexp() == Integer.parseInt(yExp)){
                            Collections.agenciesObservableList.add(e);
                        }
                }
            }
        }});

        generateButton.setOnAction(actionEvent -> {
            int count = Integer.parseInt(countOfGeneratedField.getText());
            Collections.agenciesObservableList.clear();
            Collections.list.clear();
            try {
                Collections.list.addAll(Generate.agencyGeneration(count));
            } catch (IOException e) {
                e.printStackTrace();
            };
            Collections.agenciesObservableList.addAll(Collections.list);
        });

        resetButton.setOnAction(actionEvent -> {
            Collections.agenciesObservableList.clear();
            Collections.agenciesObservableList.addAll(Collections.list);
        });

        removeButton.setOnAction(actionEvent ->{
            ObservableList<Agency> accountsSelected = table.getSelectionModel().getSelectedItems();
            ArrayList<Agency> items =  new ArrayList<Agency>(table.getSelectionModel().getSelectedItems());
            Collections.agenciesObservableList.removeAll(accountsSelected);
            table.getSelectionModel().clearSelection();
            Collections.list.removeAll(items);
        });

        signUpButton.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/add.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        exitButton.setOnAction(actionEvent -> {
            exitButton.getScene().getWindow().hide();
        });

        clearButton.setOnAction(actionEvent -> {
            Collections.list.clear();
            Collections.agenciesObservableList.clear();
        });

        saveDataButton.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/save.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.showAndWait();
        });

        loadDataButton.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/load.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.showAndWait();
        });

    }
}