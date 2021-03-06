package application;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class JDBCController implements Initializable {

    @FXML
    private ListView<String> MinuList;

    @FXML
    private ListView<String> OrderList;

    @FXML
    private Button AddBtn;
    @FXML
    private Button CheckBtn;

    @FXML
    private RadioButton RadioDin;

    @FXML
    private RadioButton RidoTake;

    @FXML
    private TextField name;
    
    
    Coffee[] cof = new Coffee[4];
    
    @FXML
    void OnAddBtn(ActionEvent event) {
    	ObservableList<String> nlist = nlist = FXCollections.observableArrayList();
    	nlist = MinuList.getSelectionModel().getSelectedItems();
		OrderList.getItems().addAll(nlist);
    }

    @FXML
    void OnRidioDin(ActionEvent event) {

    }

    @FXML
    void OnRidoTake(ActionEvent event) {

    }
    double price;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		    Connection	con= null;
			Statement stmt=null ;
			ResultSet rs=null ;
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
			String db= "C:\\Users\\omarh\\git\\OmarAprilJDBC\\OmarAprilJDBC\\src\\CoffeeShope.accdb";
			
			String path="jdbc:ucanaccess://"+db;
			
			con= DriverManager.getConnection(path);
			
			stmt= con.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM Coffee");
			
			int i = 0;
			
			while (rs.next()) {
				String Coffee = rs.getString(2);
				 price = rs.getDouble(3);
				cof[i]= new Coffee(Coffee, price);
				MinuList.getItems().add(Coffee+"$"+price);
						
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public double sum (double x)
	{
		int i = 0;
		return i+=x;
	}
	@FXML
    void OnCheckBtn(ActionEvent event) {
		
		Alert win = new Alert (AlertType.INFORMATION);
		win.setTitle("Total bill");
		win.setHeaderText(null);
		if (RadioDin.isSelected()) {
			win.setContentText(name.getText()+" Please pay $"+sum(price)+" For Dine In ");
		}
		else
		{
			win.setContentText(name.getText()+" Please pay $"+sum(price)+" For Take Away");
		}
		
		win.showAndWait();
    }

}
