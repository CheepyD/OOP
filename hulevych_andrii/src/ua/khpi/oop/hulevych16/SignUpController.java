package ua.khpi.oop.hulevych16;

import javafx.fxml.FXML;
import javafx.scene.control.*;


public class SignUpController {


    @FXML
    private TextField firmNameField;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField positionField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField salaryField;

    @FXML
    private TextArea educationField;

    @FXML
    private TextField experienceField;

    @FXML
    private TextArea workCircsField;

    @FXML
    private RadioButton falseRadioBtn;

    @FXML
    private RadioButton trueRadioBtn;

    @FXML
    void initialize() {
        falseRadioBtn.setOnMouseClicked(actionEvent -> {
            educationField.setDisable(true);
            experienceField.setDisable(true);
        });

        trueRadioBtn.setOnMouseClicked(actionEvent -> {
            educationField.setDisable(false);
            experienceField.setDisable(false);
        });

        signUpButton.setOnAction(actionEvent -> {

            StringBuilder sb = new StringBuilder();
            boolean add = true;
            int i = 1;

            String firmName = firmNameField.getText();
            String position = positionField.getText();
            String circs = workCircsField.getText();
            String salary = salaryField.getText();
            String experience = experienceField.getText();
            String education = educationField.getText();
            int salaryFin = 0;
            int experienceFin = 0;


            if (!ua.khpi.oop.mishchenko16.RegexCheck.validateText(firmName)) {
                add = false;
                sb.append(i++).append(") Error in firm name. Should not contain digits or special symbols\n");
            }
            if (!ua.khpi.oop.mishchenko16.RegexCheck.validateText(position)) {
                add = false;
                sb.append(i++).append(") Error in position. Should not contain digits or special symbols\n");
            }
            if (!ua.khpi.oop.mishchenko16.RegexCheck.validateText(circs)) {
                add = false;
                sb.append(i++).append(") Error in circs. Should not contain digits or special symbols\n");
            }
            if (!ua.khpi.oop.mishchenko16.RegexCheck.validateInt(salary)) {
                add = false;
                sb.append(i++).append(") Error in salary. Should not contain letters or special symbols\n");
            }
            else{
                salaryFin = Integer.parseInt(salary);
            }
            if (falseRadioBtn.isSelected()) {
                experienceFin = 0;
                education = "Higher education.Bachelor/Master degree";
            }
            else {
                educationField.setDisable(false);
                experienceField.setDisable(false);
                if (!ua.khpi.oop.mishchenko16.RegexCheck.validateInt(experience)) {
                    add = false;
                    sb.append(i++).append(") Error in experience. Should not contain letters or special symbols\n");
                } else {
                    experienceFin = Integer.parseInt(experience);
                }

                if (!ua.khpi.oop.mishchenko16.RegexCheck.validateText(education)) {
                    add = false;
                    sb.append(i++).append(") Error in education. Should not contain digits or special symbols\n");
                }
            }

            if (add) {
                Agency agency = new Agency(firmName,position,circs,salaryFin,true,new Agency.Requierments(experienceFin,education));
                Collections.list.add(agency);
                Collections.agenciesObservableList.add(agency);
                signUpButton.getScene().getWindow().hide();
            } else {
                Warning.showAlertWithHeaderText(sb.toString());
            }
        });

    }
}
