package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Appointment;
import models.ResourceAppointment;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Observable;

public class ControllerAdd extends Observable{


    private int count;
    private Appointment appointment;
    @FXML private MenuItem exit,about;
    private ResourceAppointment resourceAppointment = ResourceAppointment.getInstance();
    private ObservableList<String> itemP = FXCollections.observableArrayList("None","!!!","!","!");
    private ObservableList<String> itemR = FXCollections.observableArrayList("None","Daily","Weekly","Monthly");
    private ObservableList<String> itemH = FXCollections.observableArrayList("00","01","02","03","04",
            "05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23");
    private ObservableList<String> itemM = FXCollections.observableArrayList("00","05","10","15","20",
            "25","30","35","40","45","50","55","50","55");


    @FXML private Button add;
    @FXML private ChoiceBox priority,repeat;
    @FXML private ComboBox hour;
    @FXML private ComboBox minute;
    @FXML private TextField field;
    @FXML private DatePicker datePicker;
    @FXML private TextArea notes;


    //set
    @FXML
    private void initialize(){
        priority.setValue("None");
        priority.setItems(itemP);
        datePicker.setValue(LocalDate.now());
        hour.setValue("00");
        hour.setItems(itemH);
        minute.setValue("00");
        minute.setItems(itemM);
        repeat.setValue("None");
        repeat.setItems(itemR);

    }
    //method
    @FXML
    public  void exitMenu(ActionEvent e){
        closePage();
    }

    @FXML
    public void handleButton(ActionEvent e){

        try {
            appointment = addAppointment();
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        finally {
            closePage();
        }
       // System.out.println(resourceAppointment.getListAppointment());
        setChanged();
        notifyObservers(appointment);
    }

    public Appointment addAppointment() throws ParseException{
        LocalDate time = datePicker.getValue();
        //debug getValue
//        System.out.println(time.toString());
//        System.out.println(time.getYear());
//        System.out.println(time.getMonthValue());
//        System.out.println(time.getDayOfMonth());
//        System.out.println(field.getText());
//        System.out.println(hour.getValue().toString());
//        System.out.println(minute.getValue().toString());
//        System.out.println(priority.getValue().toString());
//        System.out.println(repeat.getValue().toString());
//        System.out.println(notes.getText());
        //public Appointment(int id,String nameEvent,
        // int day, int month, int year, String hour, String minute, String priority,String repeat,St
          Appointment appointment = new Appointment(count ,field.getText(),time.getDayOfMonth(),time.getMonthValue(),
                time.getYear(),hour.getValue().toString(),minute.getValue().toString(),priority.getValue().toString(),
                  repeat.getValue().toString(),notes.getText());
       // Appointment appointment = new Appointment(count,"",1,2,2017,"00","00","None","None","");
        //debug event
//        System.out.println(event.getNameEvent());
//        System.out.println(event.getPriority());
//        System.out.println(event.getDate());
        //resourceAppointment.addApointment(appointment);
//        System.out.println(resourceAppointment.getListAppointment());
        return appointment;

    }

    public void closePage(){
        // get a handle to the stage
        Stage stage = (Stage) add.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void setCount(int c){
        count = c;

    }




}
