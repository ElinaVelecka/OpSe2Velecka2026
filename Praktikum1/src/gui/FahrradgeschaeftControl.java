package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Fahrrad;
import business.FahrradgeschaeftModel;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class FahrradgeschaeftControl {
	
	private FahrradgeschaeftModel fahrradgeschaeftModel;
	private FahrradgeschaeftView fahrradgeschaeftView;
	
	
	public FahrradgeschaeftControl(Stage primaryStage) {

		this.fahrradgeschaeftModel = new FahrradgeschaeftModel();
		this.fahrradgeschaeftView = new FahrradgeschaeftView(this, primaryStage, fahrradgeschaeftModel);
	}
	
	 public void leseAusDatei(String typ) {
	    	try {
	      		if("csv".equals(typ)){
	      			
	      			this.fahrradgeschaeftModel.leseAusDatei(typ);
	      				
	      	  			zeigeInformationsfensterAn(
	      	  	   			"Das Fahrrad wurde gelesen!");
	      		}
	       		else{
		   			zeigeInformationsfensterAn(
		   				"Noch nicht implementiert!");
		   		}
			}
			catch(IOException exc){
				zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
			}
			catch(Exception exc){
				zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
			}
		}
			
		public void schreibeFahrraederInCsvDatei()  {
			try {
				this.fahrradgeschaeftModel.schreibeFahrraederInCsvDatei();
	   			zeigeInformationsfensterAn(
		   			"Die Fahrraeder wurden gespeichert!");
			}	
			catch(IOException exc){
				zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
			}
			catch(Exception exc){
				zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Speichern!");
			}
		}
		
		 private void zeigeInformationsfensterAn(String meldung){
		    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
		    		"Information", meldung).zeigeMeldungsfensterAn();
		    }	
		    
		    void zeigeFehlermeldungsfensterAn(String meldung){
		       	new MeldungsfensterAnzeiger(AlertType.ERROR,
		        	"Fehler", meldung).zeigeMeldungsfensterAn();
		    }

		
	
	
	

}
