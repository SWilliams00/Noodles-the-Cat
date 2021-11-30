module com.example.noodlesthecat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.noodlesthecat to javafx.fxml;
    exports com.example.noodlesthecat;
}