module EffortLoggerV2CSE360 {
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	//requires org.junit.jupiter.api;
	exports application.Prototype1;
	exports application.Prototype2;
	exports application.Prototype5;
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.Prototype1 to javafx.graphics, javafx.fxml;
	opens application.Prototype2 to javafx.graphics, javafx.fxml;
	opens application.Prototype3 to javafx.graphics, javafx.fxml;
	opens application.Prototype5 to javafx.graphics, javafx.fxml;
}
