module com.swgame.noodlesthecat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.swgame.noodlesthecat to javafx.fxml;
    exports com.swgame.noodlesthecat.NoodlesGUI;
    opens com.swgame.noodlesthecat.NoodlesGUI to javafx.fxml;
    exports com.swgame.noodlesthecat.rooms;
    opens com.swgame.noodlesthecat.rooms to javafx.fxml;
}