package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ResourceAppointment {
    private static ResourceAppointment instance = null;
    protected ResourceAppointment() {
        // Exists only to defeat instantiation.
    }
    public static ResourceAppointment getInstance() {
        if (instance == null) {
            instance = new ResourceAppointment();
        }
        return instance;
    }

    private ObservableList<Appointment> listAppointments = FXCollections.observableArrayList();

    public  void addApointment(Appointment appointment){
        getListAppointment().add(appointment);
    }

    public ObservableList<Appointment> getListAppointment() {
        return listAppointments;
    }

    public void setListAppointments(ObservableList<Appointment> observableList){
        listAppointments = observableList;
    }

    public void deleteAp(Appointment appointment){
        listAppointments.remove(appointment);
    }

    public int countSet(){
        if(listAppointments.isEmpty()){
            return 1;
        }
        return (listAppointments.get(listAppointments.size()-1).getId()+1);
    }
}
